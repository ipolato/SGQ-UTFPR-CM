/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Professor;
import br.com.utfpr.model.DaoProfessor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author popovicz
 */
public class SvAlterarSenha extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DaoProfessor daoProfessor = new DaoProfessor();
        Professor professor = new Professor();
        professor = (Professor) request.getSession(true).getAttribute("professor");
        String senhaAntiga = request.getParameter("senhaAntiga");
        String senha1 = request.getParameter("senha1");
        String senha2 = request.getParameter("senha2");

        if (senhaAntiga.equals(professor.getSenha())) {
            if (senha1.equals(senha2)) {
                professor.setSenha(senha1);
                daoProfessor.update(professor);
                request.setAttribute("mensagem", "Senha alterada com sucesso !");
            } else {
                request.setAttribute("erro", "Senha e confirmação de senha não está igual !");
            }
        } else {
            request.setAttribute("erro", "Senha atual inválida !");
        }
        RequestDispatcher rd = request.getRequestDispatcher("recuperarSenha.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
