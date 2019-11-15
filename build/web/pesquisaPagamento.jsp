<%-- 
    Document   : pesquisaPagamento
    Created on : 05/11/2019, 02:04:49
    Author     : Iago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Pagamento</title>
    </head>
    <body>
        <h1>Pesquisa de Pagamento</h1>
        <table border=1>
            <tr>
                <th>Código</th>
                <th>Valor Total</th>
                <th>Valor Pago</th>
                <th>Nome Procedimento</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${pagamentos}" var="pagamento">
                <tr>
                    <td><c:out value="${pagamento.codPagamento}" /></td>
                    <td><c:out value="${pagamento.valorTotal}" /></td>
                    <td><c:out value="${pagamento.valorPago}" /></td>
                    <td><c:out value="${pagamento.procedimento.nome}" /></td>
                    <td><a href="ManterPagamentoController?acao=prepararOperacao&operacao=Excluir&codPagamento=<c:out value="${pagamento.codPagamento}"/>">Excluir</a></td>
                    <td><a href="ManterPagamentoController?acao=prepararOperacao&operacao=Alterar&codPagamento=<c:out value="${pagamento.codPagamento}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPagamentoController?acao=prepararOperacao&operacao=Incluir"
            method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        <button onclick="window.location.href = 'http://localhost:8080/NeoSCVet/';">Voltar</button>
    </body>
</html>