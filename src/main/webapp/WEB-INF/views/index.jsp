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
<!-- 
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link rel = "stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css">
<link rel = "stylesheet" href="style.css">
-->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel = "stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css">

<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">


<link rel = "stylesheet" href="style.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->



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
<<<<<<< HEAD
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
=======

<!-- 
<div class = "indexpage">
	<div class = container class = "col-lg-3">
<img class = "logo" src = "images/Little_Victories_Logo.png">
<h3>Welcome! We're excited to help you conquer your fears.</h3>
<p>We've created an app that is intended to connect people with each other to overcome their fears in a collaborative manner. Our hope is that you will make friends while helping each other improve your quality of life.</p>
	</div>
${specificmessage}
	<div class = "container"  class= "loginform" class = "col-sm-3">
	<form action = "login">
	<div class = "form-group">
	<p>Username</p>
	<input type = "text" class = "form-control" name="username" placeholder = "Username">
	</div>
	<div class = "form-group">
	<p>Password</p>
	<input type = "password" class = "form-control" name="password" placeholder = "Password">
	</div>
	<button type = "submit" class = "btn btn-primary">Log In</button>
	</form>
	<p>-or-</p>
	<p><a href="/create-account" type = "submit" class = "btn btn-primary"> Create Account</a></p>
	
	<p><a href="https://www.facebook.com/v3.1/dialog/oauth?client_id=1509075672527896&redirect_uri=http://localhost:8080/oauth-facebook-callback&state=pizza" class = "btn btn-primary" type = "submit">Create Account with Facebook</a></p>

</div>
</div>

 -->

   <div class="container">

         	<div class = "col-md-12 mx-auto text-center">
             <img class = "logo" src = "images/Little_Victories_Logo.png">
			<h3 class = "welcome">Welcome! We're excited to help you conquer your fears.</h3>
			<p>We've created an app that is intended to connect people with each other to overcome their fears in a collaborative manner. Our hope is that you will make friends while helping each other improve your quality of life.</p>
			${specificmessage}
			</div>
      
      <div class="col-md-6 mx-auto text-center">
         <div class="header-title">
       		<h4> Please log in or create an account.   </h4>
       	</div>
      </div>
      <div class="row">
         <div class="col-md-4 mx-auto">
            <div class="myform form ">
               <form action="login" method="post" name="login">
                  <div class="form-group">
                     <input type="text" name="username" class="form-control my-input" id="username" placeholder="Userame">
                  </div>
                  <div class="form-group">
                     <input type="password" name="password"  class="form-control my-input" id="password" placeholder="Password">
                  </div>
                  <div class="text-center ">
                     <button type="submit" class=" btn btn-block send-button tx-tfm" class = "send-button">Log in</button>
                  </div>
                  <div class="col-md-12 " class = "text-center">
                      <div class="login-or">
                        <hr class="hr-or">
                        <span class="span-or">-or-</span>
                  	  </div>
                  </div>
                
               </form>
               <p> <a href="/create-account">Create an Account</a> </p>
               
              <p>	<a href="https://www.facebook.com/v3.1/dialog/oauth?client_id=1509075672527896&redirect_uri=http://localhost:8080/oauth-facebook-callback&state=pizza">Create Account with Facebook</a>
            </p> 
           </div>
           </div>
           </div>
           </div>
           
            

>>>>>>> 7e7f157a6a6992f5a7f9479dd0aecd563af7907c
</body>
</html>