<%-- 
    Document   : cadastrarEspecie
    Created on : 05/09/2019, 09:59:53
    Author     : lucsd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Especie</title>
    </head>
    <body>

        <h1>Cadastrar Especie - ${operacao}</h1>

        <form action="ManterEspecieController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarEspecie">
            <table class="especie">
                <tr>
                    <td><label>Codigo da Especie:</label></td>
                    <td><input type="number" name="numCodEspecie" value="${especie.codEspecie}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Nome:</label></td>
                        <td><input type="text" name="txtNomeEspecie" value="${especie.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr><td><button id="CadastrarEspecie">Confirmar</button></td></tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
