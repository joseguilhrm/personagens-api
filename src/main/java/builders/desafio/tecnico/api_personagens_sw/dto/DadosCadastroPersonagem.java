package builders.desafio.tecnico.api_personagens_sw.dto;

import builders.desafio.tecnico.api_personagens_sw.util.Genero;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPersonagem(
        @NotBlank
        String nome,

        @NotNull
        Double altura,

        @NotNull
        Double massa,

        @NotNull
        Genero genero,

        @NotBlank
        String anoDeNascimento,

        @NotBlank
        String descricao,

        @NotBlank
        @Email
        String emailAutor
) {
}
