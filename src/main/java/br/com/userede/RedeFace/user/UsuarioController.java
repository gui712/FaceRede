package br.com.userede.RedeFace.user;

import br.com.userede.RedeFace.message.Mensagem;
import br.com.userede.RedeFace.message.dtos.MensagemDto;
import br.com.userede.RedeFace.message.dtos.MensagemNaoVisualizadaDto;
import br.com.userede.RedeFace.user.Usuario;
import br.com.userede.RedeFace.user.UsuarioService;
import br.com.userede.RedeFace.user.dtos.CadastroUsuarioDto;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
   private UsuarioService usuarioService;
   private ModelMapper modelMapper;
   @Autowired
   public UsuarioController(UsuarioService usuarioService, ModelMapper modelMapper){
      this.usuarioService = usuarioService;
      this.modelMapper = modelMapper;
   }
   @ResponseStatus(HttpStatus.CREATED)
   @PostMapping
   public Usuario cadastrarUsuario(@RequestBody @Valid CadastroUsuarioDto cadastroUsuarioDto){
      return usuarioService.cadastrarUsuario((modelMapper.map(cadastroUsuarioDto,Usuario.class)));
   }
   @GetMapping("/perfil/{emailUsuario}")
   public MensagemNaoVisualizadaDto mostrarMensagensNãoVisualizadas(@PathVariable String emailUsuario){
      MensagemNaoVisualizadaDto mensagens = new MensagemNaoVisualizadaDto();
      List<Mensagem> mensagensModel = usuarioService.pesquisarPorMensagensNãoVisualizadas(emailUsuario);
      mensagens.setMensagensNaoVisualizadas(mensagensModel.stream().map(objeto -> new MensagemDto(objeto.getId())).collect(Collectors.toList()));
      mensagens.setQuantidade(mensagensModel.size());
      return mensagens;
   }
}
