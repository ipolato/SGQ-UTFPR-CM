<%-- 
    Document   : cadastroTarefa
    Created on : 28/09/2016, 20:33:25
    Author     : popovicz
--%>
<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page import="br.com.utfpr.beans.Questao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.utfpr.model.DaoDisciplina"%>
<%@page import="br.com.utfpr.beans.Disciplina"%>
<jsp:useBean id="listarDisciplina" class="br.com.utfpr.controle.ListarDisciplina" scope="application" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Cadastro de Tarefa</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body>

        <div>
            <div class="container">
                <jsp:include page="../include/menuTopProf.jsp" />
            </div>
            <%
                DaoDisciplina daoDisciplina = new DaoDisciplina();
                List<Disciplina> disciplinas = daoDisciplina.listaTodos();
                Professor professor = (Professor) session.getAttribute("professor");
                Monitor monitor = (Monitor) session.getAttribute("monitor");
                if (professor == null && monitor == null) {
                    response.sendRedirect("acessoRestrito.jsp");
                } else {
            %> 
            <div class="col-md-2" style="margin-top: 55px;">
                <jsp:include page="../include/menuProfessor.jsp" />
            </div>
            <form id="formulario1" action="SvCadastroTarefa" method="post">
                <div class="col-md-10" style="margin-top: 55px">
                    <h2 class="col-md-offset-4"> Cadastro de Exercício </h2>
                    <div class="form-group">
                        <label for="disciplina">Disciplina</label>
                        <select class="form-control" name="cbDisciplina" id="cbDisciplina" >
                            <% for (Disciplina d : disciplinas) {%> 
                            <option  value="<%= d.getId()%>" > <%= d.getNome()%></option>                     
                            <% }%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="encerramento">Data de encerramento</label>
                        <input type="date" style="height: 30px" id="encerramento" name="encerramento">
                    </div>
                    <div class="form-group">
                        <label for="nome" >Título</label>
                        <input type="text" class="form-control" id="titulo" name="titulo"  placeholder="titulo do exercício">
                    </div>
                    <div class="form-group">
                        <label for="tarefa">Exercício</label>
                        <textarea  class="form-control" name="tarefa" id="tarefa" placeholder="exercício por extenso "  onscroll="true" rows="5"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="sexo">Deixar o exercício aberto </label>
                        <label class="radio-inline"><input type="radio" name="aberta" checked="true" value="S" >Sim</label>
                        <label class="radio-inline"><input type="radio" name="aberta" value="N" >Não</label>
                    </div>
                    <button type="submit" class="btn btn-primary col-md-offset-10">Salvar</button>
                    <a href="tarefa.jsp" class="btn btn-default ">Cancelar</a>
                </div>
            </form>
        </div>

        <jsp:include page="../include/footDentro.jsp" />
        <% }%>
    </body>
</html>
