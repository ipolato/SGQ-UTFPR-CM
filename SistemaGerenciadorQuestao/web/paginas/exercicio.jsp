<%-- 
    Document   : exercicio
    Created on : 01/11/2016, 17:46:45
    Author     : popovicz
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.utfpr.beans.Resposta"%>
<%@page import="br.com.utfpr.model.DaoResposta"%>
<%@page import="br.com.utfpr.beans.Questao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.utfpr.model.DaoQuestao"%>
<%@page import="br.com.utfpr.beans.Aluno"%>
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
            <jsp:include page="../include/menuTop.jsp" />
        </div>
        <%
            Aluno aluno = (Aluno) session.getAttribute("aluno");
            if (aluno == null) {
                response.sendRedirect("acessoRestrito.jsp");
            } else {
                DaoQuestao daoQuestao = new DaoQuestao();
                DaoResposta daoResposta = new DaoResposta();
                List<Questao> questaos = new ArrayList<Questao>();
                questaos = daoQuestao.listaTodos();
                String mensagem = (String) request.getAttribute("mensagem");
                List<Resposta> respostas = daoResposta.listaTodos();
                List<Questao> quests = new ArrayList<Questao>();
                quests.addAll(questaos);

                for (Resposta res : respostas) {
                    for (Questao que : questaos) {
                        if ((res.getQuestao().getId() == que.getId() && res.getAluno().getId() == aluno.getId()) || que.getDisciplina().getId() != aluno.getDisciplina().getId()) {
                            quests.remove(que);
                        }
                    }
                }
        %>   
        <div class="col-md-2 col-xs-12" style="margin-top: 55px;"> 
            <jsp:include page="../include/menuAluno.jsp" />
        </div>

        <div class="col-md-10" style="margin-top: 55px">
            <%  if (mensagem != null) {%>
            <div class="alert alert-success alert-dismissible" role="alert" >
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>${mensagem}</strong>
            </div>
            <%  }%>
            <h2 class="col-md-offset-5"> Tarefa </h2>
            <div class="table-responsive">
                <table id="minhaTabela" class="display table table-striped">
                    <thead>
                        <tr>
                            <th>Professor</th>
                            <th>Tarefa</th>
                            <th>Disciplina</th>
                            <th>Encerramento</th>
                            <th>Opção</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Date date = new Date();
                            SimpleDateFormat dtFormData = new SimpleDateFormat("dd/MM/yyyy");

                            for (Questao q : quests) {
                                Date datea = dtFormData.parse(q.getDataCadastroFormatado());
                                if (q.isAberta() == true && date.before(datea)) {
                        %>
                        <tr>
                            <td><%= q.getDisciplina().getProfessor().getNome()%></td>
                            <td><%= q.getTitulo()%></td>
                            <td><%= q.getDisciplina().getNome()%></td>
                            <td><%= q.getDataCadastroFormatado()%> às 00:00</td>
                            <td>
                                <a href="SvFazerTarefa?id=<%= q.getId()%>" title="responder à tarefa" style="margin:2px;"> <span class="glyphicon glyphicon-edit"> </span> </a>
                            </td>
                        </tr>
                        <%}
                            }%>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
    <% }%>
</body>
</html>
