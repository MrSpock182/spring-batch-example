package br.com.alura.springbatch.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aluno")
public class AlunoSpringBatch {
    @Id
    private String id;
    private String cpf;
    private String nome;
    private String idade;
    private String cidade;
    private Boolean isSaoPaulo;
    private Integer classificacao;
    private Integer qtdAulas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean isSaoPaulo() {
        return isSaoPaulo;
    }

    public void setSaoPaulo(Boolean saoPaulo) {
        isSaoPaulo = saoPaulo;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(Integer qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    @Override
    public String toString() {
        return "AlunoSpringBatch{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", cidade='" + cidade + '\'' +
                ", isSaoPaulo=" + isSaoPaulo +
                ", classificacao='" + classificacao + '\'' +
                ", qtdAulas='" + qtdAulas + '\'' +
                '}';
    }
}
