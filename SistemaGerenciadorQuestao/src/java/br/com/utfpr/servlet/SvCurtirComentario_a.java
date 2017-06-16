/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.beans.Comentario;
import br.edu.utfpr.beans.Curtir;
import br.edu.utfpr.beans.Questao;
import br.com.utfpr.model.DaoAluno;
import br.com.utfpr.model.DaoComentario;
import br.com.utfpr.model.DaoCurtir;
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
public class SvCurtirComentario_a extends HttpServlet {

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

        DaoComentario daoComentario = new DaoComentario();
        Comentario comentario = new Comentario();
        DaoCurtir daoCurtir = new DaoCurtir();
        DaoAluno daoAluno = new DaoAluno();
        Aluno aluno = new Aluno();
        Aluno alun = new Aluno();
        Questao questao = new Questao();
        DaoQuestao daoQuestao = new DaoQuestao();
        int valor = 0;

        int coment = (Integer.parseInt(request.getParameter("id_comentario")));
        int di = (Integer.parseInt(request.getParameter("id_questao")));
        int alu = (Integer.parseInt(request.getParameter("id_aluno")));
        boolean x = true;
        List<Aluno> alunos = daoAluno.listaTodos();
        for (Aluno a : alunos) {
            if (a.getId() == alu) {
                aluno = a;
            }
        }

        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == di) {
                questao = q;
            }
        }

        List<Comentario> comentarios = daoComentario.listaTodos();
        for (Comentario c : comentarios) {
            if (c.getId() == coment) {
                comentario = c;
            }
        }
        int valorMedal = 0;
        if (comentario.getAluno() != null) {
            alun = daoAluno.buscarPorId(comentario.getAluno().getId());
            valorMedal = alun.getMedal();
        }
        List<Curtir> curtidas = daoCurtir.listaTodos();
        for (Curtir cur : curtidas) {
            if (cur.getAluno() != null) {
                if (cur.getComentario().getId() == comentario.getId() && cur.getAluno().getId() == aluno.getId()) {
                    daoCurtir.removePorId(cur.getId());
                    x = false;
                    valor = aluno.getPontosDeExperiencia() - 10;
                    valorMedal -= 1;
                    request.setAttribute("mensagem", "Você descurtiu o comentário !");
                }
            }
        }

        if (x) {
            daoCurtir.getCurtir().setComentario(comentario);
            daoCurtir.getCurtir().setAluno(aluno);
            daoCurtir.adiciona(daoCurtir.getCurtir());
            valor = aluno.getPontosDeExperiencia() + 10;
            valorMedal += 1;
            request.setAttribute("mensagem", "Você curtiu o comentário !");
        }
        if (comentario.getAluno() != null) {
            alun.setMedal(valorMedal);
            daoAluno.update(alun);
        }
        aluno.setPontosDeExperiencia(valor);
        daoAluno.update(aluno);

        request.setAttribute("questao", questao);
        RequestDispatcher rd = request.getRequestDispatcher("fazerComentario_a.jsp");
        rd.forward(request, response);
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
