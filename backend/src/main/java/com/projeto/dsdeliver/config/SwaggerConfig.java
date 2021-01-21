
package com.projeto.dsdeliver.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
     @Bean
    public OpenAPI customOpenApi(){
        
    return new OpenAPI()
            .info(new Info()
             .title("Restfull API com spring boot 2.4.1")
             .version("versao 1")
             .description("api desenvolvida para estudo")
             .termsOfService("http://swagger.io/terms")
             .license(new License().name("Apache 2.0").url("http://springdoc.org")));
        
    }
    
}
