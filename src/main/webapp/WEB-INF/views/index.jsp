<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Little Victories</h1>
<h3>Welcome! We're excited to help you conquer your fears.</h3>
<p>Introduction goes here.</p>

${message}

	<form action = "login">
	<p>Username:</p>
	<input type = "text" name="username">
	<p>Password:</p>
	<input type = "password" name="password">
	<button type = "submit">Log In</button>
	</form>

<a href="/create-account" type = "submit"> Create Account</a>
</body>
</html>