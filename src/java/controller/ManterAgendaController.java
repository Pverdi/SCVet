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
import model.Agenda;
import model.Animal;
import model.Cliente;
import model.Funcionario;

/**
 *
 * @author lucsd
 */
public class ManterAgendaController extends HttpServlet {

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
                request.setAttribute("clientes", Cliente.obterClientes());
                request.setAttribute("veterinarios", Funcionario.obterFuncionarios());
                if (!operacao.equals("Incluir")) {
                    int codAgenda = Integer.parseInt(request.getParameter("codAgenda"));
                    Agenda agenda = Agenda.obterAgenda(codAgenda);
                    request.setAttribute("agenda", agenda);
                }
                RequestDispatcher view = request.getRequestDispatcher("/cadastrarAgenda.jsp");
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

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException {
        String operacao = request.getParameter("operacao");
        int codAgenda = Integer.parseInt(request.getParameter("numCodAgenda"));
        String data = request.getParameter("numData");
        int hora = Integer.parseInt(request.getParameter("numHora"));
        int numeroSala = Integer.parseInt(request.getParameter("numNumeroSala"));
        String tipoAtendimento = request.getParameter("optTipoAtendimento");
        int codCliente = Integer.parseInt(request.getParameter("optCliente"));
        int codAnimal = Integer.parseInt(request.getParameter("optAnimal"));
        int codFuncionario = Integer.parseInt(request.getParameter("optFuncionario"));

        try {
            Cliente cliente = null;
            if (codCliente != 0) {
                cliente = Cliente.obterCliente(codCliente);
            }

            Animal animal = null;
            if (codAnimal != 0) {
                animal = Animal.obterAnimal(codAnimal);
            }

            Funcionario veterinario = null;
            if (codFuncionario != 0) {
                veterinario = Funcionario.obterFuncionario(codFuncionario);
            }

            Agenda agenda = new Agenda(codAgenda, data, hora, numeroSala, tipoAtendimento, cliente, animal, veterinario);
            if (operacao.equals("Incluir")) {
                agenda.gravar();
            } else {
                if (operacao.equals("Excluir")) {
                    agenda.excluir();
                } else {
                    if (operacao.equals("Alterar")) {
                        agenda.alterar();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaAgendaController");
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
            Logger.getLogger(ManterAgendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAgendaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAgendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAgendaController.class.getName()).log(Level.SEVERE, null, ex);
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

}
