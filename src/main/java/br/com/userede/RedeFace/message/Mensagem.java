package br.com.userede.RedeFace.message;


import br.com.userede.RedeFace.user.Usuario;

import javax.persistence.*;

@Entity
@Table (name = "mensagens")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String message;
    @Column(nullable = true)
    private Boolean visualizado;
    @ManyToOne
    @JoinColumn(name = "usuario_origem", nullable = false)
    private Usuario origem;
    @ManyToOne
    @JoinColumn(name = "usuario_destino", nullable = false)
    private Usuario destino;

    public Mensagem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getVisualizado() {
        return visualizado;
    }

    public void setVisualizado(Boolean visualizado) {
        this.visualizado = visualizado;
    }

    public Usuario getOrigem() {
        return origem;
    }

    public void setOrigem(Usuario origem) {
        this.origem = origem;
    }

    public Usuario getDestino() {
        return destino;
    }

    public void setDestino(Usuario destino) {
        this.destino = destino;
    }
}

