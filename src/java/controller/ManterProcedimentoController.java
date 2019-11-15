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
import model.Procedimento;

/**
 *
 * @author Iago
 */
public class ManterProcedimentoController extends HttpServlet{
    
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
                //request.setAttribute("classe do combo no plural", NomeClasse.obter a classe no plural()); para  as que tem combo
                if (!operacao.equals("Incluir")) {
                    int codProcedimento = Integer.parseInt(request.getParameter("codProcedimento"));
                    Procedimento procedimento = Procedimento.obterProcedimento(codProcedimento);
                    request.setAttribute("procedimento", procedimento);
                }
                RequestDispatcher view = request.getRequestDispatcher("/cadastrarProcedimento.jsp");
                view.forward(request, response);
            } catch (ServletException e) {
                throw e;
            } catch (IOException e) {
                throw new ServletException(e);
            } catch (SQLException e) {
                throw new ServletException(e);
            } catch (ClassNotFoundException e) {
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
            Logger.getLogger(ManterEspecieController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEspecieController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterEspecieController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEspecieController.class.getName()).log(Level.SEVERE, null, ex);
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
        int codProcedimento = Integer.parseInt(request.getParameter("txtCodProcedimento"));
        String nome = request.getParameter("txtNomeProcedimento");
        float valor = Float.parseFloat(request.getParameter("numValorProcedimento"));

        Procedimento procedimento = new Procedimento(codProcedimento, nome, valor);
        if (operacao.equals("Incluir")) {
            procedimento.gravar();
        } else {
            if (operacao.equals("Excluir")) {
                procedimento.excluir();
            } else {
                if (operacao.equals("Alterar")) {
                    procedimento.alterar();
                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaProcedimentoController");
        view.forward(request, response);

    }
}
