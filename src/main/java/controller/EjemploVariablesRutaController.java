package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parametros de la ruta (@PathVariable)");
        return "variables/index";
    }
    @GetMapping("/string/{texto}")
    // muy parecido a las anotaciones en ParamsController se puede hacer  de esta manera
    // public String variable(@PathVariable String texto). Mirar esa clase para mas tips
    public String variable(@PathVariable(name = "texto") String textoEnMetodo, Model model) {
        model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + textoEnMetodo);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    // muy parecido a las anotaciones en ParamsController se puede hacer  de esta manera
    // public String variable(@PathVariable String texto). Mirar esa clase para mas tips
    public String variable(@PathVariable(name = "texto") String textoEnMetodo, @PathVariable Integer numero,
                           Model model) {
        model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + textoEnMetodo +
                                        " y el numero " + numero);
        return "variables/ver";
    }
}