<%-- 
    Document   : CorrigirTarefa
    Created on : 01/11/2016, 11:38:06
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page import="br.com.utfpr.beans.Questao"%>
<%@page import="br.com.utfpr.beans.Resposta"%>
<%@page import="br.com.utfpr.model.DaoResposta"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Gerenciador de questao">
        <meta name="author" content="Willian Lopes Popovicz">
        <link rel="icon" href="../img/favicon.ico">
        <title>SGQ - Corrigir Tarefa</title>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#minhaTabela').dataTable();
        });
    </script>
</head>
<body>
    <%
        Professor professor = (Professor) session.getAttribute("professor");
        Monitor monitor = (Monitor) session.getAttribute("monitor");
        if (professor == null && monitor == null) {
            response.sendRedirect("acessoRestrito.jsp");
        } else {
    %> 
    <div>
        <div class="container">
            <jsp:include page="../include/menuTopProf.jsp" />
        </div>
        <div class="col-md-2" style="margin-top: 55px">
            <jsp:include page="../include/menuProfessor.jsp" />
        </div>
        <form id="formulario" action="SvCadastro" method="post">
            <div class="col-md-10" style="margin-top: 55px">
                <% String mensagem = (String) request.getAttribute("mensagem");
                    if (mensagem != null) {%>
                <div class="alert alert-success alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${mensagem}</strong>
                </div>
                <%  }%>
                <h2 class="col-md-offset-4"> Respostas </h2>
                <div class="table-responsive">
                    <table id="minhaTabela" class="display table table-striped">
                        <thead>
                            <tr>
                                <th>Alunos</th>
                                <th>Tarefa</th>
                                <th>Status</th>
                                <th>Opção</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Questao questao = (Questao) request.getAttribute("questao");
                                DaoResposta daoResposta = new DaoResposta();
                                List<Resposta> respostas = daoResposta.listaTodos();
                                for (Resposta r : respostas) {
                                    if (r.getQuestao().getId() == questao.getId()) {
                            %>
                            <tr>
                                <td><%= r.getAluno().getNome()%></td>
                                <td><%= r.getQuestao().getTitulo()%></td>
                                <td><%= r.getStatus()%></td>
                                <td>
                                    <% if (r.getStatus().equals("em avaliação")) {%>
                                    <a href="AvaliarQuestao?id_questao=<%= r.getQuestao().getId()%>&id_aluno=<%= r.getAluno().getId()%>" title="Avaliar" style="margin:2px;"> <span class="glyphicon glyphicon-check"> </span> </a>
                                    <% } else {%>
                                    corrigido
                                    <% }%>
                                </td>
                            </tr>
                            <%    }
                                }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
    </div>
    <% }%>
</body>
</html>