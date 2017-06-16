/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servlet;

import br.edu.utfpr.beans.Aluno;
import br.edu.utfpr.beans.Monitor;
import br.edu.utfpr.beans.Professor;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/paginas")
public class FiltroSeguranca implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        Aluno aluno = (Aluno) session.getAttribute("aluno");
        Professor professor = (Professor) session.getAttribute("professor");
        Monitor monitor = (Monitor) session.getAttribute("monitor");
        try {
            if (aluno == null && professor == null && monitor == null) {
                session.setAttribute("msg", "Você não está logado no sistema!");
                ((HttpServletResponse) res).sendRedirect("../login.jsp");

            } else {
                chain.doFilter(req, res);

            }
        } catch (IOException e) {
            e.getMessage();
            session.setAttribute("msg", "Você não está logado no sistema!");
            ((HttpServletResponse) res).sendRedirect("../login.jsp");
        }

    }

    public void destroy() {
    }
}