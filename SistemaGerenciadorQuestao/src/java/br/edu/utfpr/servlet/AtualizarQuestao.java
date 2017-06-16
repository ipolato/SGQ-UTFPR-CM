/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servlet;

import br.edu.utfpr.beans.Questao;
import br.edu.utfpr.model.DaoDisciplina;
import br.edu.utfpr.model.DaoQuestao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author popovicz
 */
public class AtualizarQuestao extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("atualizandoTarefa.jsp");
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

        DaoDisciplina daoDisc = new DaoDisciplina();
        DaoQuestao daoQuestao = new DaoQuestao();
        Questao questao = new Questao();

        String tarefa = request.getParameter("tarefa");
        String titulo = request.getParameter("titulo");
        byte array[] = tarefa.getBytes("ISO-8859-1");
        String novaTarefa = new String(array, "UTF-8");
        byte vetor[] = titulo.getBytes("ISO-8859-1");
        String novaTitulo = new String(vetor, "UTF-8");
        int di = Integer.parseInt(request.getParameter("cbDisciplina"));
        int id = Integer.parseInt(request.getParameter("id"));
        String aberta = request.getParameter("aberta");
        String encerramento = request.getParameter("encerramento");

        List<Questao> questoes = daoQuestao.listaTodos();
        for (Questao q : questoes) {
            if (q.getId() == id) {
                questao = q;
            }
        }
        questao.setDisciplina(daoDisc.buscandoId(di));

        SimpleDateFormat dtFormData = new SimpleDateFormat("yyyy-MM-dd");
        Date dData;
        try {
            dData = dtFormData.parse(encerramento);
            questao.setData_final(dData);
        } catch (ParseException ex) {
            Logger.getLogger(SvCadastroTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

        questao.setConteudo(novaTarefa);
        questao.setTitulo(novaTitulo);
        questao.setAberta(aberta.equals("S") ? true : false);

        daoQuestao.update(questao);
        //response.sendRedirect("tarefa.jsp");
        request.setAttribute("questao", questao);
        request.setAttribute("mensagem", "Questão alterada com sucesso !");
        RequestDispatcher rd = request.getRequestDispatcher("tarefa.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
