package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;


public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse response) {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		// VERIFICA SE USUÁRIO EXISTE:
		if(usuario == null)
		{
			return "/WEB-INF/paginas/login-invalido.html";
		}
		else
		{
			// PEGA A SESSÃO DO USUÁRIO:
			HttpSession session = req.getSession();
			
			// COLOCA ATRIBUTO NA SESSÃO:
			session.setAttribute("usuarioLogado", usuario);
			
			return "/WEB-INF/paginas/usuario-logado.jsp";
		}
		
	}
	
	
}
