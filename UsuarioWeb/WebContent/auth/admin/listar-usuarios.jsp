<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuários</title>


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
				<h2>
					Usuários
				</h2>
				<a href="${pageContext.request.contextPath}/auth/admin/exportar-usuarios-xls" class="btn btn-success mb-3">Exportar para XLS</a>
				<a href="${pageContext.request.contextPath}/auth/admin/exportar-usuarios-csv" class="btn btn-success mb-3">Exportar para CSV</a>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>E-mail</th>
							<th>Data Cadastro</th>
							<th>Company</th>
							<th>City</th>
							<th>Region</th>
							<th>Country</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${listaUsuarios}">
							<tr>
								<td><c:out value="${usuario.id}" /></td>
								<td><c:out value="${usuario.name}" /></td>
								<td><c:out value="${usuario.email}" /></td>
								<td><c:out value="${usuario.dataCadastro}" /></td>							
								<td><c:out value="${usuario.company}" /></td>
								<td><c:out value="${usuario.city}" /></td>
								<td><c:out value="${usuario.region}" /></td>
								<td><c:out value="${usuario.country}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
