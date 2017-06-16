<%-- 
    Document   : tarefa
    Created on : 28/09/2016, 20:20:55
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.utfpr.beans.Questao"%>
<%@page import="br.com.utfpr.model.DaoQuestao"%>
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
        <title>SGQ - Tarefa</title>

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
        <div class="col-md-2" style="margin-top: 55px">
            <jsp:include page="../include/menuProfessor.jsp" />
        </div>
        <form id="formulario" action="SvCadastro" method="post">
            <div class="col-md-10" style="margin-top: 55px">
                <%
                    String mensagem = (String) request.getAttribute("mensagem");
                    if (mensagem != null) {%>
                <div class="alert alert-success alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${mensagem}</strong>
                </div>
                <% }%>
                <h2 class="col-md-offset-5"> Tarefas </h2>
                <a href="cadastroTarefa.jsp" title="alterar" class="btn btn-primary col-md-12" style="margin:2px;"> <span class="glyphicon glyphicon-plus"> Cadastrar Tarefa</span> </a>

                <div class="table-responsive">
                    <table id="minhaTabela" class="display table table-striped">
                        <thead>
                            <tr>
                                <th>Professor</th>
                                <th>Tarefa</th>
                                <th>Encerramento</th>
                                <th>Disciplina</th>
                                <th>Opção</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                DaoQuestao daoQuestao = new DaoQuestao();
                                List<Questao> questaos = daoQuestao.listaTodos();
                                for (Questao q : questaos) {
                            %>
                            <tr>
                                <td><%= q.getDisciplina().getProfessor().getNome()%></td>
                                <td><%= q.getTitulo()%></td>
                                <td><%= q.getDataCadastroFormatado()%></td>
                                <td><%= q.getDisciplina().getNome()%></td>
                                <td>
                                    <a href="AtualizarQuestao?id=<%= q.getId()%>" title="alterar" style="margin:2px;"> <span class="glyphicon glyphicon-pencil"> </span> </a>
                                    <a onclick="confirmacao('<%=  q.getId()%>', 'ExcluirQuestao?id=')" title="Excluir" style="margin:2px;"> <span class="glyphicon glyphicon-trash"> </span> </a>
                                    <a href="CorrigirQuestao?id=<%= q.getId()%>" title="Resposta dos alunos" style="margin:2px;"> <span class="glyphicon glyphicon-user"></span> </a>
                                    <a href="SvAbrirEFecharQuestao?id=<%= q.getId()%>" title="<%= q.isAberta() == true ? "Questão aberta" : "Questão fechada"%>" style="margin:2px;"> <span class="<%= q.isAberta() == true ? "glyphicon glyphicon-eye-open" : "glyphicon glyphicon-eye-close"%>"></span> </a>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
        <br><br>
    </div>

    <% }%>
</body>
</html>
