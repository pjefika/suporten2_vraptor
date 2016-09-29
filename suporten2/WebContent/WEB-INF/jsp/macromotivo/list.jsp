<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty mensagem}">
	<span class="alert alert-success" role="alert">
	<span class="glyphicon glyphicon glyphicon-ok" aria-hidden="true"></span> 
		${mensagem}
	</span>
</c:if>
<div class="page-header">
	<h2>Listar Macro Motivos</h2>
</div>
<br>
<a href="${linkTo[MacroMotivoController].create}">Adicionar</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Editar</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${redeList}" var="rede">
			<tr>
				<td>${rede.nome}</td>
				<td>
					<a href="${linkTo[RedeController].edit()}${rede.id}" class="btn btn-default">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>