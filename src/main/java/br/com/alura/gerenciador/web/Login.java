package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		
		// VERIFICA SE USUÁRIO EXISTE:
		if(usuario == null)
		{
			writer.println("<html><body>Usuário inválido!</body></html>");
		}
		else
		{
			
			// CRIA UM COOKIE E ENVIA PARA O CLIENTE:
			Cookie cookie = new Cookie("usuario.logado",usuario.getEmail());
			resp.addCookie(cookie);
			
			writer.println("<html><body>Usuário logado: "+usuario.getEmail()+"</body></html>");
		}
	}
	
}
