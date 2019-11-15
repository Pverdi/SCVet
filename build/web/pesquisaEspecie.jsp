<%-- 
    Document   : pesquisaEspecie
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
        <title>Pesquisa de Especie</title>
    </head>
    <body>
        <h1>Pesquisa de Especie</h1>
        <table border=1>
            <tr>
                <th>Código Espécie</th>
                <th>Nome Espécie</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${especies}" var="especie">
                <tr>
                    <td><c:out value="${especie.codEspecie}" /></td>
                    <td><c:out value="${especie.nome}" /></td>
                    <td><a href="ManterEspecieController?acao=prepararOperacao&operacao=Alterar&codEspecie=<c:out value="${especie.codEspecie}"/>">Alterar</a></td>
                    <td><a href="ManterEspecieController?acao=prepararOperacao&operacao=Excluir&codEspecie=<c:out value="${especie.codEspecie}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterEspecieController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
           
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
