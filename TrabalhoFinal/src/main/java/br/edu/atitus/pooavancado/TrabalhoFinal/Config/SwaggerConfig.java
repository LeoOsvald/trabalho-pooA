package br.edu.atitus.pooavancado.TrabalhoFinal.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Sitema de Pedidos - Trabalho Final")
						.description("Sistema criado com base nas aulas de POO po L. Osvald")
						.version("Versão 1.0.0")
						.contact(new Contact()
								.name("Developer")
								.email("leonardo98.vendas@gmail.com")));
	}

}