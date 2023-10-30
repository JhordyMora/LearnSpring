package Controller;

import Models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    @GetMapping(value = "/index") // se puede usar el get mapping para hacer el metodo get como default
//    @RequestMapping(value = {"/index", "/inicio", "/"}, method = RequestMethod.GET) // esto se puede hacer para asigna el metodo a varios urls
//    public String index(Model model) { // Model es una interfaz y ModelMap es una clase
//    public String index(ModelMap model){
    public String index(Map<String, Object> map){
//        model.addAttribute("titulo", "Hola Spring Framework! Mi perrito"); // este metodo se usa con Model y ModelMap
        map.put("titulo", "Hola Spring Framework con map!");
        return "index";// aqui se pone el nombre del html que esta en templates sin la extencion. Spring lo encuentra automaticamente
    }
// otra manera en con ModelAndView, esta es igual que el model anterior pero se le tiene que especificar con un metodo cual es la view(template) a usar
    @RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
    public ModelAndView indexTwo(ModelAndView mv){
        mv.addObject("titulo", "Hola Spring Framework con modelAndView!");
        mv.setViewName("indexTwo");
        return mv;
    }

    @GetMapping(value = "/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Jhordy");
        usuario.setApellido("Mora");
        usuario.setEmail("jhordy@mail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: " + usuario.getNombre());
//        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre())); // otra manera de concatenar
        return "perfil";
    }
    @GetMapping(value = "/listar")
    public String listar(Model model){
        Collection<Usuario> usuarios = List.of();
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }

}


