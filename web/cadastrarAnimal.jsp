<%-- 
    Document   : cadastrarAnimal
    Created on : 05/09/2019, 09:59:53
    Author     : lucsd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Animal</title>
    </head>
    <body>
        <form action="ManterAnimalController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarAnimal">
            <table class="animal">
                <h1>Cadastrar Animal - ${operacao}</h1>
                <tr>
                    <td><label>Código:</label></td>
                    <td><input type="number" name="numCodAnimal" value="${animal.codAnimal}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Cliente:</label></td>
                        <td><select name="optDono" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${donos}" var="dono">
                                <option value="${dono.codCliente}" <c:if test="${animal.dono.codCliente== dono.codCliente}"> selected</c:if>>${dono.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                
                
                <tr>
                    <td><label>Nome Animal:</label></td>
                    <td><input type="text" name="txtNomeAnimal" value="${animal.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Data de Nascimento:</label></td>
                        <td><input type="date" value="${animal.dtNascimento}" name="numDtNascimento" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Raça:</label></td>
                        <td><select name="optRaca" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${racas}" var="raca">
                                <option value="${raca.codRaca}" <c:if test="${animal.raca.codRaca== raca.codRaca}"> selected</c:if>>${raca.nome}</option>
                            </c:forEach>
                        </select></td>
                </tr>      

                <tr>
                    <td><label>Tipo Sanguíneo:</label></td>
                    <td><input type="text" name="txtTipoSanguineo" value="${animal.tipoSanguineo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Peso:</label></td>
                        <td><input placeholder="Kg" type="number" name="numPeso" value="${animal.peso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>


                <tr><td><button id="CadastrarAnimal">Confirmar</button></td></tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
