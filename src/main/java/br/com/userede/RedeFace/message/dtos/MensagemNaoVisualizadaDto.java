package br.com.userede.RedeFace.message.dtos;

import java.util.List;

public class MensagemNaoVisualizadaDto {
    private int quantidade;
    private List<MensagemDto> mensagensNaoVisualizadas;

    public MensagemNaoVisualizadaDto() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<MensagemDto> getMensagensNaoVisualizadas() {
        return mensagensNaoVisualizadas;
    }

    public void setMensagensNaoVisualizadas(List<MensagemDto> mensagensNaoVisualizadas) {
        this.mensagensNaoVisualizadas = mensagensNaoVisualizadas;
    }
}
