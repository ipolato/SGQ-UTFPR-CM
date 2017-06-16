/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Monitor;
import br.edu.utfpr.beans.Professor;
import br.edu.utfpr.beans.Questao;
import br.com.utfpr.model.DaoComentario;
import br.com.utfpr.model.DaoMonitor;
import br.com.utfpr.model.DaoProfessor;
import br.com.utfpr.model.DaoQuestao;
import java.io.IOException;
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
public class SvComentarforum extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        DaoProfessor daoProfessor = new DaoProfessor();
        Professor professor = new Professor();
        professor = (Professor) request.getSession(true).getAttribute("professor");
        DaoMonitor daoMonitor = new DaoMonitor();
        Monitor monitor = new Monitor();
        monitor = (Monitor) request.getSession(true).getAttribute("monitor");
        RequestDispatcher rd = null;
        int di = Integer.parseInt(request.getParameter("id"));
        DaoQuestao daoQuestao = new DaoQuestao();
        Questao questao = new Questao();
        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == di) {
                questao = q;
            }
        }

        if (professor != null) {
            request.setAttribute("questao", questao);
            request.setAttribute("professor", professor);
            rd = request.getRequestDispatcher("fazerComentario.jsp");

        }
        if (monitor != null) {
            request.setAttribute("questao", questao);
            request.setAttribute("monitor", monitor);
            rd = request.getRequestDispatcher("fazerComentario_m.jsp");

        }
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
        DaoComentario daoComentario = new DaoComentario();
        DaoQuestao daoQuestao = new DaoQuestao();
        DaoProfessor daoProfessor = new DaoProfessor();
        Questao questao = new Questao();
        Professor professor = new Professor();

        int id_questao = Integer.parseInt(request.getParameter("id_questao"));
        int id_professor = Integer.parseInt(request.getParameter("id_professor"));
        String comentario = request.getParameter("comentando");
        byte array[] = comentario.getBytes("ISO-8859-1");
        String novaString = new String(array, "UTF-8");

        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == id_questao) {
                questao = q;
            }
        }

        List<Professor> professores = daoProfessor.listaTodos();
        for (Professor a : professores) {
            if (a.getId() == id_professor) {
                professor = a;
            }
        }

        daoComentario.getComentario().setProfessor(professor);
        daoComentario.getComentario().setQuestao(questao);
        daoComentario.getComentario().setConteudo(novaString);

        daoComentario.adiciona(daoComentario.getComentario());

        request.setAttribute("questao", questao);
        request.setAttribute("mensagem", "Comentário adicionado com sucesso !");
        RequestDispatcher rd = request.getRequestDispatcher("fazerComentario.jsp");
        rd.forward(request, response);
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
