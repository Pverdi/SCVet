<%-- 
    Document   : cadastrarAgenda
    Created on : 05/09/2019, 09:59:53
    Author     : lucsd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Agendamento</title>
    </head>
    <body>

        <h1>Cadastrar Agendamento - ${operacao}</h1>

        <form action="ManterAgendaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarAgenda">
            <table>
                <tr>
                    <td><label>Codigo da Agenda:</label></td>
                    <td><input type="number" name="numCodAgenda" value="${agenda.codAgenda}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Data:</label></td>
                        <td><input type="date" name="numData" value="${agenda.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Hora:</label></td>
                        <td><input type="time" name="numHora" value="${agenda.hora}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label>Numero da Sala:</label></td>
                        <td><select name="numNumeroSala"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="1" <c:if test="${agenda.numeroSala == '1'}"> selected</c:if>>1</option>
                            <option value="2" <c:if test="${agenda.numeroSala == '2'}"> selected</c:if>>2</option>
                            <option value="3" <c:if test="${agenda.numeroSala == '3'}"> selected</c:if>>3</option>
                            <option value="4" <c:if test="${agenda.numeroSala == '4'}"> selected</c:if>>4</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label>Tipo de Atendimento:</label></td>
                        <td><select name="optTipoAtendimento"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Consulta" <c:if test="${agenda.tipoAtendimento == 'Consulta'}"> selected</c:if>>Consulta</option>
                            <option value="Cirurgia" <c:if test="${agenda.tipoAtendimento == 'Cirurgia'}"> selected</c:if>>Cirurgia</option>
                            <option value="Exame" <c:if test="${agenda.tipoAtendimento == 'Exame'}"> selected</c:if>>Exame</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Cliente:</label></td>
                        <td><select name="optCliente" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.codCliente}" <c:if test="${raca.cliente.codCliente == cliente.codCliente}"> selected</c:if>>${cliente.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>


                <tr>
                    <td><label>Animal:</label></td>
                    <td><select name="optAnimal" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${animais}" var="animal">
                                <option value="${animal.codAnimal}" <c:if test="${agenda.animal.codAnimal == animal.codAnimal}"> selected</c:if>>${animal.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>



                <tr>
                    <td><label>Funcionario:</label></td>
                    <td><select name="optFuncionario" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${veterinarios}" var="veterinario">
                                <option value="${veterinario.codFuncionario}" <c:if test="${agenda.veterinario.codFuncionario == veterinario.codFuncionario}"> selected</c:if>>${veterinario.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr><td><button id="CadastrarAgenda">Confirmar</button></td>
                </tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
