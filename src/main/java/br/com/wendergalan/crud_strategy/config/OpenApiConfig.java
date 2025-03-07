package br.com.wendergalan.crud_strategy.config;

import br.com.wendergalan.crud_strategy.entities.Cliente;
import br.com.wendergalan.crud_strategy.entities.Produto;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSchemas("Cliente", new Schema<Cliente>().example(new Cliente()))
                        .addSchemas("Produto", new Schema<Produto>().example(new Produto())))
                .info(new Info()
                        .title("API de CRUD Dinâmico")
                        .version("1.0")
                        .description("Documentação da API de CRUD dinâmico usando Swagger e Springdoc OpenAPI."));
    }
}

