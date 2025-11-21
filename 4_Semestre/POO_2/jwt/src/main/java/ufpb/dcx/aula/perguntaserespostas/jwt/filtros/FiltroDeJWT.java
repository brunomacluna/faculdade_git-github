package ufpb.dcx.aula.perguntaserespostas.jwt.filtros;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import ufpb.dcx.aula.perguntaserespostas.jwt.servicos.ServicoJWT;

public class FiltroDeJWT extends GenericFilterBean {

    public final static int TOKEN_INDEX = 7;

    // Lista de rotas públicas que não precisam de token
    private final List<String> PUBLIC_ROUTES = Arrays.asList(
            "/auth/login",
            "/usuarios",
            "/h2",
            "/h2/",
            "/h2-console",
            "/h2-console/"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest requisicao = (HttpServletRequest) request;
        HttpServletResponse resposta = (HttpServletResponse) response;

        String path = requisicao.getRequestURI();
        String method = requisicao.getMethod();

        System.out.println("🔍 Filtro JWT - Rota acessada: " + method + " " + path);

        // Verificar se é uma rota pública
        if (isPublicRoute(path, method)) {
            System.out.println("Rota pública - acesso liberado");
            chain.doFilter(request, response);
            return;
        }

        // Para rotas protegidas, verificar token
        String header = requisicao.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            System.out.println("Token não encontrado ou mal formatado");
            resposta.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inexistente ou mal formatado!");
            return;
        }

        // Extraindo apenas o token do cabecalho (removendo o prefixo "Bearer ").
        String token = header.substring(TOKEN_INDEX);

        try {
            Jwts.parser().setSigningKey(ServicoJWT.TOKEN_KEY).parseClaimsJws(token).getBody();
            System.out.println("Token válido - acesso permitido");
            chain.doFilter(request, response);

        } catch (SignatureException | ExpiredJwtException | MalformedJwtException |
                 PrematureJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            System.out.println("Token inválido: " + e.getMessage());
            resposta.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido: " + e.getMessage());
        }
    }

    private boolean isPublicRoute(String path, String method) {
        // Remove o context path da aplicação
        String contextPath = "/v1/api";
        if (path.startsWith(contextPath)) {
            path = path.substring(contextPath.length());
        }

        // Rotas públicas
        for (String publicRoute : PUBLIC_ROUTES) {
            if (path.startsWith(publicRoute)) {
                return true;
            }
        }

        // GET em /auth/usuarios/{email} é público
        if (path.startsWith("/auth/usuarios/") && "GET".equalsIgnoreCase(method)) {
            return true;
        }

        return false;
    }
}