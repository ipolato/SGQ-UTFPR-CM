/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.beans.Monitor;
import br.edu.utfpr.beans.Professor;
import br.com.utfpr.controle.NovaSenha;
import br.com.utfpr.model.DaoAluno;
import br.com.utfpr.model.DaoMonitor;
import br.com.utfpr.model.DaoProfessor;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author popovicz
 */
public class SvNovaSenha extends HttpServlet {

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
        String email = request.getParameter("email");
        NovaSenha ns = new NovaSenha();
        String nova_senha = ns.gerar();
        boolean verdade = false;

        DaoAluno daoAluno = new DaoAluno();
        DaoProfessor daoProfessor = new DaoProfessor();
        DaoMonitor daoMonitor = new DaoMonitor();

        Professor professor = new Professor();
        List<Professor> professores = daoProfessor.listaTodos();
        for (Professor p : professores) {
            if (p.getEmail().equals(email) && p.getEmail() != null) {
                professor = p;
                p.setSenha(nova_senha);
                daoProfessor.update(professor);
                verdade = true;
            }
        }

        Monitor monitor = new Monitor();
        List<Monitor> monitores = daoMonitor.listaTodos();
        for (Monitor m : monitores) {
            if (m.getEmail().equals(email) && m.getEmail() != null) {
                monitor = m;
                m.setSenha(nova_senha);
                daoMonitor.update(monitor);
                verdade = true;
            }
        }

        Aluno aluno = new Aluno();
        List<Aluno> Alunos = daoAluno.listaTodos();
        for (Aluno a : Alunos) {
            if (a.getEmail().equals(email) && a.getEmail() != null) {
                aluno = a;
                a.setSenha(nova_senha);
                daoAluno.update(aluno);
                verdade = true;
            }
        }

        if (verdade) {
            Properties props = new Properties();
            /**
             * Parâmetros de conexão com servidor Gmail
             */
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sgqutfpr@gmail.com", "35230575sgqutfpr");
                }
            });
            /**
             * Ativa Debug para sessão
             */
            session.setDebug(true);
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("sgqutfpr@gmail.com")); //Remetente

                Address[] toUser = InternetAddress.parse(email);
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Nova senha do SGQ");//Assunto
                message.setText("Sua nova Senha : " + nova_senha);
                /**
                 * Método para enviar a mensagem criada
                 */
                Transport.send(message);
                request.setAttribute("mensagem", "Uma nova senha foi enviado para seu e-mail!");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("erro", "Email inválido!");
        }
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
