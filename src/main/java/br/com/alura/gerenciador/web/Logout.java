package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// TEMPO ENTRE DUAS REQUISIÇÕES (Ñ ENTRE A PRIMEIRA E ULTIMA!!!) (OPCIONAL), 10 MIN:
		req.getSession().setMaxInactiveInterval(10 * 60);
		
		// PODEMOS REMOVER O ATRIBUTO PARA DESLOGAR:
		req.getSession().removeAttribute("usuario.logado");
		
		// MATA A SESSÃO INTEIRA:
		// req.getSession().invalidate();

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Deslogado com sucesso!</body></html>");

	}

}
