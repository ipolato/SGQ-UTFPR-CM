<%-- 
    Document   : perfil
    Created on : 18/02/2017, 17:54:10
    Author     : popovicz
--%>

<%@page import="br.com.utfpr.beans.Imagem"%>
<%@page import="br.com.utfpr.model.DaoImagem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.utfpr.beans.Resposta"%>
<%@page import="java.util.List"%>
<%@page import="br.com.utfpr.model.DaoResposta"%>
<%@page import="br.com.utfpr.beans.Aluno"%>
<%@page import="br.com.utfpr.beans.Monitor"%>
<%@page import="br.com.utfpr.beans.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Perfil</title>
        <jsp:include page="../include/headDentro.jsp" />
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

                    Aluno perfil = (Aluno) request.getAttribute("perfil");
                    DaoResposta resposta = new DaoResposta();
                    List<Resposta> respostas = new ArrayList<Resposta>();
                    double resFeita = 0;
                    double resNaoFeita = 0;
                    double resTotal = 0;
                    double resExelente = 0;
                    double rExelente = 0;
                    double resBoa = 0;
                    double rBoa = 0;
                    double resMediana = 0;
                    double rMediana = 0;
                    double resRuim = 0;
                    double rRuim = 0;
                    double resEmAvali = 0;
                    double rEmAvali;
                    int qtotal = 0;
                    respostas.addAll(resposta.listaTodos());
                    for (Resposta r : respostas) {
                        if (r.getAluno().getId() == perfil.getId()) {
                            if (r.getStatus().equals("em avaliação")) {
                                resEmAvali += 1;
                                resFeita += 1;
                            }
                            if (r.getStatus().equals("excelente")) {
                                resExelente += 1;
                                resFeita += 1;
                            }
                            if (r.getStatus().equals("mediana")) {
                                resMediana += 1;
                                resFeita += 1;
                            }
                            if (r.getStatus().equals("boa")) {
                                resBoa += 1;
                                resFeita += 1;
                            }
                            if (r.getStatus().equals("ruim")) {
                                resRuim += 1;
                                resFeita += 1;
                            }
                            resTotal += 1;
                        }
                        qtotal +=1;
                    }
                    resNaoFeita = resTotal - resFeita;
                    rExelente = Math.round(((resExelente * resTotal) / (resTotal * resTotal)) * 100);
                    rBoa = Math.round(((resBoa * resTotal) / (resTotal * resTotal)) * 100);
                    rMediana = Math.round(((resMediana * resTotal) / (resTotal * resTotal)) * 100);
                    rRuim = Math.round(((resRuim * resTotal) / (resTotal * resTotal)) * 100);
                    rEmAvali = Math.round(((resEmAvali * resTotal) / (resTotal * resTotal)) * 100);
                    DaoImagem daoImagem = new DaoImagem();
                    Imagem imagem = new Imagem();

                    imagem = daoImagem.buscarPorId(perfil.getImagem().getIdImagem());
            %>
            <div class="col-md-2 col-xs-12" style="margin-top: 55px;"> 
                <jsp:include page="../include/menuProfessor.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px">
                <h2 class="col-md-offset-5"> Perfil </h2>
                <div class="col-md-5 col-sm-12">
                    <%if(imagem.getNomeArquivo().equals(" ")) {%> 
                    <img src="../img/user.png" style="width: 300px; height: 300px;" class="img-rounded">
                     <% }else{ %>
                     <img src="../upload/<%= perfil.getId()%><%= imagem.getNomeArquivo()%>" style="width: 300px; height: 300px;" class="img-rounded">
                    <% } %>
                    <br><br>
                </div>
                <div>
                    <p>Nome: <% out.print(perfil.getNome());%></p>
                    <p>E-mail: <% out.print(perfil.getEmail());%></p>
                    <p>Cursando Disciplina: <% out.print(perfil.getDisciplina().getNome());%></p>
                    <p>Total de questão: <% out.print(qtotal);%></p>
                    <p>Total de questão feita: <% out.print(resFeita);%></p>
                    <p>Total de questão não feita: <% out.print(resNaoFeita);%></p>
                    <p>Total de resposta excelente: <% out.print(resExelente);%></p>
                    <p>Total de resposta boa: <% out.print(resBoa);%></p>
                    <p>Total de resposta mediana: <% out.print(resMediana);%></p>
                    <p>Total de resposta ruim: <% out.print(resRuim);%></p>
                    <p>Total de resposta em avaliação: <% out.print(resEmAvali);%></p>
                </div>
                <div class="col-md-12" style="margin-bottom: 30px;">
                    <h3>Porcentagem com as notas das respostas feitas</h3>
                    <p>Resposta em availação:</p>
                    <div class="progress">
                        <div id="ava" class="progress-bar progress-bar-success active" role="progressbar" aria-valuenow="<%= rEmAvali%>" aria-valuemin="0" aria-valuemax="100" style="width: <% out.print(rEmAvali + "%");%>">
                            <%= rEmAvali%>%
                        </div>
                    </div>
                    <p>Resposta excelente:</p>
                    <div class="progress">
                        <div id="exc" class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="<%= rExelente%>" aria-valuemin="0" aria-valuemax="100" style="width: <% out.print(rExelente + "%");%>">
                            <%= rExelente%>%
                        </div>
                    </div>
                    <p>Resposta boa: </p>
                    <div class="progress">
                        <div id="boa" class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="<%= rBoa%>" aria-valuemin="0" aria-valuemax="100" style="width: <% out.print(rBoa + "%");%>">
                            <%= rBoa%>%
                        </div>
                    </div>
                    <p>Resposta mediana: </p>
                    <div class="progress">
                        <div id="med" class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar" aria-valuenow="<%= rMediana%>" aria-valuemin="0" aria-valuemax="100" style="width: <% out.print(rMediana + "%");%>">
                            <%= rMediana%>%
                        </div>
                    </div>
                    <p>Resposta ruim: </p>
                    <div id="rui" class="progress">
                        <div class="progress-bar progress-bar-danger progress-bar-striped active" role="progressbar" aria-valuenow="<%= rRuim%>" aria-valuemin="0" aria-valuemax="100" style="width: <% out.print(rRuim + "%");%>">
                            <%= rRuim%>%
                        </div>
                    </div>
                    <div>
                        <jsp:include page="../include/rodape.jsp" />
                    </div>
                    <div>
                        <jsp:include page="../include/footDentro.jsp" />
                    </div>
                </div>
            </div>
        </div>
        <% }%>
    </body>
</html>
