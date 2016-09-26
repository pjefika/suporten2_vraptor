<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<c:if test="${not empty mensagemFalha}">
	<span class="alert alert-danger" role="alert"> <span
		class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></span>
		${mensagemFalha}
	</span>
</c:if>
<br>
<div class="page-header">
	<h2>Login</h2>
</div>
<div class="form-inline">
	<form action="${linkTo[UsuarioController].login}" method="post">
		<div class="form-group">
			<label for="login">Login</label> <input
				type="text" class="form-control" id="login"
				placeholder="Login">
		</div>
		<div class="form-group">
			<label for="senha">Senha</label> <input
				type="password" class="form-control" id="senha"
				placeholder="Senha">
		</div>
		<button type="submit" class="btn btn-default">Login</button>
	</form>
</div>
