/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.com.utfpr.model.DaoDisciplina;
import br.com.utfpr.model.DaoQuestao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class SvCadastroTarefa extends HttpServlet {

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

        DaoDisciplina daoDisc = new DaoDisciplina();
        DaoQuestao daoQuestao = new DaoQuestao();

        String tarefa = request.getParameter("tarefa");
        String titulo = request.getParameter("titulo");
        byte array[] = tarefa.getBytes("ISO-8859-1");
        String novaTarefa = new String(array, "UTF-8");
        byte vetor[] = titulo.getBytes("ISO-8859-1");
        String novaTitulo = new String(vetor, "UTF-8");
        int di = Integer.parseInt(request.getParameter("cbDisciplina"));
        String aberta = request.getParameter("aberta");
        String encerramento = request.getParameter("encerramento");

        SimpleDateFormat dtFormData = new SimpleDateFormat("yyyy-MM-dd");
        Date dData = new Date();
        daoQuestao.getQuestao().setData_inicio(dData);
        try {
            dData = dtFormData.parse(encerramento);
            daoQuestao.getQuestao().setData_final(dData);
        } catch (ParseException ex) {
            Logger.getLogger(SvCadastroTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

        daoQuestao.getQuestao().setDisciplina(daoDisc.buscandoId(di));

        daoQuestao.getQuestao().setConteudo(novaTarefa);
        daoQuestao.getQuestao().setTitulo(novaTitulo);
        daoQuestao.getQuestao().setAberta(aberta.equals("S") ? true : false);
        daoQuestao.adiciona(daoQuestao.getQuestao());
        request.setAttribute("mensagem", "Tarefa adicionada com sucesso !");
        RequestDispatcher rd = request.getRequestDispatcher("tarefa.jsp");
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
