<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<div class="col-md-12 sidebar" >
    <%
        Professor professor = (Professor) session.getAttribute("professor");
        Monitor monitor = (Monitor) session.getAttribute("monitor");
        DaoImagem daoImagem = new DaoImagem();
        Imagem imagem = new Imagem();
        String nome;
    %>  
    <% if (professor != null) {
            imagem = daoImagem.buscarPorId(professor.getImagem().getIdImagem());
            nome = professor.getNome();
        if(imagem.getNomeArquivo().equals(" ")) {
       %> 
       <img src="../img/user.png" style="width: 120px; height: 120px;" class="img-rounded">
        <% }else{ %>
        <img src="../upload/<%= professor.getId()%><%= imagem.getNomeArquivo()%>" style="width: 120px; height: 120px;" class="img-rounded">
       <% } %>
    <%} else {
        imagem = daoImagem.buscarPorId(monitor.getImagem().getIdImagem());
        nome = monitor.getNome();
        if(imagem.getNomeArquivo().equals(" ")) {
       %> 
       <img src="../img/user.png" style="width: 120px; height: 120px;" class="img-rounded">
        <% }else{ %>
        <img src="../upload/<%= monitor.getId()%><%= imagem.getNomeArquivo()%>" style="width: 120px; height: 120px;" class="img-rounded">
       <% } %>
    <% }%>
    <p>Nome: <% out.print(nome);%></p>
    <ul class="nav nav-sidebar">
        <li class="active"><a href="inicial.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"/> Home</a></li>
        <li class="active"><a href="tarefa.jsp"><span class="glyphicon glyphicon-book" aria-hidden="true"/> Exercício</a></li>
        <li class="active"><a href="forum.jsp"><span class="glyphicon glyphicon-globe" aria-hidden="true"/> Fórum</a></li>
        <li class="active"><a href="medalhas.jsp"><span class="glyphicon glyphicon-star-empty" aria-hidden="true"/> Medalha</a></li>
        <li class="active"><a href="ranking.jsp"><span class="glyphicon glyphicon-flag" aria-hidden="true"/> Ranking</a></li>
    </ul>
</div>