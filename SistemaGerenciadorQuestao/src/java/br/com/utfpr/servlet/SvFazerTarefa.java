/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.beans.Questao;
import br.com.utfpr.model.DaoAluno;
import br.com.utfpr.model.DaoQuestao;
import br.com.utfpr.model.DaoResposta;
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
public class SvFazerTarefa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int di = Integer.parseInt(request.getParameter("id"));
        DaoQuestao daoQuestao = new DaoQuestao();
        Questao questao = new Questao();
        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == di) {
                questao = q;
            }
        }
        request.setAttribute("questao", questao);
        RequestDispatcher rd = request.getRequestDispatcher("fazerExercicio.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoResposta daoResposta = new DaoResposta();
        DaoQuestao daoQuestao = new DaoQuestao();
        DaoAluno daoAluno = new DaoAluno();
        Aluno aluno = new Aluno();
        Questao questao = new Questao();

        int id_questao = Integer.parseInt(request.getParameter("id_questao"));
        int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
        String resposta = request.getParameter("resposta");
        byte array[] = resposta.getBytes("ISO-8859-1");
        String novaResposta = new String(array, "UTF-8");

        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == id_questao) {
                questao = q;
            }
        }

        List<Aluno> alunos = daoAluno.listaTodos();
        for (Aluno a : alunos) {
            if (a.getId() == id_aluno) {
                aluno = a;
            }
        }
        int medal = aluno.getMedLiv() + 1;
        int valor = aluno.getPontosDeExperiencia() + 50;
        aluno.setMedLiv(medal);
        aluno.setPontosDeExperiencia(valor);
        daoAluno.update(aluno);

        daoResposta.getResposta().setAluno(aluno);
        daoResposta.getResposta().setQuestao(questao);
        daoResposta.getResposta().setConteudo(novaResposta);
        daoResposta.getResposta().setStatus("em avaliação");
        daoResposta.adiciona(daoResposta.getResposta());

        request.setAttribute("mensagem", "O exercício " + questao.getTitulo() + " foi respondido com sucesso, aguarde sua nota ajudando o pessoal no forúm!");
        RequestDispatcher rd = request.getRequestDispatcher("exercicio.jsp");
        rd.forward(request, response);
        //response.sendRedirect("exercicio.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
