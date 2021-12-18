package br.edu.iftm.upt.trabalhofinal.controller;

import br.edu.iftm.upt.trabalhofinal.models.TipoUsuario;
import br.edu.iftm.upt.trabalhofinal.models.Usuario;
import br.edu.iftm.upt.trabalhofinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private br.edu.iftm.upt.trabalhofinal.repository.UsuarioRepository  usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/novo")
    public ModelAndView cadastrarUsuarioPage() {
        ModelAndView mv = new ModelAndView("cadastro-usuario");
        Usuario usuario = new Usuario();
        mv.addObject("usuario", usuario);
        mv.addObject("mensagem", "Cadastrar novo Usuário");
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView cadastrarUsuarioMetodo(Usuario usuario) {
        System.out.println(usuario);
        usuarioService.salvar(usuario);
        ModelAndView mv = new ModelAndView("cadastro-usuario");
        return mv;
    }

    @GetMapping("/editar")
    public ModelAndView editarUsuarioPage(Long codigo) {
        ModelAndView mv = new ModelAndView("cadastro-usuario");
        Optional<Usuario> usuario = usuarioRepository.findById(codigo);
        mv.addObject("usuario", usuario);
        mv.addObject("mensagem", "Editar Usuário");
        System.out.println(usuario);
        return mv;
    }


    @GetMapping("/listar")
    public ModelAndView listarUsuarioPage() {
        ModelAndView mv = new ModelAndView("listar-usuarios");
        List<Usuario> usuarioList = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarioList);
        System.out.println(usuarioList);
        return mv;
    }

    @PostMapping("/remover")
    public String remover(Long codigo) {
        System.out.println(codigo);
        usuarioRepository.deleteById(codigo);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/login")
    public ModelAndView loginUsuarioPage() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @PostMapping("/login")
    public String loginUsuario(String username, String senha) {
        System.out.println(username + "/////" + senha);
        List<Usuario> usuarioList = usuarioRepository.findByLogin(username);
        System.out.println(usuarioList);
        if(usuarioList.size() > 0){
            if(usuarioList.get(0).getSenha().equals(senha))
                if(usuarioList.get(0).getTipo() == TipoUsuario.ADMIN)
                    return "redirect:/usuarios/listar";
                else
                    return "redirect:/home";
        }
        return "redirect:/usuarios/login";
    }
}
