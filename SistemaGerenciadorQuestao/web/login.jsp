<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Gerenciador de Questão</title>
        <jsp:include page="include/head.jsp" />
    </head>
    <body>
        <jsp:include page="include/menuLogin.jsp" />
        <div class="jumbotron">
            <div class="container">
                <%
                    String mensagem = (String) request.getAttribute("mensagem");
                    String erro = (String) request.getAttribute("erro");
                    if (mensagem != null) {%>
                <div class="alert alert-success alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${mensagem}</strong>
                </div>
                <%  }%>
                <%   if (erro != null) {%>
                <div class="alert alert-danger alert-dismissible" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>${erro}</strong>
                </div>
                <%  } %>
                <h1>SGQ</h1>
                <p>Uma ferramenta para ajudar nas disciplinas de programação, onde os alunos cooperam para solucionar um problema. Criando um acervo de soluções e uma forma pratica e fácil de aprender.</p>
                <p><a class="btn btn-primary btn-lg" href="recuperaSenha.jsp" role="button">Recuperar senha &raquo;</a></p>
            </div>
        </div>

        <div class="container">
            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-4">
                    <h2>História das linguagens de programação</h2>
                    <p>As linguagens de programação são, anteriores ao advento do primeiro computador moderno. De início as linguagens eram apenas códigos. Durante um período de nove meses entre 1842-1843, Ada Lovelace traduziu as memórias do matemático italiano Luigi Menabrea sobre a a mais nova máquina proposta por Charles Babbage, a sua máquina analítica...</p>
                    <p><a class="btn btn-default" target="_blank" href="https://pt.wikipedia.org/wiki/Hist%C3%B3ria_das_linguagens_de_programa%C3%A7%C3%A3o" role="button">Saiba mais  &raquo;</a></p>
                </div>
                <div class="col-md-4">
                    <h2>Por quê aprender a programar?</h2>
                    <p>Apesar de parecer intimidante no começo, programar não é tão complicado como muitos pensam. Na verdade, da mesma forma como ler, escrever e fazer cálculos básicos, programação é a nova disciplina básica para alfabetização. Muitas pessoas pensam que programação é só para nerds, uns caras malucos que ficam o dia inteiro na frente do computador fazendo “não sei o quê”...</p>
                    <p><a class="btn btn-default" target="_blank" href="http://www.dicasdeprogramacao.com.br/por-que-aprender-a-programar/" role="button">Saiba mais &raquo;</a></p>
                </div>
                <div class="col-md-4">
                    <h2>Mercado de trabalho na crise: Ainda vale a pena ser programador?</h2>
                    <p>Nas últimas duas décadas, o cenário de tecnologia da informação e seu mercado de trabalho mudou completamente, principalmente agora que enfretamos uma crise econômica no país...</p>
                    <p><a class="btn btn-default" target="_blank" href="http://codigofonte.uol.com.br/artigos/mercado-de-trabalho-ainda-vale-a-pena-ser-programador" role="button">Saiba mais &raquo;</a></p>
                </div>
            </div>
            <jsp:include page="include/rodape.jsp" />
            <jsp:include page="include/foot.jsp" />
    </body>
</html>
