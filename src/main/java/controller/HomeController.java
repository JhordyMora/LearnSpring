package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //    Hay dos maneras de ir a una pagina dentro de un entorno del proyecto. Redirect y forward. En redirect al
    //    escribir la url en el navegador va a cambiar a la url a la que estamos redirigiendo. Esto significa que
    //    hace una llamada http a la ruta y todos los parametros que hayamos tenido en la url como la misma url se
    //    pierden. Si es interna la busqueda, se busca el controlador, carga la vista y lo que tenga que hacer
    //    spring para mostrar la pagina desde 0.
    //    En caso con forward nos va a mostrar la misma url sin mostrarnos la url a la pagina a las que nos fue
    //    redirigida ademas de mantener los parametros en la url. Este forward utiliza un metodo llamado handler para
    //    hacer eso, este no reinicia ni hace nada que cargue de nuevo el controlador de spring

    @GetMapping("/")
    public String home() {
//        Para redirigirse a otra pagina interna desde otro controlador se usa redirect y la direccion sin poner html
        return "redirect:/app/index";
    }

    @GetMapping("/google")
    public String google() {
//        Para redirigirse a otra pagina externa desde otro controlador se usa redirect y la pagina normal
        return "redirect:https://google.com";
    }

    @GetMapping("/forwardHome")
    public String homeFoward() {
//        Para redirigirse a otra pagina interna desde otro controlador se usa forward y la direccion sin poner html.
//        Esto no se puede usar para rutas externas
        return "forward:/app/index";
    }
}
