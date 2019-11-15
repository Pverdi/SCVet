<%-- 
    Document   : cadastrarVacina
    Created on : 05/09/2019, 10:08:30
    Author     : lucsd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Vacina</title>
    </head>
    <body>
        <form action="ManterVacinaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarVacina">
            <table class="vacina">
                <h1>Cadastrar Vacina - ${operacao}</h1>
                <tr>
                    <td><label>Código Vacina:</label></td>
                    <td><input type="number" name="numCodVacina" value="${vacina.codVacina}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>  
                    <tr>
                        <td><label>Nome da Vacina:</label></td>
                        <td><input type="text" name="txtNome" value="${vacina.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Vencimento:</label></td>
                        <td><input type="text" name="txtVencimento" value="${vacina.vencimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Fornecedor:</label></td>
                        <td><select name="optFornecedor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${fornecedores}" var="fornecedor">
                                <option value="${fornecedor.codFornecedor}" <c:if test="${vacina.fornecedor.codFornecedor == fornecedor.codFornecedor}"> selected</c:if>>${fornecedor.nomeEmpresa}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Lote:</label></td>
                    <td><input type="text" name="txtLote" value="${item.lote}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Dose Recomendada:</label></td>
                        <td><input type="number" name="txtDose" value="${vacina.dose}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Temperatura de conservação:</label></td>
                        <td><input type="number" name="txtTemperatura" value="${vacina.temperatura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Via de Aplicação:</label></td>
                        <td><select name="optVia" value="${vacina.via}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Subcutânea" <c:if test="${vacina.via== 'Subcutânea'}"> selected</c:if>>Subcutânea</option>
                            <option value="Cutânea" <c:if test="${vacina.via == 'Cutânea'}"> selected</c:if>>Cutânea</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Duração:</label></td>
                        <td><input type="text" name="txtDuracao" value="${vacina.duracao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Contra-Indicação:</label></td>
                        <td><input type="text" name="txtContraIndicacoes" value="${vacina.contraIndicacoes}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Descrição:</label></td>
                        <td><input type="text" name="txtDescricao" value="${vacina.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>


                <tr>
                    <td><button id="CadastrarVacina">Confirmar</button></td>
                </tr>

            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
