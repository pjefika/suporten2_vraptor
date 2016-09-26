<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty mensagem}">
	<span class="alert alert-success" role="alert">
	<span class="glyphicon glyphicon glyphicon-ok" aria-hidden="true"></span> 
		${mensagem}
	</span>
</c:if>
<br>
<div class="page-header">
	<h2>Listar Redes</h2>
</div>
<br>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>Nome</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${redeList}" var="rede">
			<tr>
				<td>${rede.nome}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>