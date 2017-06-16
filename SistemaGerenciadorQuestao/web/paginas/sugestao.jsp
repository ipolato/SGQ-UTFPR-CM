<%-- 
    Document   : sugestao
    Created on : 06/01/2017, 23:48:38
    Author     : popovicz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGQ - Sugestão</title>
        <jsp:include page="../include/headDentro.jsp" />
    </head>
    <body  >
        <div class="container">
            <jsp:include page="../include/menuTop.jsp" />

            <form id="formulario" action="SvSugestao" method="post" style="margin-top: 150px;">
                <div class="form-group col-md-12">
                    <h2>Reclamações, críticas, sugestões ou elogios!</h2>
                    <textarea class="form-control" id="artigo" name="artigo" placeholder="Deixe sua reclamação, crítica, sugestão ou elogio aqui!" onscroll="true" rows="10"></textarea>
                </div>

                <div class="row col-md-offset-9 col-md-3">
                    <button type="submit" class="btn btn-primary" style="width: 100px;"><span class="glyphicon glyphicon-send" title="Sugestão" aria-hidden="true"></span> Enviar</button>&NonBreakingSpace;
                    <a href="inicial_a.jsp" class="btn btn-default"><span class="glyphicon glyphicon-remove" title="Sugestão" aria-hidden="true"></span> Cancelar</a>
                </div>

            </form>
        </div>
    </body>
</html>
