/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.beans.Monitor;
import br.edu.utfpr.beans.Professor;
import br.com.utfpr.model.DaoAluno;
import br.com.utfpr.model.DaoImagem;
import br.com.utfpr.model.DaoMonitor;
import br.com.utfpr.model.DaoProfessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author popovicz
 */
public class SvLogin extends HttpServlet {

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

        DaoImagem img = new DaoImagem();
        DaoAluno alu = new DaoAluno();
        DaoProfessor prof = new DaoProfessor();
        DaoMonitor mon = new DaoMonitor();
        List<Aluno> alunos = new ArrayList<Aluno>();
        List<Monitor> monitores = new ArrayList<Monitor>();
        List<Professor> professores = new ArrayList<Professor>();

        String ra = request.getParameter("ra");
        String senha = request.getParameter("senha");

        if (ra.equals("igor") || ra.equals("ivanilton") || ra.equals("rafael")) {
            professores.addAll(prof.buscarPorLogin(ra));
            if (professores.size() > 0) {
                for (Professor professor : professores) {
                    if (ra != null && professor.getSenha().equals(senha)) {
                        request.getSession(true).setAttribute("professor", professor);
                        response.sendRedirect("paginas/inicial.jsp");
                    } else {
                        request.setAttribute("erro", "Login ou senha incorretos!!");
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                    }
                }
            } else {
                request.setAttribute("erro", "Login ou senha incorretos!!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } else if (ra.equals("willian") || ra.equals("michele")) {
            monitores.addAll(mon.buscarPorLogin(ra));
            if (monitores.size() > 0) {
                for (Monitor monitor : monitores) {
                    if (ra != null && monitor.getSenha().equals(senha)) {
                        request.getSession(true).setAttribute("monitor", monitor);
                        response.sendRedirect("paginas/inicial.jsp");
                    } else {
                        request.setAttribute("erro", "Login ou senha incorretos!!");
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                    }
                }
            } else {
                request.setAttribute("erro", "Login ou senha incorretos!!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } else {
            alunos.addAll(alu.buscarPorLogin(ra));
            if (alunos.size() > 0) {
                for (Aluno aluno : alunos) {
                    if (ra != null && aluno.getSenha().equals(senha)) {
                        request.getSession(true).setAttribute("aluno", aluno);
                        response.sendRedirect("paginas/inicial_a.jsp");
                    } else {
                        request.setAttribute("erro", "Login ou senha incorretos!!");
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        rd.forward(request, response);
                    }
                }
            } else {
                request.setAttribute("erro", "Login ou senha incorretos!!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }

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
