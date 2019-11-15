<%-- 
    Document   : pesquisaAnimal
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
        <title>Pesquisa de Animal</title>
    </head>
    <body>
        <h1>Pesquisa de Animal</h1>
        <table border=1>
            <tr>
                <th>Código Animal</th>
                <th>Nome Animal</th>
                <th>Dono Animal</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${animais}" var="animal">
                <tr>
                    <td><c:out value="${animal.codAnimal}" /></td>
                    <td><c:out value="${animal.nome}" /></td>
                    <td><c:out value="${animal.dono.nome}" /></td>
                    <td><a href="ManterAnimalController?acao=prepararOperacao&operacao=Excluir&codAnimal=<c:out value="${animal.codAnimal}"/>">Excluir</a></td>
                    <td><a href="ManterAnimalController?acao=prepararOperacao&operacao=Alterar&codAnimal=<c:out value="${animal.codAnimal}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterAnimalController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
