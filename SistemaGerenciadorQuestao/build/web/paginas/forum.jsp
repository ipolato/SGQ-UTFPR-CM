<%-- 
    Document   : forum
    Created on : 28/09/2016, 20:22:27
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.utfpr.beans.Comentario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.utfpr.model.DaoComentario"%>
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
        <title>SGQ - Forum</title>
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
                DaoQuestao daoQuestao = new DaoQuestao();
                List<Questao> questaos = daoQuestao.listaTodos();
                DaoComentario daoComentario = new DaoComentario();
                List<Comentario> comentarios = daoComentario.listaTodos();
        %> 
        <div class="col-md-2" style="margin-top: 55px">
            <jsp:include page="../include/menuProfessor.jsp" />
        </div>
        <form id="formulario" action="SvCadastro" method="post">
            <div class="col-md-10" style="margin-top: 55px">
                <h2 class="col-md-offset-5"> Fórum </h2>

                <div class="table-responsive">
                    <table id="minhaTabela" class="display table table-striped">
                        <thead>
                            <tr>
                                <th>Tarefa</th>
                                <th>Disciplina</th>
                                <th>qtd. de comentário</th>
                                <th>Status da questão</th>
                                <th>Opção</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Date date = new Date();
                                SimpleDateFormat dtFormData = new SimpleDateFormat("dd/MM/yyyy");
                                for (Questao q : questaos) {
                                    Date datea = dtFormData.parse(q.getDataCadastroFormatado());
                                    int i = 0;
                                    for (Comentario c : comentarios) {
                                        if (c.getQuestao().getId() == q.getId()) {
                                            i += 1;
                                        }
                                    }
                            %>
                            <tr>
                                <td><%= q.getTitulo()%></td>
                                <td><%= q.getDisciplina().getNome()%></td>
                                <td><%= i%></td>
                                <td><%= q.isAberta() == true && date.before(datea) ? "Em andamento" : "Encerrada"%></td>
                                <td>
                                    <a href="SvComentarforum?id=<%= q.getId()%>" title="comentar" style="margin:2px;"> <span class="glyphicon glyphicon-comment"> </span> </a>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>

                </div>
            </div>
        </form>
    </div>
    <% }%>
</body>
</html>
