<%-- 
    Document   : corrigindoTarefa
    Created on : 24/11/2016, 23:47:34
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Aluno"%>
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
        <title>SGQ - Corrigindo Tarefa</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body>
        <div>   
            <div class="container">
                <jsp:include page="../include/menuTop.jsp" />
            </div>
            <%
                Professor professor = (Professor) session.getAttribute("professor");
                Monitor monitor = (Monitor) session.getAttribute("monitor");
                if (professor == null && monitor == null) {
                    response.sendRedirect("acessoRestrito.jsp");
                } else {
                    Questao questao = (Questao) request.getAttribute("questao");
                    Aluno aluno = (Aluno) request.getAttribute("aluno");
                    DaoResposta respostado = new DaoResposta();
                    Resposta resposta = new Resposta();
                    resposta = respostado.busbuscandoPorQuestaocarPorId(aluno.getId(), questao.getId());
            %> 
            <div class="col-md-2" style="margin-top: 55px">
                <jsp:include page="../include/menuProfessor.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px">
                <h2 class="col-md-offset-5"> Avaliar Tarefa </h2>
                <form id="formulario" action="AvaliarQuestao" method="post">
                    <input hidden="true" type="text" id="id_questao" name="id_questao" value="<%= questao.getId()%>">
                    <input hidden="true" type="text" id="id_resposta" name="id_resposta" value="<%= resposta.getId()%>">                   
                    <input hidden="true" type="text" id="id_aluno" name="id_aluno" value="<%= aluno.getId()%>">                   
                    <div class="form-group col-md-2">
                        <label for="professor">Tarefa: <%= questao.getTitulo()%></label>
                        <label for="disciplina">Disciplina: <%= questao.getDisciplina().getNome()%></label>
                    </div>
                    <div class="form-group col-md-10">
                        <!--<textarea  class="form-control" id="tarefa" onscroll="true" rows="7" disabled="true"></textarea>-->
                        <%= questao.getConteudo()%>
                    </div>
                    <div class="form-group col-md-2">
                        <% DaoImagem daoImagem = new DaoImagem();
                            Imagem imagem = new Imagem();

                            imagem = daoImagem.buscarPorId(aluno.getImagem().getIdImagem());
                            if (imagem.getNomeArquivo().equals(" ")) {
                        %> 
                        <img src="../img/user.png" style="width: 80px; height: 80px;" class="img-rounded">
                        <% } else {%>
                        <img src="../upload/<%= aluno.getId()%><%= imagem.getNomeArquivo()%>" style="width: 80px; height: 80px;" class="img-rounded">
                        <% }%>
                        <label for="alu">Aluno: <%= aluno.getNome()%></label>

                    </div>
                    <div class="form-group col-md-10">
                        <textarea  class="form-control" id="resposta" onscroll="true" rows="3" disabled="true"> <%= resposta.getConteudo()%> </textarea>
                    </div>
                    <div class="form-group col-md-10">
                        <label for="statusDaQuestao">Avaliar resposta:</label>
                        <select name="nota" id="nota" >
                            <option value="excelente" > excelente</option>   
                            <option value="boa" > boa</option>   
                            <option value="mediana" > mediana</option>   
                            <option value="ruim" > ruim</option>   
                        </select>
                        <button type="submit" class="btn btn-primary col-md-offset-9">Salvar</button>
                        <a href="CorrigirQuestao?id=<%= questao.getId()%>" class="btn btn-default ">Cancelar</a>
                    </div> 
                </form>
            </div>
        </div>
        <jsp:include page="../include/footDentro.jsp" />
        <% }%>
    </body>
</html>
