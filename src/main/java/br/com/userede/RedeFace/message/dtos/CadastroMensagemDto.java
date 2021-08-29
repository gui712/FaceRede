package br.com.userede.RedeFace.message.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastroMensagemDto {
    private String mensagem;
    @NotNull(message = "{validacao.mensagem.origem}")
    @NotBlank(message = "{validacao.mensagem.origem}")
    private String origem;
    @NotNull(message = "{validacao.mensagem.destino}")
    @NotBlank(message = "{valicao.mensagem.destino}")
    private String destino;

    public CadastroMensagemDto() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
