<%-- 
    Document   : cadastrarProntuario
    Created on : 21/10/2019, 19:35:00
    Author     : penel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>Cadastrar Prontuário</title>
    </head>
    <body>

        <h1>Cadastrar Prontuario - ${operacao}</h1>

        <form action="ManterProntuarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarProntuario">
            <table>
                <tr>
                    <td><label>Codigo do Prontuario:</label></td>
                    <td><input type="text" name="txtCodProntuario" value="${prontuario.codProntuario}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Animal:</label></td>
                        <td><select name="optAnimal" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${animais}" var="animal">
                                <option value="${animal.codAnimal}" <c:if test="${prontuario.animal.codAnimal == animal.codAnimal}"> selected</c:if>>${animal.codAnimal} - ${animal.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Data:</label></td>
                    <td><input type="text" name="txtData" value="${prontuario.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Hora:</label></td>
                        <td><input type="text" name="txtHora" value="${prontuario.hora}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Procedimento:</label></td>
                        <td><select name="optProcedimento" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${procedimentos}" var="procedimento">
                                <option value="${procedimento.codProcedimento}" <c:if test="${prontuario.procedimento.codProcedimento == procedimento.codProcedimento}"> selected</c:if>>${procedimento.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Vacina:</label></td>
                    <td><select name="optVacina" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${prontuario.vacina.codVacina== null}"> selected</c:if>>Nenhuma</option>
                            <c:forEach items="${vacinas}" var="vacina">
                                <option value="${vacina.codVacina}" <c:if test="${prontuario.vacina.codVacina == vacina.codVacina}"> selected</c:if>>${vacina.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>Descrição:</label></td>
                    <td><input type="textbox" name="txtDescricao" value="${prontuario.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr><td><button id="CadastrarProntuario">Confirmar</button></td></tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>

