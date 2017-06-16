/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servlet;

import br.edu.utfpr.model.DaoAluno;
import br.edu.utfpr.model.DaoImagem;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author popovicz
 */
public class SvCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        DaoImagem img = new DaoImagem();
        DaoAluno cp = new DaoAluno();
        String path = "img/";
        try {

            String ra = request.getParameter("ra");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha1 = request.getParameter("senha1");
            String senha2 = request.getParameter("senha2");
            String sexo = request.getParameter("sexo");

            if (senha1.equals(senha2)) {

                cp.getAluno().setNome(nome);
                cp.getAluno().setRA(ra);
                cp.getAluno().setEmail(email);
                cp.getAluno().setSenha(senha1);
                cp.getAluno().setTipo("aluno");
                cp.getAluno().setSexo(sexo.equals("M") ? true : false);

                if (cp.getAluno().isSexo()) {
                    File arq = new File(path + "userHomem.png");
                    byte[] bFile = new byte[(int) arq.length()];
                    img.getImagem().setNomeArquivo("userHomem.png");


                } else {
                    File arq = new File(path + "userMulher.png");
                    byte[] bFile = new byte[(int) arq.length()];
                    img.getImagem().setNomeArquivo("userMulher.png");

                }
                img.adiciona(img.getImagem());

                cp.getAluno().setImagem(img.getImagem());
                cp.adiciona(cp.getAluno());
                request.getSession(true).setAttribute("aluno", cp.getAluno());
                response.sendRedirect("paginas/inicial.jsp");
            } else {
                //mesagem de erro
            }
        } finally {
            out.close();
        }

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
