package builders.desafio.tecnico.api_personagens_sw.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosNomePersonagem(
        @NotBlank(message = "O nome do personagem deve ser informado.")
        String nome) {
}
