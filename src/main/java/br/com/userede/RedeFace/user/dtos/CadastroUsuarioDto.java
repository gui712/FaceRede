package br.com.userede.RedeFace.user.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class CadastroUsuarioDto {

    @Size(min = 3, message = "{validacao.usuario.nome}")
    private String nome;
    @Size(min = 3, message = "{validacao.usuario.sobrenome}")
    private String sobrenome;
    @Email(message = "{validacao.usuario.email}")
    private String email;
    @Size(min = 5, message = "{validacao.usuario.cargo}")
    private String cargo;

    public CadastroUsuarioDto() {
    }

    public String getNome() {
        return nome;
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
}
