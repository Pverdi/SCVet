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
import model.Animal;
import model.Procedimento;
import model.Prontuario;
import model.Vacina;

/**
 *
 * @author lucsd
 */
public class ManterProntuarioController extends HttpServlet {

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
                request.setAttribute("animais", Animal.obterAnimais());
                request.setAttribute("vacinas", Vacina.obterVacinas());
                request.setAttribute("procedimentos", Procedimento.obterProcedimentos());
                if (!operacao.equals("Incluir")) {
                    int codProntuario = Integer.parseInt(request.getParameter("codProntuario"));
                    Prontuario prontuario = Prontuario.obterProntuario(codProntuario);
                    request.setAttribute("prontuario", prontuario);
                }
                RequestDispatcher view = request.getRequestDispatcher("/cadastrarProntuario.jsp");
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
            Logger.getLogger(ManterProntuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProntuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterProntuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProntuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
        int codProntuario = Integer.parseInt(request.getParameter("txtCodProntuario"));
        String data = request.getParameter("txtData");
        int hora = Integer.parseInt(request.getParameter("txtHora"));
        String descricao = request.getParameter("txtDescricao");
        int codAnimal = Integer.parseInt(request.getParameter("optAnimal"));
        int codVacina = Integer.parseInt(request.getParameter("optVacina"));
        int codProcedimento = Integer.parseInt(request.getParameter("optProcedimento"));

        try {
            Animal animal = null;
            if (codAnimal != 0) {
                animal = Animal.obterAnimal(codAnimal);
            }
            Vacina vacina = null;
            if (codVacina != 0) {
                vacina = Vacina.obterVacina(codVacina);
            }
             Procedimento procedimento = null;
            if (codProcedimento != 0) {
                procedimento = Procedimento.obterProcedimento(codProcedimento);
            }
            Prontuario prontuario = new Prontuario(codProntuario, data, hora, descricao, vacina, animal, procedimento);
            if (operacao.equals("Incluir")) {
                prontuario.gravar();
            } else {
                if (operacao.equals("Excluir")) {
                    prontuario.excluir();
                } else {
                    if (operacao.equals("Alterar")) {
                        prontuario.alterar();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaProntuarioController");
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
