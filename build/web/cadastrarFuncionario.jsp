<%-- 
    Document   : cadastrarFuncionario
    Created on : 05/09/2019, 09:49:12
    Author     : lucsd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionário</title>
    </head>
    <body>
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarFuncionario">
            <h1>Cadastrar Funcionário - ${operacao}</h1>
            <table>


                <tr>
                    <td><label>Código:</label></td>
                    <td><input type="number" name="numCodFuncionario" value="${funcionario.codFuncionario}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Nome:</label></td>
                        <td><input type="text" name="txtNome" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>CPF:</label></td>
                        <td><input type="number" name="numCpf" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>RG:</label></td>
                        <td><input type="number" name="numRg" value="${funcionario.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Telefone(s):</label></td>
                        <td><input type="number" name="numTelefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Email:</label></td>
                        <td><input type="text" name="txtEmail" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Cargo:</label></td>
                        <td><select name="optCargo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Veterinário" <c:if test="${funcionario.cargo == 'Veterinário'}"> selected</c:if>>Veterinário</option>
                            <option value="Atendente" <c:if test="${funcionario.cargo == 'Atendente'}"> selected</c:if>>Atendente</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Turno:</label></td>
                        <td><select name="optTurno"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Manhã" <c:if test="${funcionario.turno == 'Manhã'}"> selected</c:if>>Manhã</option>
                            <option value="Tarde" <c:if test="${funcionario.turno == 'Tarde'}"> selected</c:if>>Tarde</option>
                            <option value="Noite" <c:if test="${funcionario.turno == 'Noite'}"> selected</c:if>>Noite</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Especialização:</label></td>
                        <td><input type="text" name="txtEspecializacao" value="${funcionario.especializacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Data de Admissão:</label></td>
                        <td><input type="date" value="${funcionario.dtAdmissao}" name="numDtAdmissao" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Endereço</label></td>
                    </tr>


                    <tr>
                        <td><label>CEP:</label></td>
                        <td><input type="number" name="numCep" value="${funcionario.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Estado:</label></td>
                        <td><select id="UF" name="optEstado" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="AC" <c:if test="${funcionario.estado == 'AL'}"> selected</c:if>>AC</option>
                            <option value="AL" <c:if test="${funcionario.estado == 'AL'}"> selected</c:if>>AL</option>
                            <option value="AP" <c:if test="${funcionario.estado == 'AP'}"> selected</c:if>>AP</option>
                            <option value="AM" <c:if test="${funcionario.estado == 'AM'}"> selected</c:if>>AM</option>
                            <option value="BA" <c:if test="${funcionario.estado == 'BA'}"> selected</c:if>>BA</option>
                            <option value="CE" <c:if test="${funcionario.estado == 'CE'}"> selected</c:if>>CE</option>
                            <option value="DF" <c:if test="${funcionario.estado == 'DF'}"> selected</c:if>>DF</option>
                            <option value="ES" <c:if test="${funcionario.estado == 'ES'}"> selected</c:if>>ES</option>
                            <option value="GO" <c:if test="${funcionario.estado == 'GO'}"> selected</c:if>>GO</option>
                            <option value="MA" <c:if test="${funcionario.estado == 'MA'}"> selected</c:if>>MA</option>
                            <option value="MT" <c:if test="${funcionario.estado == 'MT'}"> selected</c:if>>MT</option>
                            <option value="MS" <c:if test="${funcionario.estado == 'MS'}"> selected</c:if>>MS</option>
                            <option value="MG" <c:if test="${funcionario.estado == 'MG'}"> selected</c:if>>MG</option>
                            <option value="PA" <c:if test="${funcionario.estado == 'PA'}"> selected</c:if>>PA</option>
                            <option value="PB" <c:if test="${funcionario.estado == 'PB'}"> selected</c:if>>PB</option>
                            <option value="PR" <c:if test="${funcionario.estado == 'PR'}"> selected</c:if>>PR</option>
                            <option value="PE" <c:if test="${funcionario.estado == 'PE'}"> selected</c:if>>PE</option>
                            <option value="PI" <c:if test="${funcionario.estado == 'PI'}"> selected</c:if>>PI</option>
                            <option value="RJ" <c:if test="${funcionario.estado == 'RJ'}"> selected</c:if>>RJ</option>
                            <option value="RN" <c:if test="${funcionario.estado == 'RN'}"> selected</c:if>>RN</option>
                            <option value="RS" <c:if test="${funcionario.estado == 'RS'}"> selected</c:if>>RS</option>
                            <option value="RO" <c:if test="${funcionario.estado == 'RO'}"> selected</c:if>>RO</option>
                            <option value="RR" <c:if test="${funcionario.estado == 'RR'}"> selected</c:if>>RR</option>
                            <option value="SC" <c:if test="${funcionario.estado == 'SC'}"> selected</c:if>>SC</option>
                            <option value="SP" <c:if test="${funcionario.estado == 'SP'}"> selected</c:if>>SP</option>
                            <option value="SE" <c:if test="${funcionario.estado == 'SE'}"> selected</c:if>>SE</option>
                            <option value="TO" <c:if test="${funcionario.estado == 'TO'}"> selected</c:if>>TO</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Cidade:</label></td>
                        <td><input type="text" name="txtCidade" value="${funcionario.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Bairro:</label></td>
                        <td><input type="text" name="txtBairro" value="${funcionario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Logradouro:</label></td>
                        <td><input type="text" name="txtLogradouro" value="${funcionario.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Número:</label></td>
                        <td><input type="number" name="numNumeroEndereco" value="${funcionario.numeroEndereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Complemento:</label></td>
                        <td><input type="text" name="txtComplementoEndereco" value="${funcionario.complementoEndereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>


                <tr>
                    <td><button id="CadastrarFuncionario">Confirmar</button></td>
                </tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
