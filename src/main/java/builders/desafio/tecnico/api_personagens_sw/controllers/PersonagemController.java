package builders.desafio.tecnico.api_personagens_sw.controllers;

import builders.desafio.tecnico.api_personagens_sw.dto.DadosCadastroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.dto.DadosRegistroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

    @GetMapping
    public ResponseEntity<List<DadosRegistroPersonagem>> obterPersonagensPeloNome(
            @RequestParam (required = false) String search) {
        List<DadosRegistroPersonagem> personagens = this.service.obterPersonagemPeloNome(search);
        return ResponseEntity.ok(personagens);
    }

    @PostMapping
    public ResponseEntity<DadosRegistroPersonagem> cadastrarNovoPersonagem(@RequestBody DadosCadastroPersonagem dados) {
        DadosRegistroPersonagem personagem = this.service.cadastrarNovoPersonagem(dados);
        var uri = UriComponentsBuilder.fromPath("/personagens/" + personagem.nome()).build().toUri();
        return ResponseEntity.created(uri).body(personagem);
    }
}
