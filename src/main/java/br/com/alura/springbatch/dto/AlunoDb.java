package br.com.alura.springbatch.dto;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "aluno")
public class AlunoDb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    private String idade;
    private String cidade;
    private Boolean isSaoPaulo;
    private Integer classificacao;
    private Integer qtdAulas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "AlunoDb{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", cidade='" + cidade + '\'' +
                ", isSaoPaulo=" + isSaoPaulo +
                ", classificacao=" + classificacao +
                ", qtdAulas=" + qtdAulas +
                '}';
    }
}
