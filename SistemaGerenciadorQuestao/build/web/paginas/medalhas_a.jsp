<%-- 
    Document   : medalhas
    Created on : 28/09/2016, 20:23:17
    Author     : popovicz
--%>
<%@page import="br.com.utfpr.beans.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Medalhas</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body>
        <div class="container">
            <jsp:include page="../include/menuTop.jsp" />
        </div>
        <%
            Aluno aluno = (Aluno) session.getAttribute("aluno");
            if (aluno == null) {
                response.sendRedirect("acessoRestrito.jsp");
            } else {
        %>  
        <div class="row">
            <div class="col-md-2 col-xs-12" style="margin-top: 55px;"> 
                <jsp:include page="../include/menuAluno.jsp" />
            </div>
            <div class="col-md-10" style="margin-top: 55px">
                <h2 class="col-md-offset-5"> Quadro de Medalhas </h2>

                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaLivroDeOuroPronta.png" 
                         onMouseOver="this.src='../img/MedalhaLivroDeOuroProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaLivroDeOuroPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaLivroDePrataPronta.png" 
                         onMouseOver="this.src='../img/MedalhaLivroDePrataProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaLivroDePrataPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaComentarioDeOuroPronta.png" 
                         onMouseOver="this.src='../img/MedalhaComentarioDeOuroProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaComentarioDeOuroPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaComentarioDePrataPronta.png" 
                         onMouseOver="this.src='../img/MedalhaComentarioDePrataProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaComentarioDePrataPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaDeOuroPronta.png" 
                         onMouseOver="this.src='../img/MedalhaDeOuroProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaDeOuroPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaDePrataPronta.png" 
                         onMouseOver="this.src='../img/MedalhaDePrataProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaDePrataPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaTresEstrelaPronta.png" 
                         onMouseOver="this.src='../img/MedalhaTresEstrelaProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaTresEstrelaPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaTresEstrelaDePrataPronta.png" 
                         onMouseOver="this.src='../img/MedalhaTresEstrelaDePrataProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaTresEstrelaDePrataPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaDuasEstrelaDeOuroPronta.png" 
                         onMouseOver="this.src='../img/MedalhaDuasEstrelaDeOuroProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaDuasEstrelaDeOuroPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaDuasEstrelaDePrataPronta.png" 
                         onMouseOver="this.src='../img/MedalhaDuasEstrelaDePrataProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaDuasEstrelaDePrataPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;" src="../img/MedalhaUmaEstrelaDeOuroPronta.png" 
                         onMouseOver="this.src='../img/MedalhaUmaEstrelaDeOuroProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaUmaEstrelaDeOuroPronta.png'">
                </div>
                <div class="col-md-6" style="margin-top: 8px;">
                    <img style=" max-width: 450px;"  src="../img/MedalhaUmaEstrelaDePrataPronta.png" 
                         onMouseOver="this.src='../img/MedalhaUmaEstrelaDePrataProntaTexto.png'"
                         onMouseOut="this.src='../img/MedalhaUmaEstrelaDePrataPronta.png'">
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 10px">
            <jsp:include page="../include/footDentro.jsp" />
            <footer class="container-fluid text-center" >
                <p>&copy; 2016 Todos direitos reservados - Willian Popovicz   </p>
            </footer>
        </div>
        <% }%>
    </body>
</html>
