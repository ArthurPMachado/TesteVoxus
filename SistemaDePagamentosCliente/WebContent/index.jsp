<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/index.css" type="text/css">
<title>Sistema de Pagamentos</title>
</head>
<body>
	<div>
		<form action="cadastrar" method="POST">
			<fieldset>
				<legend>Cadastro de pagamentos</legend>
				<div>
					<label for="idTitle">Titulo do Pagamento: </label> <input type="text"
						id="idTitle" name="title" required="required"
						placeholder="Digite o titulo do pagamento">
				</div>
				<div>
					<label for="idValue">Valor do Pagamento: </label> <input type="text"
						id="idValue" name="value" required="required"
						placeholder="Digite o valor do pagamento"
						value="${produtoObj.preco}">
				</div>
				<div>
					<label for="idDate">Data do Pagamento: </label> <input
						id="idDate" name="date" required="required"
						placeholder="Digite a data do pagamento">
				</div>
				<div>
					<label for="idComments">Comentários do Pagamento: </label> <input
						id="idDate" name="comments"
						placeholder="Digite os comentários do pagamento">
				</div>
				<div>
					<input type="submit" value="cadastrar">
				</div>
			</fieldset>
		</form>
	</div>

	<c:if test="${controle != null}">
		<table>
			<tr>
				<th>ID</th>
				<th>TITULO</th>
				<th>VALOR</th>
				<th>DATA</th>
				<th>TAXA</th>
				<th>COMENTÁRIOS</th>
			</tr>
			<c:forEach var="p" items="${listaDePagamentos}" varStatus="id">
				<tr>
					<td>${p.id}</td>
					<td>${p.title}</td>
					<td>${p.value}</td>
					<td>${p.date}</td>
					<td>${p.tax}</td>
					<td>${p.comments}</td>
					<td class="remove-td"><a href="remover?paymentIdDelete=${p.id}">Remover</a></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>