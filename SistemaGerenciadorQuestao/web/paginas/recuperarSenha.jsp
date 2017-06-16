<%-- 
    Document   : recuperarSenha_a
    Created on : 16/03/2017, 23:42:21
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGQ - Alterar senha</title>
        <jsp:include page="../include/headDentro.jsp" />
        <script>
            function valida_senha(x1, x2) {
                var senha1 = x1.value;
                var senha2 = x2.value;
                if(senha1.eq(senha2)){
                    return true;
                }else{
                    alert('Por favor, digite as duas senha igual');
                    document.getElementById("senha2").focus();
                    return false
                }
            }
        </script>
    </head>
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
                String erro = (String) request.getAttribute("erro");
                if (mensagem != null) {%>
            <div class="alert alert-success alert-dismissible" role="alert" >
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>${mensagem}</strong>
            </div>
            <% }%>
            <%   if (erro != null) {%>
            <div class="alert alert-danger alert-dismissible" role="alert" >
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>${erro}</strong>
            </div>
            <%  }%>
            <h2 class="col-md-offset-4 center"> Alterar Senha </h2>
            <form id="formulario1" action="<%= professor != null ? "SvAlterarSenha" : "SvAlterarSenha_m"%>" method="post">
                <div class="form-group">
                    <label for="senhaAntiga">Senha atual</label>
                    <input type="password" class="form-control" id="senhaAntiga" name="senhaAntiga" placeholder="Senha atual">
                </div>
                <div class="form-group">
                    <label for="senha1">Nova senha</label>
                    <input type="password" class="form-control" id="senha1" name="senha1" placeholder="nova senha">
                </div>
                <div class="form-group">
                    <label for="senha2">Confirma senha</label>
                    <input type="password" onblur="return valida_senha(senha1, senha2)" class="form-control" id="senha2" name="senha2" placeholder="confirmar nova senha">
                </div>
                <button type="submit" class="btn btn-success col-md-offset-11" style="margin-bottom: 7px" >Alterar</button>
            </form>
        </div>
    </div>
    <jsp:include page="../include/footDentro.jsp" />
    <% }%>
</body>
</html>
