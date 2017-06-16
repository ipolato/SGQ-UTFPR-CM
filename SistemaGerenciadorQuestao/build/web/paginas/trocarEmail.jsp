<%-- 
    Document   : trocarEmail_a
    Created on : 17/03/2017, 23:59:52
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Alterar E-mail</title>
        <jsp:include page="../include/headDentro.jsp" />
        <script>
            function valida_form(email) {
                var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                if (!filter.test(document.getElementById("email").value)) {
                    alert('Por favor, digite o email corretamente');
                    document.getElementById("email").focus();
                    return false
                }
            }
        </script>
    </head>
    <body>
        <div>
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
            <div class="col-md-2" style="margin-top: 55px;">
                <jsp:include page="../include/menuProfessor.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px">
                <%
                    String mensagem = (String) request.getAttribute("mensagem");
                    if (mensagem != null) {%>
                <div class="alert alert-success alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${mensagem}</strong>
                </div>
                <% }%>
                <form id="formulario1" action="<%= professor != null ? "SvAlterarEmail" : "SvAlterarEmail_m"%>" method="post">
                    <h2 class="col-md-offset-4 center"> Alterar E-mail  </h2>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" onblur="return valida_form(email)" class="form-control" id="email" name="email" placeholder="Digite um novo e-mail">
                    </div>
                    <button type="submit" class="btn btn-success col-md-offset-11" style="margin-bottom: 7px" >Alterar</button>
                </form>
            </div>
        </div>
        <jsp:include page="../include/footDentro.jsp" />
        <% }%>
    </body>
</html>
