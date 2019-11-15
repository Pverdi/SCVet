<%-- 
    Document   : pesquisaFuncionario
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
        <title>Pesquisa de Funcionario</title>
    </head>
    <body>
        <h1>Pesquisa de Funcionario</h1>
        <table border=1>
            <tr>
                <th>Código Funcionario</th>
                <th>Nome Funcionario</th>
                <th>Cargo Funcionario</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td><c:out value="${funcionario.codFuncionario}" /></td>
                    <td><c:out value="${funcionario.nome}" /></td>
                    <td><c:out value="${funcionario.cargo}" /></td>
                    <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&codFuncionario=<c:out value="${funcionario.codFuncionario}"/>">Excluir</a></td>
                    <td><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Alterar&codFuncionario=<c:out value="${funcionario.codFuncionario}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
