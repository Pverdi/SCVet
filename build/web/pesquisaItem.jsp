<%-- 
    Document   : PesquisaItem
    Created on : 21/10/2019, 19:43:43
    Author     : penel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>Pesquisa de Item</title>
    </head>
    <body>
        <h1>Pesquisa de Item</h1>
        <table border=1>
            <tr>
                <th>Código Item</th>
                <th>Nome Item</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${itens}" var="item">
                <tr>
                    <td><c:out value="${item.codItem}" /></td>
                    <td><c:out value="${item.nome}" /></td>
                    
                    <td><a href="ManterItemController?acao=prepararOperacao&operacao=Excluir&codItem=<c:out value="${item.codItem}"/>">Excluir</a></td>
                    <td><a href="ManterItemController?acao=prepararOperacao&operacao=Alterar&codItem=<c:out value="${item.codItem}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterItemController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
