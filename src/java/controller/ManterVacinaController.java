/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;
import model.Vacina;

/**
 *
 * @author lucsd
 */
public class ManterVacinaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        {
            try {
                String operacao = request.getParameter("operacao");
                request.setAttribute("operacao", operacao);
                request.setAttribute("fornecedores", Fornecedor.obterFornecedores());/*fazer isso para as que tem combo*/
                if (!operacao.equals("Incluir")) {
                    int codVacina = Integer.parseInt(request.getParameter("codVacina"));
                    Vacina vacina = Vacina.obterVacina(codVacina);
                    request.setAttribute("vacina", vacina);
                }
                RequestDispatcher view = request.getRequestDispatcher("/cadastrarVacina.jsp");
                view.forward(request, response);
            } catch (ServletException e) {
                throw e;
            } catch (IOException e) {
                throw new ServletException(e);
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (SQLException e) {
                throw new ServletException(e);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterVacinaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVacinaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterVacinaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVacinaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        String operacao = request.getParameter("operacao");
        int codVacina = Integer.parseInt(request.getParameter("numCodVacina"));
        String nome = request.getParameter("txtNome");
        String duracao = request.getParameter("txtDuracao");
        String descricao = request.getParameter("txtDescricao");
        float dose = Float.parseFloat(request.getParameter("txtDose"));
        String via = request.getParameter("optVia");
        String contraIndicacoes = request.getParameter("txtContraIndicacoes");
        float temperatura = Float.parseFloat(request.getParameter("txtTemperatura"));
        String lote = request.getParameter("txtLote");
        String tipo = "vacina";
        String vencimento = request.getParameter("txtVencimento");
        int codFornecedor = Integer.parseInt(request.getParameter("optFornecedor"));

        try {
            Fornecedor fornecedor = null;
            if (codFornecedor != 0) {
                fornecedor = Fornecedor.obterFornecedor(codFornecedor);
            }
            
            Vacina vacina = new Vacina(codVacina,
                     duracao, descricao, dose,
                    via, contraIndicacoes, temperatura, nome, lote, tipo, vencimento, fornecedor);

            if (operacao.equals("Incluir")) {
                vacina.gravar();
            } else {
                if (operacao.equals("Excluir")) {
                    vacina.excluir();
                } else {
                    if (operacao.equals("Alterar")) {
                        vacina.alterar();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaVacinaController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
}
