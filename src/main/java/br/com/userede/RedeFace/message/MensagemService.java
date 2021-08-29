package br.com.userede.RedeFace.message;

import br.com.userede.RedeFace.user.Usuario;
import br.com.userede.RedeFace.user.UsuarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MensagemService {
    private MensagemRepository mensagemRepository;
    private UsuarioService usuarioService;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository, UsuarioService usuarioService) {
        this.mensagemRepository = mensagemRepository;
        this.usuarioService = usuarioService;
    }

    public void EnviarMensagem(String emailOrigem, String emailDestino, String mensagem) throws NotFoundException {
        Mensagem novaMensagem = new Mensagem();
        if (usuarioService.usuarioExistente(emailOrigem) & usuarioService.usuarioExistente(emailDestino)){
            Usuario usuarioOrigem = usuarioService.buscarUsuarioPorEmail(emailOrigem);
            novaMensagem.setOrigem(usuarioOrigem);

            Usuario usuarioDestino = usuarioService.buscarUsuarioPorEmail(emailDestino);
            novaMensagem.setMessage(mensagem);
            novaMensagem.setVisualizado(false);
            novaMensagem.setDestino(usuarioDestino);
            mensagemRepository.save(novaMensagem);
        }else{
            throw new RuntimeException("Email não encontrado! ");
        }
    }
    public Boolean mensagemExistente(int id){
        return mensagemRepository.existsById(id);
    }
    public Mensagem buscarMensagemId(int id){
        Optional<Mensagem> optionalMensagem = mensagemRepository.findById(id);
        if (optionalMensagem.isPresent()){
            return optionalMensagem.get();
        }
        throw new RuntimeException("Mensagem não foi encontrada!");
    }


}
