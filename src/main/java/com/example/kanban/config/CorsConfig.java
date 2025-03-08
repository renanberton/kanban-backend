package com.example.kanban.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configura as permissões de CORS para todas as rotas da aplicação
        registry.addMapping("/**") // Aplica CORS para todas as rotas
                .allowedOrigins("http://localhost:5173") // Permite CORS para a origem do React (ajuste conforme necessário)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite os métodos HTTP que você precisa
                .allowedHeaders("*") // Permite qualquer cabeçalho
                .allowCredentials(true); // Permite envio de cookies/credenciais (se necessário)
    }
}
