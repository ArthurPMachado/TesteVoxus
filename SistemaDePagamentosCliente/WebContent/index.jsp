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
		<form class="frm-1" action="${action_frm == null ? 'adicionar' : action_frm}" method="get">
			<fieldset>
				<legend>Cadastro de produtos</legend>
				<input type="hidden" name="txtCdProduto"
					value="${produtoObj.codigo}">
				<div>
					<label for="idNmProd">Nome do produto</label> <input type="text"
						id="idNmProd" name="txtNmProd" required="required"
						placeholder="Digite o nome do produto"
						value="${produtoObj.titulo}">
				</div>
				<div>
					<label for="idVlProd">Preço do produto</label> <input type="text"
						id="idVlProd" name="txtVlProd" required="required"
						placeholder="Digite o valor do produto"
						value="${produtoObj.preco}">
				</div>
				<div>
					<label for="idQtdProd">Quantidade do produto</label> <input
						type="number" id="idQtdProd" name="txtQtdProd" required="required"
						placeholder="Digite a quantidade do produto"
						value="${produtoObj.quantidade}">
				</div>
				<div>
					<input type="submit" value="Cadastrar">
				</div>
			</fieldset>
		</form>
	</div>

	<c:if test="${controle != null}">
		<table>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>PREÇO</th>
				<th>QUANTIDADE</th>
				<th colspan="2">EDITAR</th>

			</tr>
			<c:forEach var="p" items="${listaDeproduto}" varStatus="id">
				<tr>
					<td>${p.codigo}</td>
					<td>${p.titulo}</td>
					<td>${p.preco}</td>
					<td>${p.quantidade}</td>
					<td class="edit-td"><a href="listar?codProd=${p.codigo}"><img
							src="./img/editar.png"></a></td>
					<td class="edit-td"><a href="remover?codProd=${p.codigo}"><img
							src="./img/excluir.png"></a></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>