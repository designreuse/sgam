<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SGAM | Associação de Moradores</title>

	<link rel="stylesheet" type="text/css" media="screen"  href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen"  href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" />
    
	<link rel="stylesheet" type="text/css" media="screen"  href="${pageContext.request.contextPath}/css/animate.css" />
	<link rel="stylesheet" type="text/css" media="screen"  href="${pageContext.request.contextPath}/css/style.css" />

	<script type="text/javascript">
	window.onload = function(){
		$('#login').focus();
	}

	</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name"></h1>

            </div>
            <h3>SGAM</h3>
            <p>Sistema Gerencial para Associação de Moradores</p>
            
            <form class="m-t" action="${linkTo[LoginController].logar}" method="post">
                <div class="form-group">
                    <input id="login" type="text" name="usuario.login" class="form-control" placeholder="Usuário" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="usuario.senha" class="form-control" placeholder="Senha" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

                <a href="#"><small>Esqueceu a senha?</small></a>
                <p class="text-muted text-center"><small>Você tem uma conta?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="register.html">Crie uma conta</a>
            </form>
            <p class="m-t"> <small>Indefinido &copy; 2015</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>

</html>