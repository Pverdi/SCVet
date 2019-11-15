<%-- 
    Document   : cadastrarCliente
    Created on : 05/09/2019, 09:02:08
    Author     : lucsd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarCliente">
            <h1>Cadastrar Cliente - ${operacao}</h1>
            <table>


                <tr>
                    <td><label>Codigo do Cliente:</label></td>
                    <td><input type="number" name="numCodCliente" value="${cliente.codCliente}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Nome:</label></td>
                        <td><input type="text" name="txtNome" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>CPF:</label></td>
                        <td><input type="number" name="numCpf" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>RG:</label></td>
                        <td><input type="number" name="numRg" value="${cliente.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Email:</label></td>
                        <td><input type="text" name="txtEmail" value="${cliente.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td></td>
                    </tr>


                    <tr>
                        <td><label>Telefone(s):</label></td>
                        <td><input type="number" name="numTelefone" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>


                    <tr>
                        <td><label>Endereço</label></td>
                    </tr>


                    <tr>
                        <td><label>CEP:</label></td>
                        <td><input type="number" name="numCep" value="${cliente.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Estado:</label></td>
                        <td><select id="UF" name="optEstado" <c:if test="${operacao == 'Excluir'}"> readonly=""</c:if>>
                            <option value="AC" <c:if test="${cliente.estado == 'AL'}"> selected</c:if>>AC</option>
                            <option value="AL" <c:if test="${cliente.estado == 'AL'}"> selected</c:if>>AL</option>
                            <option value="AP" <c:if test="${cliente.estado == 'AP'}"> selected</c:if>>AP</option>
                            <option value="AM" <c:if test="${cliente.estado == 'AM'}"> selected</c:if>>AM</option>
                            <option value="BA" <c:if test="${cliente.estado == 'BA'}"> selected</c:if>>BA</option>
                            <option value="CE" <c:if test="${cliente.estado == 'CE'}"> selected</c:if>>CE</option>
                            <option value="DF" <c:if test="${cliente.estado == 'DF'}"> selected</c:if>>DF</option>
                            <option value="ES" <c:if test="${cliente.estado == 'ES'}"> selected</c:if>>ES</option>
                            <option value="GO" <c:if test="${cliente.estado == 'GO'}"> selected</c:if>>GO</option>
                            <option value="MA" <c:if test="${cliente.estado == 'MA'}"> selected</c:if>>MA</option>
                            <option value="MT" <c:if test="${cliente.estado == 'MT'}"> selected</c:if>>MT</option>
                            <option value="MS" <c:if test="${cliente.estado == 'MS'}"> selected</c:if>>MS</option>
                            <option value="MG" <c:if test="${cliente.estado == 'MG'}"> selected</c:if>>MG</option>
                            <option value="PA" <c:if test="${cliente.estado == 'PA'}"> selected</c:if>>PA</option>
                            <option value="PB" <c:if test="${cliente.estado == 'PB'}"> selected</c:if>>PB</option>
                            <option value="PR" <c:if test="${cliente.estado == 'PR'}"> selected</c:if>>PR</option>
                            <option value="PE" <c:if test="${cliente.estado == 'PE'}"> selected</c:if>>PE</option>
                            <option value="PI" <c:if test="${cliente.estado == 'PI'}"> selected</c:if>>PI</option>
                            <option value="RJ" <c:if test="${cliente.estado == 'RJ'}"> selected</c:if>>RJ</option>
                            <option value="RN" <c:if test="${cliente.estado == 'RN'}"> selected</c:if>>RN</option>
                            <option value="RS" <c:if test="${cliente.estado == 'RS'}"> selected</c:if>>RS</option>
                            <option value="RO" <c:if test="${cliente.estado == 'RO'}"> selected</c:if>>RO</option>
                            <option value="RR" <c:if test="${cliente.estado == 'RR'}"> selected</c:if>>RR</option>
                            <option value="SC" <c:if test="${cliente.estado == 'SC'}"> selected</c:if>>SC</option>
                            <option value="SP" <c:if test="${cliente.estado == 'SP'}"> selected</c:if>>SP</option>
                            <option value="SE" <c:if test="${cliente.estado == 'SE'}"> selected</c:if>>SE</option>
                            <option value="TO" <c:if test="${cliente.estado == 'TO'}"> selected</c:if>>TO</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Cidade:</label></td>
                        <td><input type="text" name="txtCidade" value="${cliente.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>        
                        <td><label>Bairro:</label></td>
                        <td><input type="text" name="txtBairro" value="${cliente.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Logradouro:</label></td>
                        <td><input type="text" name="txtLogradouro" value="${cliente.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Número:</label></td>
                        <td><input type="number" name="numNumeroEndereco" value="${cliente.numeroEndereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Complemento:</label></td>
                        <td><input type="text" name="txtComplementoEndereco" value="${cliente.complementoEndereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>


                <tr><td><button id="CadastrarCliente">Confirmar</button></td></tr>

            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
