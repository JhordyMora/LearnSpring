package com.moraTabares.LearnSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan
@ComponentScan({"controller", "models"
//              La etiqueta de @ComponentScan si esta sola hace que se busque todos los componentes dentro de esta
//              mismo package, pero si se usa con valores adentros @ComponentScan({..", "..."}) olvida el actual y solo
//              se enfoca en los que estan escritos (ha excepcion de esta clase) asi que se tiene que poner otra vez aqui
//              otra vez si hay mas archivos con @Configutarion o cualquier otra etiqueta o componente de spring.
//              Cuidado: Este es mi suposicion y no estoy 100%
				,"com.moraTabares.LearnSpring"
})
public class LearnSpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringWebApplication.class, args);
    }

}
