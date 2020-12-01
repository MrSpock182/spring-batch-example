package br.com.alura.springbatch.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class UsuarioDb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioDb{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
