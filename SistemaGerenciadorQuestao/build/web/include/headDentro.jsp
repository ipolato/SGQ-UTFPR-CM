
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Gerenciador de questao">
<meta name="author" content="Willian Lopes Popovicz">
<link rel="icon" href="../img/favicon.ico">

<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/bootstrap-theme.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../css/custom.css" rel="stylesheet">
<link href="../css/bootstrap-select.min.css" rel="stylesheet">
<script language="Javascript">
    function confirmacao(id, servlet) {
        var resposta = confirm("Deseja remover esse registro?");
 
        if (resposta == true) {
            window.location.href = servlet+id;
        }
    }
    
</script>
<style>
    footer {
        background-color: #f2f2f2;
        padding: 25px;
    }
</style>