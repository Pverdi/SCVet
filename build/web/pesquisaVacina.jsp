<%-- 
    Document   : pesquisaVacina
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
        <title>Pesquisa de Vacina</title>
    </head>
    <body>
        <h1>Pesquisa de Vacina</h1>
        <table border=1>
            <tr>
                <th>Código Vacina</th>
                <th>Nome Vacina</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${vacinas}" var="vacina">
                <tr>
                    <td><c:out value="${vacina.codVacina}" /></td>
                    <td><c:out value="${vacina.nome}" /></td>
                    <td><a href="ManterVacinaController?acao=prepararOperacao&operacao=Excluir&codVacina=<c:out value="${vacina.codVacina}"/>">Excluir</a></td>
                    <td><a href="ManterVacinaController?acao=prepararOperacao&operacao=Alterar&codVacina=<c:out value="${vacina.codVacina}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterVacinaController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>