<%-- 
    Document   : pesquisaFornecedor
    Created on : 19/09/2019, 09:08:53
    Author     : lucsd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Fornecedor</title>
    </head>
    <body>
        <h1>Pesquisa de Fornecedor</h1>
        <table border=1>
            <tr>
                <th>Código Fornecedor</th>
                <th>Nome da Empresa</th>
                <th>Nome do Contato</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${fornecedores}" var="fornecedor">
                <tr>
                    <td><c:out value="${fornecedor.codFornecedor}" /></td>
                    <td><c:out value="${fornecedor.nomeEmpresa}" /></td>
                    <td><c:out value="${fornecedor.nomeContato}" /></td>
                    <td><a href="ManterFornecedorController?acao=prepararOperacao&operacao=Excluir&codFornecedor=<c:out value="${fornecedor.codFornecedor}"/>">Excluir</a></td>
                    <td><a href="ManterFornecedorController?acao=prepararOperacao&operacao=Alterar&codFornecedor=<c:out value="${fornecedor.codFornecedor}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <form action="ManterFornecedorController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
