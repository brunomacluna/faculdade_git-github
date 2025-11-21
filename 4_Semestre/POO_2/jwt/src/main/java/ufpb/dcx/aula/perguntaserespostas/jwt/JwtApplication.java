package ufpb.dcx.aula.perguntaserespostas.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import ufpb.dcx.aula.perguntaserespostas.jwt.filtros.FiltroDeJWT;

@SpringBootApplication
public class JwtApplication {

    @Bean
    public FilterRegistrationBean<FiltroDeJWT> filterJwt() {
        FilterRegistrationBean<FiltroDeJWT> filtroJwt = new FilterRegistrationBean<FiltroDeJWT>();
        filtroJwt.setFilter(new FiltroDeJWT());

        // Proteger TODAS as rotas, o filtro decide quais são públicas
        filtroJwt.addUrlPatterns("/v1/api/*");

        System.out.println("Filtro JWT configurado para: /v1/api/*");
        return filtroJwt;
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
        System.out.println("Aplicação JWT iniciada com sucesso!");
        System.out.println("H2 Console: http://localhost:8080/v1/api/h2");
        System.out.println("Login: sa | Senha: (vazia)");
    }
}
