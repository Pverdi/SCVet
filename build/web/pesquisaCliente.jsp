<%-- 
    Document   : pesquisaCliente
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
        <title>Pesquisa de Cliente</title>
    </head>
    <body>
        <h1>Pesquisa de Cliente</h1>
        <table border=1>
            <tr>
                <th>Código Cliente</th>
                <th>Nome Cliente</th>
                <th>Cidade Cliente</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.codCliente}" /></td>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.cidade}" /></td>
                    <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Excluir&codCliente=<c:out value="${cliente.codCliente}"/>">Excluir</a></td>
                    <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Alterar&codCliente=<c:out value="${cliente.codCliente}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterClienteController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
