package builders.desafio.tecnico.api_personagens_sw.dto;

import java.util.List;

public record DadosResponseSwapi(Integer count, List<DadosResult> results) {
}
