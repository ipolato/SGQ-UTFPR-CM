/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.beans.Questao;
import br.edu.utfpr.beans.Resposta;
import br.edu.utfpr.model.DaoAluno;
import br.edu.utfpr.model.DaoQuestao;
import br.edu.utfpr.model.DaoResposta;
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
public class AvaliarQuestao extends HttpServlet {

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
    Aluno aluno = new Aluno();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int di = Integer.parseInt(request.getParameter("id_questao"));
        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
        DaoQuestao daoQuestao = new DaoQuestao();
        DaoAluno daoAluno = new DaoAluno();
        Questao questao = new Questao();


        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == di) {
                questao = q;
            }
        }
        List<Aluno> alunos = daoAluno.listaTodos();
        for (Aluno a : alunos) {
            if (a.getId() == id_aluno) {
                aluno = a;
            }
        }
        request.setAttribute("questao", questao);
        request.setAttribute("aluno", aluno);
        RequestDispatcher rd = request.getRequestDispatcher("corrigindoTarefa.jsp");
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

        DaoResposta daoResposta = new DaoResposta();
        Resposta resposta = new Resposta();
        DaoQuestao daoQuestao = new DaoQuestao();
        Questao questao = new Questao();
        DaoAluno daoAluno = new DaoAluno();
        Aluno aluno = new Aluno();
        int valor = 0;
        int medalDaNotaExc = 0;
        int medalDaNotaBoa = 0;
        int medalDaNotaMed = 0;
        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
        int id_questao = Integer.parseInt(request.getParameter("id_questao"));
        int id_resposta = Integer.parseInt(request.getParameter("id_resposta"));
        String nota = request.getParameter("nota");

        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == id_questao) {
                questao = q;
            }
        }
        List<Resposta> respostas = daoResposta.listaTodos();
        for (Resposta r : respostas) {
            if (r.getId() == id_resposta) {
                resposta = r;
            }
        }

        List<Aluno> alunos = daoAluno.listaTodos();
        for (Aluno a : alunos) {
            if (a.getId() == id_aluno) {
                aluno = a;
            }
        }

        if (nota.equals("excelente")) {
            valor = aluno.getPontosDeExperiencia() + 50;
            medalDaNotaExc = aluno.getTreEst() + 1;
            medalDaNotaBoa = aluno.getDuaEst();
            medalDaNotaMed = aluno.getUmaEst();
        } else if (nota.equals("boa")) {
            valor = aluno.getPontosDeExperiencia() + 35;
            medalDaNotaExc = aluno.getTreEst();
            medalDaNotaBoa = aluno.getDuaEst() + 1;
            medalDaNotaMed = aluno.getUmaEst();
        } else if (nota.equals("mediana")) {
            valor = aluno.getPontosDeExperiencia() + 25;
            medalDaNotaExc = aluno.getTreEst();
            medalDaNotaBoa = aluno.getDuaEst();
            medalDaNotaMed = aluno.getUmaEst() + 1;
        } else if (nota.equals("ruim")) {
            valor = aluno.getPontosDeExperiencia() + 10;
        }

        aluno.setTreEst(medalDaNotaExc);
        aluno.setDuaEst(medalDaNotaBoa);
        aluno.setUmaEst(medalDaNotaMed);
        aluno.setPontosDeExperiencia(valor);
        daoAluno.update(aluno);

        resposta.setStatus(nota);
        daoResposta.update(resposta);

        request.setAttribute("questao", questao);
        request.setAttribute("mensagem", questao.getTitulo() + " foi atribuido a nota " + nota + " para o aluno " + aluno.getNome());
        RequestDispatcher rd = request.getRequestDispatcher("corrigirTarefa.jsp");
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
