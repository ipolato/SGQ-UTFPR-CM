<%-- 
    Document   : alterarLogin
    Created on : 16/10/2016, 02:15:33
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Aluno"%>
<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Configuração</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body>
        <div>
            <div class="container">
                <jsp:include page="../include/menuTop.jsp" />
            </div>           
            <%
                Aluno aluno = (Aluno) session.getAttribute("aluno");
                if (aluno == null) {
                    response.sendRedirect("acessoRestrito.jsp");
                } else {
                    DaoImagem daoImagem = new DaoImagem();
                    Imagem imagem = new Imagem();
                    imagem = daoImagem.buscarPorId(aluno.getImagem().getIdImagem());
            %>  
            <div class="col-md-2" style="margin-top: 55px">
                <jsp:include page="../include/menuAluno.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px; margin-bottom: 15px;">
                <h2 class="col-md-offset-4"> Trocar Foto do Perfil </h2>
                <div class="col-md-4 col-sm-12" style="margin-top: 20px;">
                    <img src="../upload/<%= aluno.getId()%><%= imagem.getNomeArquivo()%>" style="width: 290px; height: 290px;" class="img-rounded">
                </div>
                <div style="margin-top: 50px;">
                    <form id="form" action="SvAlterarImagem_a" method="post" enctype="multipart/form-data">
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
