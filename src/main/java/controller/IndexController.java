package controller;

import models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexController.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexController.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexController.listar.titulo}")
    private String textoListar;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    @GetMapping(value = "/index") // se puede usar el get mapping para hacer el metodo get como default
//    @RequestMapping(value = {"/index", "/inicio", "/"}, method = RequestMethod.GET) // esto se puede hacer para asigna el metodo a varios urls
//    public String index(Model model) { // Model es una interfaz y ModelMap es una clase
//    public String index(ModelMap model){
    public String index(Map<String, Object> map) {
//        model.addAttribute("titulo", "Hola Spring Framework! Mi perrito"); // este metodo se usa con Model y ModelMap
        map.put("titulo", textoIndex);
        return "index";// aqui se pone el nombre del html que esta en templates sin la extencion. Spring lo encuentra automaticamente
    }

    // otra manera en con ModelAndView, esta es igual que el model anterior pero se le tiene que especificar con un metodo cual es la view(template) a usar
    @RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
    public ModelAndView indexTwo(ModelAndView mv) {
        mv.addObject("titulo", "Hola Spring Framework con modelAndView!");
        mv.setViewName("indexTwo");
        return mv;
    }

    @GetMapping(value = "/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Carmen");
        usuario.setApellido("Mora");
        usuario.setEmail("jhordy@mail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil + usuario.getNombre());
//        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre())); // otra manera de concatenar
        return "perfil";
    }

    @GetMapping(value = "/listar")
    public String listar(Model model) {
        Collection<Usuario> usuarios = List.of(new Usuario("Juan", "Malo", "malo@mail.com")
                , new Usuario("Orlando", "Ramirez", "ramirez@mail.com")
                , new Usuario("Pedro", "Mora", "mora@mail.com"));
        model.addAttribute("titulo", textoListar);
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }

    @GetMapping(value = "/listarModelAtributeAnotation")
    public String listarModelAtributeAnotation(Model model) {
        model.addAttribute("titulo", "Listado de usuarios con anotacion Model Attribute");
        return "listarModelAtributeAnotation";
    }
    @ModelAttribute("usuarios")
    // esta anotacion sirve como la clase Model vista anteriormente pero ahora se pude usar una anotacion para agregar los atributos a la clase model. 
    // Estos atributos visible para todos los metodos de esta clase que tengan la clase Model como parametro,
    // y lo que hace esta anotacion es escribir model.addAttribute("usuarios", la lista generada aqui)
    public List<Usuario> listaUsarios(){
        return List.of(new Usuario("Juan", "Malo", "malo@mail.com")
                , new Usuario("Orlando", "Ramirez", "ramirez@mail.com")
                , new Usuario("Pedro", "Mora", "mora@mail.com"));
    }
}


