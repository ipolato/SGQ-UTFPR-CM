<%-- 
    Document   : recuperaSenha
    Created on : 11/03/2017, 00:01:40
    Author     : popovicz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recuperar Senha</title>
        <script>
            function valida_form(email) {
                var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                if (!filter.test(document.getElementById("email").value)) {
                    alert('Por favor, digite o email corretamente');
                    document.getElementById("email").focus();
                    return false
                }
            }
        </script>
        <jsp:include page="include/head.jsp" />
    </head>
    <body>
        <div>
            <div class="container">
                <jsp:include page="include/menuCadastrar.jsp" />
            </div>
            <form id="formulario" action="SvNovaSenha" method="post">
                <div class="container" style="margin-top: 80px">
                    <div class="form-group">
                        <h2 class="col-md-offset-4">Recuperar Senha</h2>

                        <label for="email">Email</label>
                        <input type="email" onblur="return valida_form(email)" class="form-control" id="email" name="email" placeholder="E-mail">
                    </div>
                    <button type="submit" class="btn btn-success col-md-offset-11" style="margin-bottom: 7px" >Enviar</button>
                </div>
            </form>
        </div>
        <jsp:include page="include/foot.jsp" />
    </body>
</html>