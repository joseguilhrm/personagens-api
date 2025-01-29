package builders.desafio.tecnico.api_personagens_sw.service;

import builders.desafio.tecnico.api_personagens_sw.dto.DadosCadastroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.dto.DadosRegistroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.model.Personagem;
import builders.desafio.tecnico.api_personagens_sw.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
        if (this.repository.existsByNome(dados.nome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Personagem já cadastrado.");
        }

        return new DadosRegistroPersonagem(this.repository.save(new Personagem(dados)));
    }
}
