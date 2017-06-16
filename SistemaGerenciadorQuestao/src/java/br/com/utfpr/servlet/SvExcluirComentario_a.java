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
public class SvExcluirComentario_a extends HttpServlet {

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
        DaoAluno daoAluno = new DaoAluno();
        Aluno aluno1 = new Aluno();
        Aluno aluno = new Aluno();
        Aluno alunito = new Aluno();
        Questao questao = new Questao();
        DaoCurtir daoCurtir = new DaoCurtir();
        Curtir curtir = new Curtir();
        Comentario comentario = new Comentario();
        DaoComentario daoComentario = new DaoComentario();
        daoComentario.buscarPorId(Integer.parseInt(request.getParameter("id")));
        aluno1 = (Aluno) request.getSession(true).getAttribute("aluno");
        aluno = daoAluno.buscarPorId(aluno1.getId());

        List<Comentario> comentarios = daoComentario.listaTodos();
        for (Comentario c : comentarios) {
            if (c.getId() == Integer.parseInt(request.getParameter("id"))) {
                comentario = c;
            }
        }

        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == comentario.getQuestao().getId()) {
                questao = q;
            }
        }
        int valor2 = aluno.getMedal();
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
                valor2 -= 1;
                daoCurtir.removePorId(curtir.getId());
            }
        }

        int valor = aluno.getPontosDeExperiencia() - 20;
        int valor1 = aluno.getMedCom() - 1;
        aluno.setMedal(valor2);
        aluno.setMedCom(valor1);
        aluno.setPontosDeExperiencia(valor);
        daoAluno.update(aluno);

        daoComentario.removePorId(comentario.getId());

        request.setAttribute("questao", questao);
        request.setAttribute("mensagem", "Comentário excluído com sucesso!");
        RequestDispatcher rd = request.getRequestDispatcher("fazerComentario_a.jsp");
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
