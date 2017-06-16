/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Monitor;
import br.edu.utfpr.beans.Questao;
import br.com.utfpr.model.DaoComentario;
import br.com.utfpr.model.DaoMonitor;
import br.com.utfpr.model.DaoQuestao;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SvComentarforum_m extends HttpServlet {

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
        DaoComentario daoComentario = new DaoComentario();
        DaoQuestao daoQuestao = new DaoQuestao();
        DaoMonitor daoMonitor = new DaoMonitor();
        Questao questao = new Questao();
        Monitor monitor = new Monitor();

        int id_questao = Integer.parseInt(request.getParameter("id_questao"));
        int id_monitor = Integer.parseInt(request.getParameter("id_monitor"));
        String comentario = request.getParameter("comentando");
        byte array[] = comentario.getBytes("ISO-8859-1");
        String novaString = new String(array, "UTF-8");
        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == id_questao) {
                questao = q;
            }
        }

        List<Monitor> monitores = daoMonitor.listaTodos();
        for (Monitor a : monitores) {
            if (a.getId() == id_monitor) {
                monitor = a;
            }
        }

        daoComentario.getComentario().setMonitor(monitor);
        daoComentario.getComentario().setQuestao(questao);
        daoComentario.getComentario().setConteudo(novaString);

        daoComentario.adiciona(daoComentario.getComentario());

        request.setAttribute("questao", questao);
        request.setAttribute("mensagem", "Comentário adicionado com sucesso !");
        RequestDispatcher rd = request.getRequestDispatcher("fazerComentario_m.jsp");
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
