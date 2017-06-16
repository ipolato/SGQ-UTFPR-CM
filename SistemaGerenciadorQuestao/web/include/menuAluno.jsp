<%@page import="br.com.utfpr.model.DaoAluno"%>
<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page import="br.com.utfpr.beans.Aluno"%>
<div class="col-md-12 sidebar" >
    <%
        Aluno aluno = (Aluno) session.getAttribute("aluno");
        DaoImagem daoImagem = new DaoImagem();
        Imagem imagem = new Imagem();

        imagem = daoImagem.buscarPorId(aluno.getImagem().getIdImagem());
        if(imagem.getNomeArquivo().equals(" ")) {
    %> 
    <img src="../img/user.png" style="width: 120px; height: 120px;" class="img-rounded">
     <% }else{ %>
     <img src="../upload/<%= aluno.getId()%><%= imagem.getNomeArquivo()%>" style="width: 120px; height: 120px;" class="img-rounded">
    <% } %>
    <p>Nome: <% out.print(aluno.getNome());%></p>
    <% if (aluno.getGame().equals("S")) {
            DaoAluno daoAluno = new DaoAluno();
            Aluno alu = new Aluno();
            alu = daoAluno.buscarPorId(aluno.getId());
            int experiencia = 0;
            if (alu.getUmaEst() > 50) {
                experiencia += 500;%> 
    <img src="../medals/UmaEstPra.png" alt="Uma Estrela de Prata" title="Estrela de Prata">
    <% }
            if (alu.getUmaEst() > 20) {
                experiencia += 1000;%>  
    <img src="../medals/UmaEstOur.png" alt="Uma Estrela de Ouro" title="Uma Estrela de Ouro">
    <% }
            if (alu.getDuaEst() > 10) {
                experiencia += 500;%> 
    <img src="../medals/DuasEstPra.png" alt="Duas Estrela de Prata" title="Duas Estrela de Prata">
    <% }
            if (alu.getDuaEst() > 20) {
                experiencia += 1000;%>  
    <img src="../medals/DuasEstOur.png" alt="Duas Estrela de Ouro" title="Duas Estrela de Ouro">
    <% }
            if (alu.getTreEst() > 10) {
                experiencia += 500;%> 
    <img src="../medals/TreEstPra.png" alt="Três Estrela de Prata" title="Três Estrela de Prata">
    <% }
            if (alu.getTreEst() > 20) {
                experiencia += 1000;%>   
    <img src="../medals/TreEstOur.png" alt="Três Estrela de Ouro" title="Três Estrela de Ouro">
    <% }
            if (alu.getMedal() > 25) {
                experiencia += 500;%>  
    <img src="../medals/MedPra.png" alt="Uma Medalha de Prata" title="Medalha de Prata">
    <% }
            if (alu.getMedal() > 50) {
                experiencia += 1000;%>  
    <img src="../medals/MedOur.png" alt="Uma Medalha de Ouro" title="Medalha de Ouro">
    <% }
            if (alu.getMedCom() > 25) {
                experiencia += 500;%>  
    <img src="../medals/MedPraCom.png" alt="Uma Medalha de Comentário de Prata" title="Medalha de Comentário de Prata">
    <% }
            if (alu.getMedCom() > 50) {
                experiencia += 1000;%>   
    <img src="../medals/MedOurCom.png" alt="Uma Medalha de Comentário de Ouro" title="Medalha de Comentário de Ouro">
    <% }
            if (alu.getMedLiv() > 20) {
                experiencia += 500;%>  
    <img src="../medals/LivPra.png" alt="Uma Medalha de Livro de Prata" title="Medalha de Livro de Prata">
    <% }
            if (alu.getMedLiv() > 10) {
                experiencia += 1000;%>   
    <img src="../medals/LivOur.png" alt="Uma Medalha de Livro de Ouro" title="Medalha de Livro de Ouro">
    <% }
        int level = 0;

        int expTotal = 50;
        boolean w = true;
        experiencia += alu.getPontosDeExperiencia();
        while (w) {
            if (experiencia > expTotal) {
                level += 1;
                experiencia -= expTotal;
                expTotal *= 2;
            } else {
                w = false;
            }
        }
        double exp = experiencia;
        double expT = expTotal;
        double rEmAvali = Math.round(((exp * expT) / (expT * expT)) * 100);
    %>
    <div style="margin-top: 5px;">
        <p>Level:<%= level%></p>
    </div>
    <div class="progress">
        <div id="ava" class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="<%= rEmAvali%>" aria-valuemin="0" aria-valuemax="100" style="width: <% out.print(rEmAvali + "%");%>">
            <%= rEmAvali%>%
        </div>
    </div>

    <ul class="nav nav-sidebar">
        <li class="active"><a href="inicial_a.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"/> Home</a></li>
        <li class="active"><a href="exercicio.jsp"><span class="glyphicon glyphicon-book" aria-hidden="true"/> Tarefas</a></li>
        <li class="active"><a href="forum_a.jsp"><span class="glyphicon glyphicon-globe" aria-hidden="true"/> Fórum</a></li>
        <li class="active"><a href="medalhas_a.jsp"><span class="glyphicon glyphicon-star-empty" aria-hidden="true"/> Medalha</a></li>
        <li class="active"><a href="ranking_a.jsp"><span class="glyphicon glyphicon-flag" aria-hidden="true"/> Ranking</a></li>
    </ul>
    <% } else {%>
    <ul class="nav nav-sidebar">
        <li class="active"><a href="inicial_a.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"/> Home</a></li>
        <li class="active"><a href="exercicio.jsp"><span class="glyphicon glyphicon-book" aria-hidden="true"/> Tarefas</a></li>
        <li class="active"><a href="forum_a.jsp"><span class="glyphicon glyphicon-globe" aria-hidden="true"/> Fórum</a></li>
    </ul>
    <% }%>
</div>
