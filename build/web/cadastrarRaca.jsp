<%-- 
    Document   : cadastrarRaca
    Created on : 06/09/2019, 10:46:01
    Author     : Aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Raça </title>
    </head>
    <body>
        <form action="ManterRacaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarRaca">
            <table class="raca">
                <h1>Cadastrar Raça - ${operacao}</h1>
                <tr>
                    <td><label>Código:</label></td>
                    <td><input type="number" name="numCodRaca" value="${raca.codRaca}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Espécie de Animal:</label></td>
                        <td><select name="optEspecie" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${especies}" var="especie">
                                <option value="${especie.codEspecie}" <c:if test="${raca.especie.codEspecie == especie.codEspecie}"> selected</c:if>>${especie.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>


                <tr>
                    <td><label>Nome de Raça:</label></td>
                    <td><input type="text" name="txtNomeRaca" value="${raca.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Porte:</label></td>
                        <td><select name="optPorteRaca"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Pequeno" <c:if test="${raca.porte == 'Pequeno'}"> selected</c:if>>Pequeno</option>
                            <option value="Médio" <c:if test="${raca.porte == 'Médio'}"> selected</c:if>>Médio</option>
                            <option value="Grande" <c:if test="${raca.porte == 'Grande'}"> selected</c:if>>Grande</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Personalidade:</label></td>
                        <td><select name="optPersonalidade"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Manso" <c:if test="${raca.personalidade == 'Manso'}"> selected</c:if>>Manso</option>
                            <option value="Agitado" <c:if test="${raca.personalidade == 'Agitado'}"> selected</c:if>>Agitado</option>
                            <option value="Bravo" <c:if test="${raca.personalidade == 'Bravo'}"> selected</c:if>>Bravo</option>
                            </select></td>
                </tr>


                <tr>
                    <td><button id="CadastrarRaca">Confirmar</button></td>
                </tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
