package br.com.userede.RedeFace.user;

import br.com.userede.RedeFace.message.Mensagem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String sobrenome;
    @Id
    private String email;
    @Column(nullable = false, length = 50)
    private String cargo;
    @OneToMany(mappedBy = "origem")
    private List<Mensagem> mensagems;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public Usuario(String nome, String sobrenome, String email, String cargo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cargo = cargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Mensagem> getMessages() {
        return mensagems;
    }

    public void setMessages(List<Mensagem> mensagems) {
        this.mensagems = mensagems;
    }
}
