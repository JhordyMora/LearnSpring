package com.moraTabares.LearnSpring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
//      classpath dentro de spring se refiere a la carpeta de resources
        @PropertySource(value ="classpath:textos.properties")
})
public class TextosPropertiesConfig {
}
