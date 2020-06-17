<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Login</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../../static/css/login.css">

</head>

<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/static/getrequest.js"></script>
<script src="/static/postrequest.js"></script>
<script src="/static/accordion.js"></script>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <!--            <form th:action="@{/login}" action="/login" method="POST" class="col-md-12">-->
            <div class="imgcontainer">
                <h1>Login da aplicação</h1>
            </div>
            <div class="col-md-12">
                <label for="username"><b>Login</b></label>
                <input type="text" placeholder="Preencha o login" name="username" id="username"></input>
                <label for="password"><b>Senha</b></label>
                <input type="password" placeholder="Preencha a senha" name="password" id="password"></input>
                <button id="btnLogar" type="submit">Logar</button>
                <button id="btnLimpar" type="submit">Limpar</button>
                <a href="./cadUsuario.html"><p style="text-align:center">Cadastrar novo usuário</p></a>

                <h2>Temporário para teste</h2>
<!--                <a href="./listagemProdutos.html"><p style="text-align:center">Produtos</p></a>-->
                <a href="./listagemProdutos.jsp"><p style="text-align:center">Produtos</p></a>
                <a href="./listagemRelatorios.html"><p style="text-align:center">Relatórios</p></a>
            </div>
            <!--            </form>-->
        </div>
    </div>
</div>
</body>
</html>

<!--FALTA AJUSTAR LOGIN-->
<script>
        $('#btnLogar').on("click", function (e) {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: 'POST',
                url: 'http://localhost:8080/login',
                data: JSON.stringify({
                    "login": $("#login").val(), "senha": $("#senha").val()
                }),
                processData: false,
                success: function (jsonObject) {
                    document.location = 'http://localhost:8080/';
                },
                error: function (data) {
                    alert('Não foi possível logar, contate o Lessa :)');
                }
            });
            return false;
        });

    // $(document).ready(function() {
    //
    //     $('##btnLogar').on('click', function(e) {
    //
    //         e.preventDefault();
    //
    //         var login = $('#login').val();
    //         var senha = $('#senha').val();;
    //         alert(login);
    //         alert(senha)
    //         $.ajax({
    //             url: 'http://localhost:8080/login',
    //             async: true,
    //             cache: false,
    //             type: 'POST',
    //             data: {"usuario.login":$("#login").val(), "usuario.senha":$("#senha").val(),
    //
    //
    //                 dataType: 'text',
    //
    //             }
    //
    //         });
    //         alert("oi");
    //
    //     });
    //
    // });
</script>