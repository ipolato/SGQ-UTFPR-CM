<%-- 
    Document   : fazerComentario_a
    Created on : 07/11/2016, 19:52:12
    Author     : popovicz
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.utfpr.beans.Curtir"%>
<%@page import="br.com.utfpr.model.DaoCurtir"%>
<%@page import="br.com.utfpr.beans.Comentario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.utfpr.model.DaoComentario"%>
<%@page import="br.com.utfpr.beans.Resposta"%>
<%@page import="br.com.utfpr.model.DaoResposta"%>
<%@page import="br.com.utfpr.beans.Questao"%>
<%@page import="br.com.utfpr.beans.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGQ - Comentário do Fórum</title>
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
                    Questao questao = (Questao) request.getAttribute("questao");
                    String mensagem = (String) request.getAttribute("mensagem");
                    DaoCurtir daoCurtir = new DaoCurtir();
                    Curtir curtir = new Curtir();
                    DaoResposta respostado = new DaoResposta();
                    Resposta resposta = new Resposta();
                    resposta = respostado.busbuscandoPorQuestaocarPorId(aluno.getId(), questao.getId());
                    DaoComentario daoComentario = new DaoComentario();
                    List<Comentario> comentarios = daoComentario.listaTodos();
            %>
            <div class="col-md-2 col-xs-12" style="margin-top: 55px;"> 
                <jsp:include page="../include/menuAluno.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px">
                <% if (mensagem != null) {%>
                <div class="alert alert-success alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${mensagem}</strong>
                </div>
                <% }%>
                <h2 class="col-md-offset-4 center"> Fórum - <%= questao.getTitulo()%> </h2>
                <form id="formulario1" action="SvComentarforum_a" method="post">
                    <input hidden="true" type="text" id="id_alu" name="id_alu" value="<%= aluno.getId() %>">
                    <input hidden="true" type="text" id="id_aluno" name="id_aluno" value="<%= aluno.getId() %>">
                    <input hidden="true" type="text" id="id_questao" name="id_questao" value="<%= questao.getId()%>">
                    <div class="form-group col-md-2">
                        <% if(questao.getDisciplina().getProfessor().getImagem().getNomeArquivo().equals(" ")) { %> 
                         <img src="../img/user.png" style="width: 120px; height: 120px;" class="img-rounded">
                         <% }else{ %>
                         <img src="../upload/<%= questao.getDisciplina().getProfessor().getId()%><%= questao.getDisciplina().getProfessor().getImagem().getNomeArquivo()%>" style="width: 120px; height: 120px;" class="img-rounded">
                        <% } %>
                        <label for="professor">Professor: <%= questao.getDisciplina().getProfessor().getNome()%></label>
                        <label for="disciplina">Disciplina: <%= questao.getDisciplina().getNome()%></label>
                    </div>
                    <div class="form-group col-md-10">
                        <%= questao.getConteudo()%>
                    </div>
                    <div class="form-group col-md-12">
                        <% if (resposta != null) {%>
                        <label for="statusDaQuestao">Avaliação da sua resposta: <%= resposta.getStatus()%></label>
                        <textarea  class="form-control" id="resposta" onscroll="true" rows="3" disabled="true"> <%= resposta.getConteudo()%> </textarea>
                        <% } else {%>
                        <label for="statusDaQuestao">Você não fez essa tarefa ainda!</label>
                        <% }%>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="coments">Comentários</label>
                    </div>
                    <%
                        for (Comentario c : comentarios) {
                            if (c.getQuestao().getId() == questao.getId()) {
                    %>
                    <div class="form-group col-md-2">
                        <% if (c.getAluno() != null) {%>
                        <% if(c.getAluno().getImagem().getNomeArquivo().equals(" ")) { %> 
                         <img src="../img/user.png" style="width: 80px; height: 80px;" class="img-rounded">
                         <% }else{ %>
                         <img src="ExibirImagemServlet?imagem_id=<%= c.getAluno().getImagem().getImagem()%>" style="width: 1px; height: 1px;" hidden="true">
                        <img src="../upload/<%= c.getAluno().getId()%><%= c.getAluno().getImagem().getNomeArquivo()%>" style="width: 80px; height: 80px;" class="img-rounded">
                        <% } %>
                        <label for="alu"><a href="SvVerPerfil?id_perfil=<%= c.getAluno().getId()%>">Aluno: <%= c.getAluno().getNome()%></a></label>
                        <% }%>
                        <% if (c.getMonitor() != null) {%>
                        <% if(c.getMonitor().getImagem().getNomeArquivo().equals(" ")) {%> 
                         <img src="../img/user.png" style="width: 80px; height: 80px;" class="img-rounded">
                         <% }else{ %>
                         <img src="ExibirImagemServlet?imagem_id=<%= c.getMonitor().getImagem().getImagem()%>" style="width: 1px; height: 1px;" hidden="true">
                        <img src="../upload/<%= c.getMonitor().getId()%><%= c.getMonitor().getImagem().getNomeArquivo()%>" style="width: 80px; height: 80px;" class="img-rounded">
                        <% } %>
                        <label for="alu"><a href="SvVerPerfil?id_perfil=<%= c.getMonitor().getId()%>">Monitor: <%= c.getMonitor().getNome()%></a></label>
                        <% }%>
                        <% if (c.getProfessor() != null) {%>
                        <% if(c.getProfessor().getImagem().getNomeArquivo().equals(" ")) { %> 
                         <img src="../img/user.png" style="width: 80px; height: 80px;" class="img-rounded">
                         <% }else{ %>
                         <img src="ExibirImagemServlet?imagem_id=<%= c.getProfessor().getImagem().getImagem()%>" style="width: 1px; height: 1px;" hidden="true">
                        <img src="../upload/<%= c.getProfessor().getId()%><%= c.getProfessor().getImagem().getNomeArquivo()%>" style="width: 80px; height: 80px;" class="img-rounded">
                        <% } %>
                        <label for="alu"><a href="SvVerPerfil?id_perfil=<%= c.getProfessor().getId()%>">Professor: <%= c.getProfessor().getNome()%></a></label>
                        <% }%>
                    </div>
                    <div class="form-group col-md-10">
                        <textarea class="form-control" style="margin-bottom: 5px;" onscroll="true" rows="5" disabled="true"> <%= c.getConteudo()%> </textarea>

                        <a href="SvCurtirComentario_a?id_comentario=<%= c.getId()%>&id_aluno=<%= aluno.getId()%>&id_questao=<%= questao.getId()%>" title="Curtir comentário" style="margin:2px;">
                            <span class="glyphicon glyphicon-thumbs-up"> </span>
                        </a>

                        <a href="#" title="pessoas que curtiu" style="margin:5px;">
                            <%
                                List<Curtir> curtidas = new ArrayList<Curtir>();
                                List<Curtir> curtis = new ArrayList<Curtir>();
                                curtidas = daoCurtir.listaTodos();
                                boolean b = false;
                                for (Curtir cur : curtidas) {
                                    if (cur.getComentario().getId() == c.getId()) {
                                        curtis.add(cur);
                                        if (cur.getAluno() != null) {
                                            if (cur.getAluno().getId() == aluno.getId()) {
                                                out.print("Você ");
                                                b = true;
                                            }
                                        }
                                    }
                                }
                                if (curtis.size() > 0) {
                                    if (curtis.size() == 1 && b == true) {
                                        out.print(" curtiu");
                                    }
                                    if (curtis.size() == 2 && b == true) {
                                        out.print(" e 1 pessoa curtiu");
                                    }
                                    if (curtis.size() > 2 && b == true) {
                                        out.print("e " + curtis.size() + " pessoas curtiu");
                                    }
                                    if (curtis.size() == 1 && b == false) {
                                        out.print("1 pessoa curtiu");
                                    }
                                    if (curtis.size() > 2 && b == false) {
                                        out.print(curtis.size() + " pessoas curtiu");
                                    }
                                }%>
                        </a>

                        <%
                            if (c.getAluno() != null) {
                                if (c.getAluno().getId() == aluno.getId()) {
                        %>
                        <a onclick="confirmacao('<%= c.getId()%>', 'SvExcluirComentario_a?id=')" title="excluir comentário" style="margin:10px; text-align: right;"> <span class="glyphicon glyphicon-trash"> </span> </a>
                        <% }
                            }%>

                    </div>
                    <%     }
                        }
                    %>

                    <div class="form-group col-md-12">
                        <textarea class="form-control" id="comentando" name="comentando" placeholder="Tire uma dúvida ou ajude um amigo ..." onscroll="true" rows="5"></textarea>
                    </div>
                    <div style="margin-bottom: 15px;">
                        <button type="submit" class="btn btn-primary col-md-offset-10 col-sm-offset-8">Comentar</button>
                        <a href="forum_a.jsp" class="btn btn-default ">Cancelar</a>
                    </div>
                </form>
            </div>

        </div>
        <jsp:include page="../include/footDentro.jsp" />
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Todas pessoas que curtiu</h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        <% }%>
    </body>
</html>
