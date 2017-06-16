<%-- 
    Document   : alterarImagem_a
    Created on : 06/02/2017, 22:52:00
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Alterar Imagem</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body>
        <div>
            <div class="container">
                <jsp:include page="../include/menuTopProf.jsp" />
            </div>
            <%
                Professor professor = (Professor) session.getAttribute("professor");
                Monitor monitor = (Monitor) session.getAttribute("monitor");
                DaoImagem daoImagem = new DaoImagem();
                Imagem imagem = new Imagem();
                if (professor == null && monitor == null) {
                    response.sendRedirect("acessoRestrito.jsp");
                } else {
            %>  
            <div class="col-md-2" style="margin-top: 55px;">
                <jsp:include page="../include/menuProfessor.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px; margin-bottom: 15px;">
                <h2 class="col-md-offset-4"> Trocar Foto do Perfil </h2>
                <div class="col-md-4 col-sm-12" style="margin-top: 20px;">
                    <% if (professor != null) {
                            imagem = daoImagem.buscarPorId(professor.getImagem().getIdImagem());
                    %>
                    <img src="../upload/<%= professor.getId()%><%= imagem.getNomeArquivo()%>" style="width: 290px; height: 290px;" class="img-rounded">
                    <%} else {
                        imagem = daoImagem.buscarPorId(monitor.getImagem().getIdImagem());
                    %>
                    <img src="../upload/<%= monitor.getId()%><%= imagem.getNomeArquivo()%>" style="width: 290px; height: 290px;" class="img-rounded">
                    <% }%>
                </div>
                <div style="margin-top: 50px;">
                    <form id="form" action="<%= professor != null ? "SvAlterarImagem" : "SvAlterarImagem_m"%>" method="post" enctype="multipart/form-data">
                        <input id="file" name="file" type="file" style="font-size: 22px;">
                        <div style="margin-bottom: 15px; margin-top: 10px;">
                            <button type="submit" style="width: 180px;" class="btn btn-primary"><span class="glyphicon glyphicon-send" aria-hidden="true"></span> Enviar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="../include/footDentro.jsp" />
        <% }%>
    </body>
</html>
