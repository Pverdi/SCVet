<%-- 
    Document   : pesquisaRaca
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
        <title>Pesquisa de Raca</title>
    </head>
    <body>
        <h1>Pesquisa de Raca</h1>
        <table border=1>
            <tr>
                <th>Código Raca</th>
                <th>Nome Raca</th>
                <th>Espécie Raca</th>
                <th>Porte Raca</th>
                <th>Personalidade Raca</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${racas}" var="raca">
                <tr>
                    <td><c:out value="${raca.codRaca}" /></td>
                    <td><c:out value="${raca.nome}" /></td>
                    <td><c:out value="${raca.especie.nome}" /></td>
                    <td><c:out value="${raca.porte}" /></td>
                    <td><c:out value="${raca.personalidade}" /></td>
                    <td><a href="ManterRacaController?acao=prepararOperacao&operacao=Excluir&codRaca=<c:out value="${raca.codRaca}"/>">Excluir</a></td>
                    <td><a href="ManterRacaController?acao=prepararOperacao&operacao=Alterar&codRaca=<c:out value="${raca.codRaca}"/>">Alterar</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action="ManterRacaController?acao=prepararOperacao&operacao=Incluir"
              method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
