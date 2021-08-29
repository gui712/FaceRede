package br.com.userede.RedeFace.user;

import br.com.userede.RedeFace.message.Mensagem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
   @Query("select m from Mensagem m where m.visualizado = false and m.destino.email =?1")
    public List<Mensagem> mostrarMensagemNãoVisualizada(String email);
}
