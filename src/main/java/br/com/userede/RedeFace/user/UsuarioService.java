package br.com.userede.RedeFace.user;

import br.com.userede.RedeFace.message.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public Boolean usuarioExistente(String email){
        return usuarioRepository.existsById(email);
    }
    public Usuario buscarUsuarioPorEmail(String email){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(email);
        if (usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }
        throw new RuntimeException("Usuario não cadastrado !");
    }
    public List<Mensagem> pesquisarPorMensagensNãoVisualizadas(String email){

    }

}
