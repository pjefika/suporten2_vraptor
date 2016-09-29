<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<title><decorator:title default="Suporte N2" /></title>
<meta charset="utf-8">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"
	rel="stylesheet" />

<script
	src="${pageContext.request.contextPath}/resources/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<decorator:head/>
</head>
<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SuporteN2</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Administração <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Cadastros</li>
							<li><a href="${linkTo[RedeController].list}">Rede</a></li>
							<li><a href="${linkTo[MacroMotivoController].list}">Macro Motivo</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				
					<c:choose>
					    <c:when test="${empty sessionUsuarioEfika.usuario.login}">
					        <li><a href="${linkTo[UsuarioController].create}">Login</a></li>
					    </c:when>    
					    <c:otherwise>
					        <li><a href="#">${sessionUsuarioEfika.usuario.login}</a></li>
					    </c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<br/>
		<br/>
		<br/>
		<br/>
		<decorator:body />
	</div>
	<!-- /container -->

</body>
</html>