package br.com.userede.RedeFace.message;

import br.com.userede.RedeFace.user.Usuario;
import br.com.userede.RedeFace.user.UsuarioService;
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
    public void EnvioMensagem(String emailOrigem, String emailDestino, String mensagem){
        Mensagem novaMensagem = new Mensagem();
        if (usuarioService.usuarioExistente(emailOrigem) && usuarioService.usuarioExistente(emailDestino) ){
            Usuario usuarioOrigem = usuarioService.buscarUsuarioPorEmail(emailOrigem);
            novaMensagem.setOrigem(usuarioOrigem);
            novaMensagem.setMensagem(mensagem);
            novaMensagem.setVisualizado(false);
            mensagemRepository.save(novaMensagem);
        }else{
            throw new RuntimeException("Email não cadastrado!");
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
    public Boolean mensagemVisualizada(Mensagem mensagem){
        if (mensagem.getVisualizado()==false){
            return true;
        }else{
            return false;
        }
    }
    public Mensagem visualizarMensagem(int id){
        if(mensagemExistente(id)){
            Mensagem pesquisaMensagem = buscarMensagemId(id);
            if (mensagemVisualizada((pesquisaMensagem))){
                pesquisaMensagem.setVisualizado(true);
                mensagemRepository.save(pesquisaMensagem);
            }
            return pesquisaMensagem;
        }
        throw new RuntimeException("Mensagem não foi encontrada!");
    }

}
