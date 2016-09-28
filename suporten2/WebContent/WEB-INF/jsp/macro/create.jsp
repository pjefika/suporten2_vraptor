<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<c:if test="${not empty mensagemFalha}">
	<span class="alert alert-danger" role="alert">
	<span class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></span> 
		${mensagemFalha}
	</span>
</c:if>
<br>
<div class="page-header">
	<h2>Cadastro de Macro Motivo</h2>
</div>
<div class="form-inline">
	<form action="${linkTo[MacroMotivoController].add}" method="post">
		<label for="rede">Rede:</label>
		<select class="form-control">
			<c:forEach items="${redeList}" var="rede">
				<option value="${rede.id}">${rede.nome}</option>
			</c:forEach>
		</select>
		<label for="nome">Nome: </label> 
		<input type="text" class="form-control" id="nome"
			placeholder="Nome" name="m.nome"> 
		<c:if test="${not empty errors.from('m.nome')}">
			<span class="alert alert-warning" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"> </span> 
			${errors.from('m.nome')}</span>
		</c:if>
		<button type="submit" class="btn btn-default">Registrar</button>
	</form>
</div>
