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
import model.Especie;
import model.Raca;

/**
 *
 * @author lucsd
 */
public class ManterRacaController extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException{
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
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("especies", Especie.obterEspecies());/*fazer isso para as que tem combo*/
            if (!operacao.equals("Incluir")) {
                int codRaca = Integer.parseInt(request.getParameter("codRaca"));
                Raca raca = Raca.obterRaca(codRaca);
                request.setAttribute("raca", raca);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarRaca.jsp");
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
            Logger.getLogger(ManterRacaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterRacaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterRacaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterRacaController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException {
        String operacao = request.getParameter("operacao");
        int codAnimal = Integer.parseInt(request.getParameter("numCodRaca"));
        String nome = request.getParameter("txtNomeRaca");
        String porte = request.getParameter("optPorteRaca");
        String personalidade = request.getParameter("optPersonalidade");
        int especieRaca = Integer.parseInt(request.getParameter("optEspecie"));

        try {
            Especie especie = null;
            if (especieRaca != 0) {
                especie = Especie.obterEspecie(especieRaca);
            }

            Raca raca = new Raca(codAnimal, nome, porte, personalidade, especie);
            if (operacao.equals("Incluir")) {
                raca.gravar();
            } else {
                if (operacao.equals("Excluir")) {
                    raca.excluir();
                } else {
                    if (operacao.equals("Alterar")) {
                        raca.alterar();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaRacaController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
}
