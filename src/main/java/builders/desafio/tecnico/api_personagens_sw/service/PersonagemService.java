package builders.desafio.tecnico.api_personagens_sw.service;

import builders.desafio.tecnico.api_personagens_sw.dto.DadosCadastroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.dto.DadosRegistroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.dto.DadosResponseSwapi;
import builders.desafio.tecnico.api_personagens_sw.dto.DadosResult;
import builders.desafio.tecnico.api_personagens_sw.model.Personagem;
import builders.desafio.tecnico.api_personagens_sw.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository repository;

    public List<DadosRegistroPersonagem> obterPersonagemPeloNome(String nome) {
        List<Personagem> personagens = this.repository.findByNomeIgnoreCaseContaining(nome);
        return personagens.stream().map(DadosRegistroPersonagem::new).toList();
    }

    public DadosRegistroPersonagem cadastrarNovoPersonagem(DadosCadastroPersonagem dados) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DadosResponseSwapi> response = restTemplate.getForEntity("https://swapi.dev/api/people?search=" + dados.nome(), DadosResponseSwapi.class);

        if (response.getBody().count() >= 1) {
            if (response.getBody().results().stream().map(DadosResult::name).anyMatch(n -> n.equals(dados.nome()))) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Personagem já cadastrado.");
            }
        }
        else if (this.repository.existsByNome(dados.nome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Personagem já cadastrado.");
        }

        return new DadosRegistroPersonagem(this.repository.save(new Personagem(dados)));
    }
}
