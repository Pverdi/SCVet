<%-- 
    Document   : pesquisaProntuario
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
        <title>Pesquisa de Prontuario</title>
    </head>
    <body>
        <h1>Pesquisa de Prontuario</h1>
        <table border=1>
            <tr>
                <th>Código Prontuario</th>
                <th>Descrição Prontuario</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${prontuarios}" var="prontuario">
                <tr>
                    <td><c:out value="${prontuario.codProntuario}" /></td>
                    <td><c:out value="${prontuario.descricao}" /></td>
                    <td><a href="ManterProntuarioController?acao=prepararOperacao&operacao=Excluir&codProntuario=<c:out value="${prontuario.codProntuario}"/>">Excluir</a></td>
                    <td><a href="ManterProntuarioController?acao=prepararOperacao&operacao=Alterar&codProntuario=<c:out value="${prontuario.codProntuario}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterProntuarioController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
