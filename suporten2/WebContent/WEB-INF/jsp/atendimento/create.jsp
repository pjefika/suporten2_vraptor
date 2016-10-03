<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<div class="page-header">
	<h2>Atendimento</h2>
</div>
<form action="${linkTo[AtendimentoController].add}" method="post" style="width: 75%;">

	<div class="form-group">
		<div class="form-inline">
			<label for="operadorLogin">Operador: </label> 
			<input type="text"
				class="form-control" 
				id="operadorLogin" 
				placeholder="Matrícula do Operador"
				name="a.operadorLogin">
			<c:if test="${not empty errors.from('a.operadorLogin')}">
				<small>
					<span class="alert alert-warning validator">
						<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> 
						${errors.from('a.operadorLogin')}
					</span>
				</small>			
			</c:if>
		</div>
	</div>

	<div class="form-group">
		<div class="form-inline">
			<label for="rede">Rede:</label> 
			<select class="form-control" name="" id="rede">
				<option selected="selected" disabled="disabled">Selecione</option>
				<c:forEach items="${redeList}" var="rede">
					<option value="${rede.id}">${rede.nome}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<div class="form-inline">
			<label for="macro">Macro Motivo:</label> 
			<select class="form-control" name="" id="macro">
				<option selected="selected" disabled="disabled">Selecione</option>
			</select>
		</div>
	</div>	
	
	<div class="form-group">
		<div class="form-inline">
			<label for="motivo">Motivo:</label> 
			<select class="form-control" name="" id="motivo">
				<option selected="selected" disabled="disabled">Selecione</option>
			</select>
		</div>
	</div>	
	
	<div class="form-group">
		<div class="form-inline">
			<label for="solucao">Solução:</label> 
			<select class="form-control" name="a.solucao.id" id="solucao">
				<option selected="selected" disabled="disabled">Selecione</option>
			</select>
		</div>
	</div>

	<button type="submit" class="btn btn-default">Registrar</button>
</form>
<script>
$("#rede").change(function(){
	var rede = $(this).val();
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/suporten2/json/macromotivos/'+rede,
		success: function(macroopt){
			lemacroopt = macroopt;
			macros = "<option selected disabled>Selecione</option>";
			for(i=0; i < lemacroopt.list.length; i++){
				macros += "<option value='"+lemacroopt.list[i].id+"'> " + lemacroopt.list[i].nome + "</option>";
			}
			$("#macro").html(macros);
		}
	});
});
$("#macro").change(function(){
	var macro = $(this).val();
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/suporten2/json/motivos/'+macro,
		success: function(motivoopt){
			lemotivoopt = motivoopt;
			motivos = "<option selected disabled>Selecione</option>";
			for(i=0; i < lemotivoopt.list.length; i++){
				motivos += "<option value='"+lemotivoopt.list[i].id+"'> " + lemotivoopt.list[i].nome + "</option>";
			}
			$("#motivo").html(motivos);
		}
	});
});
$("#motivo").change(function(){
	var motivo = $(this).val();
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/suporten2/json/solucaos/'+motivo,
		success: function(solucaoopt){
			lesolucaoopt = solucaoopt;
			solucaos = "<option selected disabled>Selecione</option>";
			for(i=0; i < lesolucaoopt.list.length; i++){
				solucaos += "<option value='"+lesolucaoopt.list[i].id+"'> " + lesolucaoopt.list[i].nome + "</option>";
			}
			$("#solucao").html(solucaos);
		}
	});
});

</script>
