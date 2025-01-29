package builders.desafio.tecnico.api_personagens_sw.repository;

import builders.desafio.tecnico.api_personagens_sw.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    List<Personagem> findByNomeIgnoreCaseContaining(String nome);

    boolean existsByNome(String nome);
}
