package br.com.userede.RedeFace.message.dtos;

public class MensagemDto {

    private int id;

    public MensagemDto(){}

    public MensagemDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
