/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.model.DaoAluno;
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
public class SvAlterarSenha_a extends HttpServlet {

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

        DaoAluno daoAluno = new DaoAluno();
        Aluno aluno = new Aluno();
        aluno = (Aluno) request.getSession(true).getAttribute("aluno");
        String senhaAntiga = request.getParameter("senhaAntiga");
        String senha1 = request.getParameter("senha1");
        String senha2 = request.getParameter("senha2");

        if (senhaAntiga.equals(aluno.getSenha())) {
            if (senha1.equals(senha2)) {
                aluno.setSenha(senha1);
                daoAluno.update(aluno);
                request.setAttribute("mensagem", "Senha alterada com sucesso !");
            } else {
                request.setAttribute("erro", "Senha e confirmação de senha não está igual !");
            }
        } else {
            request.setAttribute("erro", "Senha atual inválida !");
        }
        RequestDispatcher rd = request.getRequestDispatcher("recuperarSenha_a.jsp");
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
