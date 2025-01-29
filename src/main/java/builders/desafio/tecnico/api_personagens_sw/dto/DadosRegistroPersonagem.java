package builders.desafio.tecnico.api_personagens_sw.dto;

import builders.desafio.tecnico.api_personagens_sw.model.Personagem;
import builders.desafio.tecnico.api_personagens_sw.util.Genero;

public record DadosRegistroPersonagem(Long id, String nome, Double altura, Double massa, Genero genero, String anoDeNascimento, String descricao, String emailAutor) {
    public DadosRegistroPersonagem(Personagem personagem) {
        this(personagem.getId(), personagem.getNome(), personagem.getAltura(), personagem.getMassa(), personagem.getGenero(), personagem.getAnoDeNascimento(), personagem.getDescricao(), personagem.getEmailAutor());
    }
}
