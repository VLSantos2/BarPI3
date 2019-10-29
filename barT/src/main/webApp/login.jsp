<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

    
	<form action="login" method="post" class="form-signin">
		<div class="text-center mb-4">
			<img class="mb-4"
				src="https://img.icons8.com/plasticine/72/000000/beer.png"
				width="72" height="72">
			<h1 class="h3 mb-3 font-weight-normal">Bar Tades</h1>
		</div>

		<div class="form-label-group">
			<input type="email" id="inputEmail" class="form-control"
				placeholder="Email address" name="emailUsuario" required autofocus>
			<label for="inputEmail">Email address</label>
		</div>

		<div class="form-label-group">
			<input type="password" id="inputPassword" class="form-control"
				placeholder="Password" name="senhaUsuario" required> <label
				for="inputPassword">Password</label>
		</div>
		<c:if test="${loginInvalido == true}">
		<p style="color:red;">Login incorreto. Por favor, verifique suas credenciais!</p>
		</c:if>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
	</form>
	
</body>
</html>