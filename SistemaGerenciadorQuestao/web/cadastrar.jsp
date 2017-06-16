
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function valida_form(email) {
                var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                if (!filter.test(document.getElementById("email").value)) {
                    alert('Por favor, digite o email corretamente');
                    document.getElementById("email").focus();
                    return false
                }
            }
            
            function valida_senha(x1, x2) {
                var senha1 = x1.value;
                var senha2 = x2.value;
                if(senha1.eq(senha2)){
                    return true;
                }else{
                    alert('Por favor, digite as duas senha igual');
                    document.getElementById("senha2").focus();
                    return false
                }
            }
        </script>
        <title>Sistema Gerenciador de Questão</title>
        <jsp:include page="include/head.jsp" />
    </head>
    <body>
        <div>
            <div class="container">
                <jsp:include page="include/menuCadastrar.jsp" />
            </div>
            <form id="formulario" action="SvCadastro" method="post">
                <div class="container" style="margin-top: 80px">
                    <h2 class="col-md-offset-4"> Cadastro do SGQ </h2>
                    <div class="form-group">
                        <label for="nome" >Name</label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
                    </div>
                    <div class="form-group">
                        <label for="ra" >RA</label>
                        <input type="number" class="form-control" id="ra" name="ra" placeholder="RA">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" onblur="return valida_form(email)" class="form-control" id="email" name="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="senha1">Senha</label>
                        <input type="password" class="form-control" id="senha1" name="senha1" placeholder="Senha">
                    </div>
                    <div class="form-group">
                        <label for="senha2">Confirma senha</label>
                        <input type="password" onblur="return valida_senha(senha1, senha2)" class="form-control" id="senha2" name="senha2" placeholder="Senha">
                    </div>
                    <div class="form-group">
                        <label for="sexo">Sexo </label>
                        <label class="radio-inline"><input type="radio" name="sexo" value="M" checked>Masculino</label>
                        <label class="radio-inline"><input type="radio" name="sexo" value="F">Femenino</label>
                    </div>
                    <button type="submit" class="btn btn-success col-md-offset-11" style="margin-bottom: 7px" >Cadastrar</button>
                </div>
            </form>
        </div>
        <div>
            <jsp:include page="include/rodape.jsp" />
        </div>
        <jsp:include page="include/foot.jsp" />
    </body>
</html>
