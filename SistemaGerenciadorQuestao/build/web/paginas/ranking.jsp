<%-- 
    Document   : ranking
    Created on : 28/09/2016, 20:23:34
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page import="br.com.utfpr.beans.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="br.com.utfpr.model.DaoAluno"%>
<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Ranking</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="container">
                <jsp:include page="../include/menuTopProf.jsp" />
            </div>
            <%
                Professor professor = (Professor) session.getAttribute("professor");
                Monitor monitor = (Monitor) session.getAttribute("monitor");
                if (professor == null && monitor == null) {
                    response.sendRedirect("acessoRestrito.jsp");
                } else {
            %>  
            <div class="row">
                <div class="col-md-2 col-xs-12" style="margin-top: 55px;"> 
                    <jsp:include page="../include/menuProfessor.jsp" />
                </div>
                <div class="col-md-10" style="margin-top: 55px">
                    <div class="col-md-offset-5 col-md-7 col-xs-12" style="margin-bottom: 30px;">
                        <h2 style="margin-left: 25px; font-weight: bold;" > Ranking </h2>
                    </div>
                    <%
                        DaoAluno daoAluno = new DaoAluno();
                        List<Aluno> alunos = daoAluno.listaOsDezMelhor();
                        DaoImagem daoImagem = new DaoImagem();
                        Imagem imagem1 = new Imagem();
                        Imagem imagem2 = new Imagem();
                        Imagem imagem3 = new Imagem();
                        if (alunos.size() >= 1) {
                            imagem1 = daoImagem.buscarPorId(alunos.get(0).getImagem().getIdImagem());
                    %>
                    <div class="col-md-offset-5 col-md-7 col-xs-12" style="margin-bottom: 30px;">
                        <% if(imagem1.getNomeArquivo().equals(" ")) {%> 
                        <img src="../img/user.png" class="img-responsive img-circle" style="width: 160px; height: 160px;" alt="Primeiro Lugar">
                         <% }else{ %>
                         <img src="../upload/<%= alunos.get(0).getId()%><%= imagem1.getNomeArquivo()%>" class="img-responsive img-circle" style="width: 160px; height: 160px;" alt="Primeiro Lugar">
                        <% } %>
                        <p style="margin-left: 45px; margin-top: 10px; font-weight: bold;">1º <%= alunos.size() >= 1 ? alunos.get(0).getNome() : "..."%></p>
                        <p style="margin-left: 45px; font-weight: bold;">Pontos: <%= alunos.size() >= 1 ? alunos.get(0).getPontosDeExperiencia() : "0"%></p>
                    </div>
                    <%}
                        if (alunos.size() >= 2) {
                            imagem2 = daoImagem.buscarPorId(alunos.get(1).getImagem().getIdImagem());%>  
                    <div class="col-md-3 col-xs-12 col-md-offset-3">
                        <% if(imagem2.getNomeArquivo().equals(" ")) {%> 
                        <img src="../img/user.png" class="img-responsive img-circle" style="width: 160px; height: 160px;" alt="Segundo Lugar">
                         <% }else{ %>
                         <img src="../upload/<%= alunos.get(1).getId()%><%= imagem2.getNomeArquivo()%>" class="img-responsive img-circle" style="width: 160px; height: 160px;" alt="Segundo Lugar">
                        <% } %>
                        <p style="margin-left: 45px; margin-top: 10px; font-weight: bold;">2º <%= alunos.size() >= 2 ? alunos.get(1).getNome() : "..."%></p>
                        <p style="margin-left: 45px; font-weight: bold;">Pontos: <%= alunos.size() >= 2 ? alunos.get(1).getPontosDeExperiencia() : "0"%></p>
                    </div>
                    <%}
                        if (alunos.size() >= 3) {
                            imagem3 = daoImagem.buscarPorId(alunos.get(2).getImagem().getIdImagem());%>  
                    <div class="col-md-offset-1 col-md-5 col-xs-12">
                        <% if(imagem3.getNomeArquivo().equals(" ")) {%> 
                        <img src="../img/user.png" class="img-responsive img-circle" style="width: 160px; height: 160px;" alt="Terceiro Lugar">
                         <% }else{ %>
                         <img src="../upload/<%= alunos.get(2).getId()%><%= imagem3.getNomeArquivo()%>" class="img-responsive img-circle" style="width: 160px; height: 160px;" alt="Terceiro Lugar">
                        <% } %>
                        <p style="margin-left: 45px; margin-top: 10px; font-weight: bold;">3º <%= alunos.size() >= 3 ? alunos.get(2).getNome() : "..."%></p>
                        <p style="margin-left: 45px; font-weight: bold;">Pontos: <%= alunos.size() >= 3 ? alunos.get(2).getPontosDeExperiencia() : "0"%></p>
                    </div>
                    <% }%>
                    <div class="col-md-8 col-xs-12 col-md-offset-2" style="margin-top: 50px;">
                        <table class="table table-bordered">
                            <tr>                        
                                <td class="success" style="width: 30px;">4º</td>
                                <td class="success"><%= alunos.size() >= 4 ? alunos.get(3).getNome() : "..."%></td>
                                <td class="success" style="width: 120px;"><%= alunos.size() >= 4 ? alunos.get(3).getPontosDeExperiencia() : "0"%></td>
                            </tr>
                            <tr>                        
                                <td class="success" style="width: 30px;">5º</td>
                                <td class="success"><%= alunos.size() >= 5 ? alunos.get(4).getNome() : "..."%></td>
                                <td class="success" style="width: 120px;"><%= alunos.size() >= 5 ? alunos.get(4).getPontosDeExperiencia() : "0"%></td>
                            </tr>
                            <tr>                        
                                <td class="success" style="width: 30px;">6º</td>
                                <td class="success"><%= alunos.size() >= 6 ? alunos.get(5).getNome() : "..."%></td>
                                <td class="success" style="width: 120px;"><%= alunos.size() >= 6 ? alunos.get(5).getPontosDeExperiencia() : "0"%></td>
                            </tr>
                            <tr>        
                                <td class="active" style="width: 30px;">7º</td>
                                <td class="active"><%= alunos.size() >= 7 ? alunos.get(6).getNome() : "..."%></td>
                                <td class="active" style="width: 120px;"><%= alunos.size() >= 7 ? alunos.get(6).getPontosDeExperiencia() : "0"%></td>
                            </tr>
                            <tr>        
                                <td class="active" style="width: 30px;">8º</td>
                                <td class="active"><%= alunos.size() >= 8 ? alunos.get(7).getNome() : "..."%></td>
                                <td class="active" style="width: 120px;"><%= alunos.size() >= 8 ? alunos.get(7).getPontosDeExperiencia() : "0"%></td>
                            </tr>
                            <tr>        
                                <td class="active" style="width: 30px;">9º</td>
                                <td class="active"><%= alunos.size() >= 9 ? alunos.get(8).getNome() : "..."%></td>
                                <td class="active" style="width: 120px;"><%= alunos.size() >= 9 ? alunos.get(8).getPontosDeExperiencia() : "0"%></td>
                            </tr>
                            <tr>
                                <td class="danger" style="width: 30px;">10º</td>
                                <td class="danger">
                                    <% if (alunos.size() >= 10) {
                                            out.print(alunos.get(9).getNome());
                                        } else {
                                            out.print("...");
                                        }
                                    %>
                                </td>
                                <td class="danger" style="width: 120px;"><%= alunos.size() >= 10 ? alunos.get(9).getPontosDeExperiencia() : "0"%></td>
                            </tr>

                        </table>
                    </div>
                </div>
            </div>
            <div class="row" >
                <footer class="container-fluid text-center" >
                    <p>&copy; 2016 Todos direitos reservados - Willian Popovicz   </p>
                </footer>
            </div>
            <jsp:include page="../include/footDentro.jsp" />
        </div>
        <% }%>
    </body>
</html>

