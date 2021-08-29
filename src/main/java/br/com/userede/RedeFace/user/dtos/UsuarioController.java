package br.com.userede.RedeFace.user.dtos;

import br.com.userede.RedeFace.user.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
   private UsuarioService usuarioService;
   private ModelMapper modelMapper;
}
