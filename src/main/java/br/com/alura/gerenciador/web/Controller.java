package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");

		// CASO A TAREFA SEJA NULA, SOLTA EXCEÇÃO:
		if (tarefa == null)
			throw new IllegalArgumentException(
					"Você esqueceu de passar a tarefa!");

		// CASO EXISTA, MONTA O NOME COMPLETO DA CLASSE COM O PACOTE:
		tarefa = "br.com.alura.gerenciador.web." + tarefa;

		// TENTA ENCONTRAR A TAREFA (CLASSE)
		try {

			// ENCONTRA A CLASSE EM TEMPO DE COMPILAÇÃO:
			Class<?> tipo = Class.forName(tarefa);


		    /* INSTÂNCIA UM OBJETO DESTA CLASSE EM UM OBJETO TIPO ABSTRATO DA INTERFACE
		     TAREFA (TODOS TEM QUE TER ESTE MÉTODO EXECUTA, PARA ISSO REALIZAMOS O CAST): */
			Tarefa instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(req, resp);

			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);

		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {

			throw new ServletException(e);
		}

	}

}
