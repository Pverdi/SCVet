/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;
import model.Item;

/**
 *
 * @author penel
 */
public class ManterItemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
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

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        {
            try {
                String operacao = request.getParameter("operacao");
                request.setAttribute("operacao", operacao);
                request.setAttribute("fornecedores", Fornecedor.obterFornecedores());/*fazer isso para as que tem combo*/
                if (!operacao.equals("Incluir")) {
                    int codItem = Integer.parseInt(request.getParameter("codItem"));
                    Item item = Item.obterItem(codItem);
                    request.setAttribute("item", item);
                }
                RequestDispatcher view = request.getRequestDispatcher("/cadastrarItem.jsp");
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
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterItemController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        String operacao = request.getParameter("operacao");
        int codItem = Integer.parseInt(request.getParameter("txtCodItem"));
        String nome = request.getParameter("txtNomeItem");
        String lote = request.getParameter("txtLoteItem");
        int quantidade = Integer.parseInt(request.getParameter("numQtdItem"));
        String tipo = request.getParameter("txtTipoItem");
        String vencimento = request.getParameter("txtVencimento");
        int codFornecedor = Integer.parseInt(request.getParameter("optFornecedor"));

        try {
            Fornecedor fornecedor = null;
            if (codFornecedor != 0) {
                fornecedor = Fornecedor.obterFornecedor(codFornecedor);
            }

            Item item = new Item(codItem, nome, lote, quantidade, tipo, vencimento, fornecedor);
            if (operacao.equals("Incluir")) {
                item.gravar();
            } else {
                if (operacao.equals("Excluir")) {
                    item.excluir();
                } else {
                    if (operacao.equals("Alterar")) {
                        item.alterar();
                    }
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("/PesquisaItemController");
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
