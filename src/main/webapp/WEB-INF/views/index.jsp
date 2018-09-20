<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">	Little Victories</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/">Home</a></li>
      <li><a href="/create-account">Create Account</a></li>
      <li><a href="https://www.facebook.com/v3.1/dialog/oauth?client_id=1509075672527896&redirect_uri=http://localhost:8080/oauth-facebook-callback&state=pizza">Login with fb</a></li>
      <li><a href="/logout">Logout</a></li>
    </ul>
    <form action="login" class="form-inline"method="POST">
    <input class="form-inline mr-sm-2" name="username" placeholder="Username" aria-label="username">
        <input class="form-inline mr-sm-2" name="password" type="password" placeholder="Password" aria-label="password">
        <button type="submit" class="btn btn-primary">Submit</button>
    
  </form>
  </div>
</nav>
<body>
<main class="container">
<br>
<br>
<h1>Little Victories</h1>
<h1><img src="image123/Little_Victories_Logo.png"/></h1>

<br>
<h3>Welcome! We're excited to help you conquer your fears.
We've created an app that is intended to connect people with each other to overcome their fears in a collaborative manner. 
Our hope is that you will make friends while helping each other improve your quality of life.</h3>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<p> © 2018 Little Victories
</main>
</body>
</html>