<%-- 
    Document   : cadastrarItem
    Created on : 21/10/2019, 23:32:35
    Author     : penel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Item</title>
    </head>
    <body>

        <form action="ManterItemController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarItem">
            <table class="item">
                <h1>Cadastrar Item - ${operacao}</h1>
                <tr>
                    <td><label>Código:</label></td>
                    <td><input type="text" name="txtCodItem" value="${item.codItem}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>  
                    <tr>
                        <td><label>Nome do Item:</label></td>
                        <td><input type="text" name="txtNomeItem" value="${item.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Lote do Item:</label></td>
                        <td><input type="text" name="txtLoteItem" value="${item.lote}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    
                    
                    <tr>
                        <td><label>Quantidade do Item:</label></td>
                        <td><input type="number" name="numQtdItem" value="${item.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    
                    
                    <tr>
                        <td><label>Tipo do Item:</label></td>
                        <td><input type="text" name="txtTipoItem" value="${item.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Vencimento do Item:</label></td>
                        <td><input type="text" name="txtVencimento" value="${item.vencimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Fornecedor:</label></td>
                        <td><select name="optFornecedor"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${fornecedores}" var="fornecedor">
                                <option value="${fornecedor.codFornecedor}" <c:if test="${item.fornecedor.codFornecedor == fornecedor.codFornecedor}"> selected</c:if>>${fornecedor.nomeEmpresa}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                <tr>
                    <td><button id="CadastrarItem">Confirmar</button></td>
                </tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
