<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
Logado como ${usuarioLogado.email}
</c:if>

<br />

<form action="novaEmpresa" method="post">
	Nome: <input type="text" name="nome">
	<input type="submit" value="Enviar">
</form>

<br />

<form action="login" method="post">
	E-mail: <input type="text" name="email"><br />
	Senha: <input type="text" name="senha"><br />
	<input type="submit" value="Enviar">
</form>

<br />

<form action="logout" method="post">
	<input type="submit" value="Deslogar">
</form>

</body>
</html>