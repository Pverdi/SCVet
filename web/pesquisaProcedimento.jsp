<%-- 
    Document   : pesquisaProcedimento
    Created on : 05/11/2019, 00:19:41
    Author     : Iago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Procedimento</title>
    </head>
    <body>
        <h1>Pesquisa de Procedimento</h1>
        <table border=1>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Valor</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${procedimentos}" var="procedimento">
                <tr>
                    <td><c:out value="${procedimento.codProcedimento}" /></td>
                    <td><c:out value="${procedimento.nome}" /></td>
                    <td><c:out value="${procedimento.valor}" /></td>
                    <td><a href="ManterProcedimentoController?acao=prepararOperacao&operacao=Excluir&codProcedimento=<c:out value="${procedimento.codProcedimento}"/>">Excluir</a></td>
                    <td><a href="ManterProcedimentoController?acao=prepararOperacao&operacao=Alterar&codProcedimento=<c:out value="${procedimento.codProcedimento}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterProcedimentoController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
