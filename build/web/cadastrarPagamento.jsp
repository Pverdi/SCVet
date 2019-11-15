<%-- 
    Document   : cadastrarPagamento
    Created on : 05/11/2019, 02:08:45
    Author     : Iago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Pagamento</title>
    </head>
    <body>

        <h1>Cadastrar Pagamento - ${operacao}</h1>

        <form action="ManterPagamentoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarPagamento">
            <table class="pagamento">
                <tr>
                    <td><label>Codigo da Pagamento:</label></td>
                    <td><input type="number" name="numCodPagamento" value="${pagamento.codPagamento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Valor Total:</label></td>
                        <td><input type="number" name="numValorTotal" value="${pagamento.valorTotal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Valor Pago:</label></td>
                        <td><input type="number" name="numValorPago" value="${pagamento.valorPago}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                
                <tr>
                        <td><label>Procedimento:</label></td>
                        <td><select name="optProcedimento" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${procedimentos}" var="procedimento">
                                <option value="${procedimento.codProcedimento}" <c:if test="${raca.procedimento.codProcedimento == procedimento.codProcedimento}"> selected</c:if>>${procedimento.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>


                <tr><td><button id="CadastrarPagamento">Confirmar</button></td></tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
