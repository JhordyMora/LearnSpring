package controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
    @GetMapping("/")
    public String index(
            @RequestParam(name = "texto", required = false, defaultValue = "Hola que tal!") String textoClase,
            Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + textoClase);
        return "params/index";
    }

    @GetMapping("/string")
    // tambien se puede escribir @RequestParam String texto, pero se pierda todas las posibilidades de configuarion
    // que ofrece la anotacion @RequestParam(name = "texto") String texto, ...
    public String param(
            @RequestParam(name = "texto", required = false, defaultValue = "Hola que tal!") String textoClase,
            Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + textoClase);
        return "params/ver";
    }
    // Recibir varios parametros se puede hacer de 2 maneras
    // Manera 1: varios @RequestParam
    @GetMapping("/mix-params")
    // tambien se puede escribir @RequestParam String texto, pero se pierda todas las posibilidades de configuarion
    // que ofrece la anotacion @RequestParam(name = "texto") String texto, ...
    public String param(@RequestParam(name = "saludo") String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + saludo + " y el numero es "
                                        + numero);
        return "params/ver";
    }

    // Manera 2: con HttpServletResponse y capturamos los parametros en variables
    @GetMapping("/mix-params-httpRequest")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        String numero = request.getParameter("numero");
        model.addAttribute("resultado", "El texto enviado es: " + saludo + " y el numero es "
                                        + numero);
        return "params/ver";
    }

}
