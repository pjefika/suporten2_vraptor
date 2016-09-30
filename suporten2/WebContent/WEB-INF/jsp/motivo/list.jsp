<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/dataTable/js/ledataTable.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dataTable/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dataTable/css/jquery.dataTables.min.css">
<div class="page-header">
	<h2>Listar Motivos</h2>
</div>

<a class="row" href="${linkTo[motivoController].create}">Adicionar</a>

<table class="table table-bordered" id="listaMotivo" style="font-size: 12px;">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Rede</th>
			<th>Macro Motivo</th>
			<th>Ativo</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${motivoList}" var="macro">
			<tr>
				<td>${motivo.nome}</td>
				<td>${motivo.macro.rede.nome}</td>
				<td>${motivo.macro.nome}</td>
				<td>
					<c:choose>
					    <c:when test="${motivo.ativo}">
					        Sim
					    </c:when>    
					    <c:otherwise>
					       	Não
					    </c:otherwise>
					</c:choose>
				</td>
				
				<td>
					<a href="${linkTo[motivoController].edit()}${motivo.id}"
					class="btn btn-warning btn-sm"> 
						<span
							class="glyphicon glyphicon-pencil" aria-hidden="true">
							</span>
					</a>
					<button class="btn btn-danger btn-sm deletar" data-id="${motivo.id}"
						data-nome="${motivo.nome}" data-toggle="modal"
						data-target=".bs-example-modal-sm">
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	setTimeout(function(){
		$('#listaMotivo').DataTable({
			  "pagingType": "simple"
		});
	});
	
	
	$('.deletar').click(function () {
		
		botao = $(this);
		
		var id = botao.data("id");
		var nome = botao.data("nome");
	
		$("#idRef").val(id);
		$("#nomeRef").text(nome);
		
	});

</script>

<div class="modal fade bs-example-modal-sm" id="modalDeletaRede"
	tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
	<div class="modal-dialog modal-sm" role="document">
		<form action="${linkTo[motivoController].delete}" method="post">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Confirmação</h4>
				</div>
				
				<input type="hidden" name="id" id="idRef" />
				<div class="modal-body">
					Remover Motivo <b id="nomeRef"></b>?
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					<button type="submit" class="btn btn-danger">Confirmar</button>
				</div>
			</div>
		</form>
	</div>
</div>