package br.com.userede.RedeFace.message;

import br.com.userede.RedeFace.message.dtos.CadastroMensagemDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/chat")
public class MensagemController {
    @Autowired
    private MensagemService mensagemService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void enviarMensagem(@RequestBody @Valid CadastroMensagemDto mensagemDto) throws NotFoundException {
        mensagemService.EnviarMensagem(mensagemDto.getOrigem(), mensagemDto.getDestino(), mensagemDto.getMensagem());
    }

    @GetMapping("/{idMensagem}")
    public Mensagem visualizarMensagem(@PathVariable int idMensagem){
        return mensagemService.visualizarMensagem(idMensagem);
    }

}
