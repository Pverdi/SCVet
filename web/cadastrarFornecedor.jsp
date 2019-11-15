<%-- 
    Document   : cadastrarFornecedor
    Created on : 05/09/2019, 09:57:02
    Author     : lucsd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Fornecedor </title>
    </head>
    <body>
        <form action="ManterFornecedorController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmCadastrarFornecedor">
            <table>
                <h1>Cadastrar Fornecedor - ${operacao}</h1>
                <tr>
                    <td><label>Código:</label></td>
                    <td><input type="number" name="numCodFornecedor" value="${fornecedor.codFornecedor}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Nome da Empresa:</label></td>
                        <td><input type="text" name="txtNomeEmpresa" value="${fornecedor.nomeEmpresa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Nome de Contato:</label></td>
                        <td><input type="text" name="txtNomeContato" value="${fornecedor.nomeContato}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>CNPJ:</label></td>
                        <td><input type="number" name="numCnpj" value="${fornecedor.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Telefone(s):</label></td>
                        <td><input type="number" name="numTelefone1" value="${fornecedor.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td><label>Email:</label></td>
                        <td><input type="text" name="txtEmail" value="${fornecedor.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Endereço</label></td>
                    </tr>


                    <tr>
                        <td><label>CEP:</label></td>
                        <td><input type="number" name="numCep" value="${fornecedor.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Estado:</label></td>
                        <td><select id="UF" name="optEstado" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="AC" <c:if test="${fornecedor.estado == 'AL'}"> selected</c:if>>AC</option>
                            <option value="AL" <c:if test="${fornecedor.estado == 'AL'}"> selected</c:if>>AL</option>
                            <option value="AP" <c:if test="${fornecedor.estado == 'AP'}"> selected</c:if>>AP</option>
                            <option value="AM" <c:if test="${fornecedor.estado == 'AM'}"> selected</c:if>>AM</option>
                            <option value="BA" <c:if test="${fornecedor.estado == 'BA'}"> selected</c:if>>BA</option>
                            <option value="CE" <c:if test="${fornecedor.estado == 'CE'}"> selected</c:if>>CE</option>
                            <option value="DF" <c:if test="${fornecedor.estado == 'DF'}"> selected</c:if>>DF</option>
                            <option value="ES" <c:if test="${fornecedor.estado == 'ES'}"> selected</c:if>>ES</option>
                            <option value="GO" <c:if test="${fornecedor.estado == 'GO'}"> selected</c:if>>GO</option>
                            <option value="MA" <c:if test="${fornecedor.estado == 'MA'}"> selected</c:if>>MA</option>
                            <option value="MT" <c:if test="${fornecedor.estado == 'MT'}"> selected</c:if>>MT</option>
                            <option value="MS" <c:if test="${fornecedor.estado == 'MS'}"> selected</c:if>>MS</option>
                            <option value="MG" <c:if test="${fornecedor.estado == 'MG'}"> selected</c:if>>MG</option>
                            <option value="PA" <c:if test="${fornecedor.estado == 'PA'}"> selected</c:if>>PA</option>
                            <option value="PB" <c:if test="${fornecedor.estado == 'PB'}"> selected</c:if>>PB</option>
                            <option value="PR" <c:if test="${fornecedor.estado == 'PR'}"> selected</c:if>>PR</option>
                            <option value="PE" <c:if test="${fornecedor.estado == 'PE'}"> selected</c:if>>PE</option>
                            <option value="PI" <c:if test="${fornecedor.estado == 'PI'}"> selected</c:if>>PI</option>
                            <option value="RJ" <c:if test="${fornecedor.estado == 'RJ'}"> selected</c:if>>RJ</option>
                            <option value="RN" <c:if test="${fornecedor.estado == 'RN'}"> selected</c:if>>RN</option>
                            <option value="RS" <c:if test="${fornecedor.estado == 'RS'}"> selected</c:if>>RS</option>
                            <option value="RO" <c:if test="${fornecedor.estado == 'RO'}"> selected</c:if>>RO</option>
                            <option value="RR" <c:if test="${fornecedor.estado == 'RR'}"> selected</c:if>>RR</option>
                            <option value="SC" <c:if test="${fornecedor.estado == 'SC'}"> selected</c:if>>SC</option>
                            <option value="SP" <c:if test="${fornecedor.estado == 'SP'}"> selected</c:if>>SP</option>
                            <option value="SE" <c:if test="${fornecedor.estado == 'SE'}"> selected</c:if>>SE</option>
                            <option value="TO" <c:if test="${fornecedor.estado == 'TO'}"> selected</c:if>>TO</option>
                            </select></td>
                    </tr>


                    <tr>
                        <td><label>Cidade:</label></td>
                        <td><input type="text" name="txtCidade" value="${fornecedor.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Bairro:</label></td>
                        <td><input type="text" name="txtBairro" value="${fornecedor.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Logradouro:</label></td>
                        <td><input type="text" name="txtLogradouro" value="${fornecedor.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Número:</label></td>
                        <td><input type="number" name="numNumero" value="${fornecedor.numeroEndereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr>
                        <td><label>Complemento:</label></td>
                        <td><input type="text" name="txtComplemento" value="${fornecedor.complementoEndereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>

                <tr><td><button id="CadastrarFornecedor">Confirmar</button></td></tr>
            </table>
        </form>
        <input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>
