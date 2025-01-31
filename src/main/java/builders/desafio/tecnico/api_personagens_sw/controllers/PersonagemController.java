package builders.desafio.tecnico.api_personagens_sw.controllers;

import builders.desafio.tecnico.api_personagens_sw.dto.DadosCadastroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.dto.DadosRegistroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> obterPersonagensPeloNome(
            @RequestParam String search) {
        List<DadosRegistroPersonagem> personagens = this.service.obterPersonagemPeloNome(search);

        Map<String, Object> response = new HashMap<>();
        response.put("count", personagens.size());
        response.put("next", null);
        response.put("previous", null);
        response.put("results", personagens);
        return ResponseEntity.ok(response);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> cadastrarNovoPersonagem(@RequestBody DadosCadastroPersonagem dados) {
        DadosRegistroPersonagem personagem = this.service.cadastrarNovoPersonagem(dados);

        Map<String, Object> response = new HashMap<>();
        response.put("count", 1);
        response.put("next", null);
        response.put("previous", null);
        response.put("results", List.of(personagem));
        var uri = UriComponentsBuilder.fromPath("/personagens/" + personagem.nome()).build().toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
