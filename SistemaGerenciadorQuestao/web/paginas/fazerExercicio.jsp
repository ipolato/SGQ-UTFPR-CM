<%-- 
    Document   : fazerExercicio
    Created on : 01/11/2016, 18:01:49
    Author     : popovicz
--%>
<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page import="br.com.utfpr.beans.Questao"%>
<%@page import="br.com.utfpr.beans.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Fazendo à tarefa</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body> 
        <div>
            <div class="container">
                <jsp:include page="../include/menuTop.jsp" />
            </div>
            <%
                DaoImagem daoImagem = new DaoImagem();
                Imagem imagem = new Imagem();
                Aluno aluno = (Aluno) session.getAttribute("aluno");
                
                if (aluno == null) {
                    response.sendRedirect("acessoRestrito.jsp");
                } else {
                    Questao questao = (Questao) request.getAttribute("questao");
                    imagem = daoImagem.buscarPorId(questao.getDisciplina().getProfessor().getImagem().getIdImagem());
            %>   
            <div class="col-md-2 col-xs-12" style="margin-top: 55px;"> 
                <jsp:include page="../include/menuAluno.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px">
                <h2 class="col-md-offset-5"> Tarefa </h2>
                <form id="formulario1" action="SvFazerTarefa" method="post">
                    <input hidden="true" type="text" id="id_questao" name="id_questao" value="<%= questao.getId()%>">
                    <input hidden="true" type="text" id="id_aluno" name="id_aluno" value="<%= aluno.getId()%>">
                    <div class="form-group col-md-2">
                        <%if (imagem.getNomeArquivo().equals(" ")) {
                        %> 
                        <img src="../img/user.png" style="width: 120px; height: 120px;" class="img-rounded">
                        <% } else {%>
                        <img src="../upload/<%= questao.getDisciplina().getProfessor().getId()%><%= imagem.getNomeArquivo()%>" style="width: 120px; height: 120px;" class="img-rounded">
                        <% }%>
                        <label for="professor"><%= questao.getDisciplina().getProfessor().getNome()%></label>
                        <label for="disciplina"><%= questao.getDisciplina().getNome()%></label>
                    </div>
                    <div class="form-group col-md-10">
                        <label for="titulo" ><%= questao.getTitulo()%></label>
                        <%= questao.getConteudo()%>
                        <!--<textarea  class="form-control" id="tarefa" onscroll="true" rows="3" disabled="true">  </textarea>-->
                    </div>
                    <div class="form-group col-md-12">
                        <label for="resposta">Resposta</label>
                        <textarea class="form-control" id="resposta" name="resposta" placeholder="resposta do exercício por extenso " onscroll="true" rows="7"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary col-md-offset-10">Salvar</button>
                    <a href="exercicio.jsp" class="btn btn-default ">Cancelar</a>
                </form>
            </div>

        </div>
        <jsp:include page="../include/footDentro.jsp" />
        <% }%>
    </body>
</html>
