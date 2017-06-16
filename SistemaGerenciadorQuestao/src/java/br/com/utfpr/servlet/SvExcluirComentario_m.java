/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.beans.Comentario;
import br.edu.utfpr.beans.Curtir;
import br.edu.utfpr.beans.Monitor;
import br.edu.utfpr.beans.Questao;
import br.com.utfpr.model.DaoAluno;
import br.com.utfpr.model.DaoComentario;
import br.com.utfpr.model.DaoCurtir;
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
public class SvExcluirComentario_m extends HttpServlet {

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
        DaoQuestao daoQuestao = new DaoQuestao();
        Questao questao = new Questao();
        Comentario comentario = new Comentario();
        Curtir curtir = new Curtir();
        DaoAluno daoAluno = new DaoAluno();
        Aluno alunito = new Aluno();
        Aluno alun = new Aluno();
//        Monitor monitor = new Monitor();
//        DaoMonitor daoMonitor = new DaoMonitor();
        DaoCurtir daoCurtir = new DaoCurtir();
        DaoComentario daoComentario = new DaoComentario();

        List<Comentario> comentarios = daoComentario.listaTodos();
        for (Comentario c : comentarios) {
            if (c.getId() == Integer.parseInt(request.getParameter("id"))) {
                comentario = c;
            }
        }
//        List<Monitor> monitores = daoMonitor.listaTodos();
//        for (Monitor m : monitores) {
//            if (m.getId() == Integer.parseInt(request.getParameter("id_pessoa"))) {
//                monitor = m;
//            }
//        }
//        
        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == comentario.getQuestao().getId()) {
                questao = q;
            }
        }
        int valorMedal = 0;
        int valorMedalCom = 0;
        if (comentario.getAluno() != null) {
            alun = daoAluno.buscarPorId(comentario.getAluno().getId());
            valorMedalCom = alun.getMedCom() - 1;
            valorMedal = alun.getMedal();
            alun.setMedCom(valorMedalCom);
        }
        List<Curtir> curtidas = daoCurtir.listaTodos();
        for (Curtir cd : curtidas) {
            if (cd.getComentario().getId() == comentario.getId()) {
                curtir = cd;
                if (cd.getAluno() != null) {
                    alunito = daoAluno.buscarPorId(cd.getAluno().getId());
                    int valorDePonto = alunito.getPontosDeExperiencia() - 10;
                    alunito.setPontosDeExperiencia(valorDePonto);
                    daoAluno.update(alunito);
                }
                valorMedal -= 1;
                daoCurtir.removePorId(curtir.getId());
            }
        }
        if (comentario.getAluno() != null) {
            alun.setMedal(valorMedal);
            daoAluno.update(alun);
        }
        daoComentario.removePorId(comentario.getId());
        request.setAttribute("questao", questao);
        request.setAttribute("mensagem", "Comentário excluído com sucesso!");
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
