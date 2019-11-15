<%-- 
    Document   : cadastrarProcedimento
    Created on : 05/11/2019, 00:25:29
    Author     : Iago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Procedimento</title>
    </head>
    <body>

        <h1>Cadastrar Procedimento - ${operacao}</h1>

        <form action="ManterProcedimentoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarProcedimento">
            <table class="procedimento">
                <tr>
                    <td><label>Codigo da Procedimento:</label></td>
                    <td><input type="number" name="txtCodProcedimento" value="${procedimento.codProcedimento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Nome:</label></td>
                        <td><input type="text" name="txtNomeProcedimento" value="${procedimento.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Valor:</label></td>
                        <td><input type="number" name="numValorProcedimento" value="${procedimento.valor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr><td><button id="CadastrarProcedimento">Confirmar</button></td></tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
