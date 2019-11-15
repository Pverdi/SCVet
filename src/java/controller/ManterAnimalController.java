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
import model.Cliente;
import model.Especie;
import model.Raca;

/**
 *
 * @author lucsd
 */
public class ManterAnimalController extends HttpServlet {

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
                request.setAttribute("racas", Raca.obterRacas());
                request.setAttribute("donos", Cliente.obterClientes());
                if (!operacao.equals("Incluir")) {
                    int codAnimal = Integer.parseInt(request.getParameter("codAnimal"));
                    Animal animal = Animal.obterAnimal(codAnimal);
                    request.setAttribute("animal", animal);
                }
                RequestDispatcher view = request.getRequestDispatcher("/cadastrarAnimal.jsp");
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
            Logger.getLogger(ManterAnimalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAnimalController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAnimalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAnimalController.class.getName()).log(Level.SEVERE, null, ex);
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
        int codAnimal = Integer.parseInt(request.getParameter("numCodAnimal"));
        String nome = request.getParameter("txtNomeAnimal");
        Float peso = Float.parseFloat(request.getParameter("numPeso"));
        String dtNascimento = request.getParameter("numDtNascimento");
        String tipoSanguineo = request.getParameter("txtTipoSanguineo");
        int codRaca = Integer.parseInt(request.getParameter("optRaca"));
        int codCliente = Integer.parseInt(request.getParameter("optDono"));

        try {
            Raca raca = null;
            if (codRaca != 0) {
                raca = Raca.obterRaca(codRaca);
            }
            Cliente dono = null;
            if (codCliente != 0) {
                dono = Cliente.obterCliente(codCliente);
            }
            Animal animal = new Animal(codAnimal, nome, peso, dtNascimento, tipoSanguineo, raca, dono);
            if (operacao.equals("Incluir")) {
                animal.gravar();
            } else {
                if (operacao.equals("Excluir")) {
                    animal.excluir();
                } else {
                    if (operacao.equals("Alterar")) {
                        animal.alterar();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaAnimalController");
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
