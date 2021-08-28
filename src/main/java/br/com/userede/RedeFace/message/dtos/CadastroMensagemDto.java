package br.com.userede.RedeFace.message.dtos;

public class CadastroMensagemDto {
    private String mensagem;
    private String origem;
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
