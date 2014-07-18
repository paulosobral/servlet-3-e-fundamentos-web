package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		// PODEMOS REMOVER O ATRIBUTO PARA DESLOGAR:
		req.getSession().removeAttribute("usuario.logado");
		
		// REDIRECIONAO CLIENTE PARA A PÁGINA LOGOUT.HTML (CÓDIGO 302):
		// NÃO QUEREMOS QUE O USUÁRIO VEJA ESTA PÁGINA, ENTÃO POR SEGURANÇA COLOCAMOS
		// NO DIRETÓRIO PROTEGIDO WEB-INF. PORÉM POR ESTAR PROTEGIDO, O ARQUIVO NÃO É ENCONTRADO:
		// resp.sendRedirect("WEB-INF/paginas/logout.html");
		
		// TEMOS QUE UTILIZAR O SERVIDOR PARA DESPACHAR, PEGUE ESTA REQUISIÇÃO E REDIRECIONE!!!
		// ASSIM O CLIENTE NÃO FICA SABENDO DA URI, SE ELE DER O REFRESH NO NAVEGADOR ELE EXECUTA A PRIMEIRA URL:
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
	}

}
