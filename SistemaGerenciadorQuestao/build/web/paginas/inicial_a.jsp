<%-- 
    Document   : inicial
    Created on : 25/09/2016, 14:43:04
    Author     : popovicz
--%>
<%@page import="br.com.utfpr.beans.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Inicial</title>
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
            %>  
            <div class="col-md-2 col-xs-12" style="margin-top: 55px;"> 
                <jsp:include page="../include/menuAluno.jsp" />
            </div>
            <div class="col-md-10 col-xs-12" style="margin-top: 55px">
                <%
                    String mensagem = (String) request.getAttribute("mensagem");
                    if (mensagem != null) {%>
                <div class="alert alert-success alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${mensagem}</strong>
                </div>
                <% }%>
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="../carrocel/escambo.jpg" style="height: 500px; width: 100%" alt="Escambo">
                        </div>
                        <div class="item">
                            <img src="../carrocel/sentiu_na_pele.jpg" style="height: 500px; width: 100%" alt="Sentiu na pele">
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <jsp:include page="../include/footDentro.jsp" />
        <% }%>
    </body>
</html>
