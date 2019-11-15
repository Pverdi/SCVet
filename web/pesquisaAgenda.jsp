<%-- 
    Document   : pesquisaAgenda
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
        <title>Pesquisa de Agenda</title>
    </head>
    <body>
        <h1>Pesquisa de Agenda</h1>
        <table border=1>
            <tr>
                <th>Código Agenda</th>
                <th>Cliente</th>
                <th>Data</th>
                <th>Tipo de Atendimento</th>
                <th>Funcionario</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${agendas}" var="agenda">
                <tr>
                    <td><c:out value="${agenda.codAgenda}" /></td>
                    <td><c:out value="${agenda.cliente.nome}" /></td>
                    <td><c:out value="${agenda.data}" /></td>
                    <td><c:out value="${agenda.tipoAtendimento}" /></td>
                    <td><c:out value="${agenda.veterinario.nome}" /></td>
                    <td><a href="ManterAgendaController?acao=prepararOperacao&operacao=Excluir&codAgenda=<c:out value="${agenda.codAgenda}"/>">Excluir</a></td>
                    <td><a href="ManterAgendaController?acao=prepararOperacao&operacao=Alterar&codAgenda=<c:out value="${agenda.codAgenda}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterAgendaController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>
