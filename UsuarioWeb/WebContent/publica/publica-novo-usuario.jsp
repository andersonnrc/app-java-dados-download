<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>
	<jsp:include page="/publica/publica-nav.jsp" />

	<div class="container">
		<div class="row">
			<div class="col">
				<h2>Cadastro usuário</h2>
				
				<c:if test="${mensagem != null}">
				 	<div class="alert alert-success alert-dismissible fade show">
					<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
					<span><c:out value="${mensagem}" /></span>
				</div>
				</c:if>	
				
				<form
					action="${pageContext.request.contextPath}/publica?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Nome</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="nome">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Email</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="email">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Data Cadastro</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="dataCadastro">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Company</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="company">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">City</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="city">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Region</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="region">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Country</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="country">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">PostalZip</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="postalZip">
						</div>
					</div>

					<input class="btn btn-primary" type="submit" value="Gravar" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
