package builders.desafio.tecnico.api_personagens_sw.model;

import builders.desafio.tecnico.api_personagens_sw.dto.DadosCadastroPersonagem;
import builders.desafio.tecnico.api_personagens_sw.util.Genero;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "personagem")
@Entity(name = "Personagem")
@EqualsAndHashCode(of = "id")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double altura;
    private Double massa;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String anoDeNascimento;
    private String descricao;
    private String emailAutor;

    public Personagem(){}

    public Personagem(String nome, Double altura, Double massa, Genero genero, String anoDeNascimento, String descricao, String emailAutor) {
        this.nome = nome;
        this.altura = altura;
        this.massa = massa;
        this.genero = genero;
        this.anoDeNascimento = anoDeNascimento;
        this.descricao = descricao;
        this.emailAutor = emailAutor;
    }

    public Personagem(Long id, String nome, Double altura, Double massa, Genero genero, String anoDeNascimento, String descricao, String emailAutor) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.massa = massa;
        this.genero = genero;
        this.anoDeNascimento = anoDeNascimento;
        this.descricao = descricao;
        this.emailAutor = emailAutor;
    }

    public Personagem(DadosCadastroPersonagem dados) {
        this.nome = dados.nome();
        this.altura = dados.altura();
        this.massa = dados.massa();
        this.genero = dados.genero();
        this.anoDeNascimento = dados.anoDeNascimento();
        this.descricao = dados.descricao();
        this.emailAutor = dados.emailAutor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getMassa() {
        return massa;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(String anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public void setEmailAutor(String emailAutor) {
        this.emailAutor = emailAutor;
    }
}
