package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// CAST PARA HTTP SERVLET REQUEST
		HttpServletRequest req = (HttpServletRequest) request;

		// PEGA A URI:
		String uri = req.getRequestURI();

		System.out.println("Usuário " + this.getUsuario(req)
				+ " acessando a URI: " + uri);

		// CONTINUA COM A CADEIA EXECUÇÃO DE SERVLETS, FILTERS, ETC:
		chain.doFilter(request, response);

	}

	// RECUPERA O COOKIE DE USUÁRIO LOGADO CASO EXISTA:
	private String getUsuario(HttpServletRequest req) {
		String usuario = "<deslogado>";
		Cookie[] cookies = req.getCookies();
		if (cookies == null)
			return usuario;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				usuario = cookie.getValue();
			}
		}

		return usuario;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
