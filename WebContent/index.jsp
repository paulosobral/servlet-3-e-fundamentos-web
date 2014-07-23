<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<!-- EXEMPLO DE USO COM EL (EXPRESSION LANGUAGE), ELE TENTA ENCONTRAR NO REQUEST, SE NÃO ENCONTRAR PROCURA NA SESSÃO: -->
<c:if test="${not empty usuarioLogado}">
Logado como ${usuarioLogado.email}
</c:if>

<br />

<form action="executa?tarefa=novaEmpresa" method="post">
	Nome: <input type="text" name="nome">
	<input type="submit" value="Enviar">
</form>

<br />

<form action="executa" method="post">
<input type="hidden" name="tarefa" value="Login" />
	E-mail: <input type="text" name="email"><br />
	Senha: <input type="text" name="senha"><br />
	<input type="submit" value="Enviar">
</form>

<br />

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Logout" />
	<input type="submit" value="Deslogar">
</form>

</body>
</html>