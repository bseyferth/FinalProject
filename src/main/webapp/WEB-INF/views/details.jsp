<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
  crossorigin="anonymous">

<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
  integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
  crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
     <link rel="stylesheet" href="/style.css">
    

    
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  
<title>User Profile</title>

</head>
<nav class="navbar navbar-default">
 <div class="container-fluid">
   <div class="navbar-header">
     <a class="navbar-brand" href="#">    Little Victories</a>
   </div>
   <ul class="nav navbar-nav">
     <li><a href="/">Home</a></li>
           <li><a href = "/newFearForm">Add a new fear</a></li>
           <li><a href="/logout">Logout</a></li>

   </ul>

 </div>
</nav>

<body class = "detailsbody">
<div class = "container" class = "col-lg-3">


<div class = "container" class = "col-lg-3" class= "clearfix">
<div class = "hellojumbo">
	<h1 class = "hello">Hello, ${user1.getFirstName()}!</h1>
  		<img class = "detailslogo" src = "images/Little_Victories_Logo.png">
    	</div>
    	</div>

<div class = "flex-container" class = "d-flex justify-content-center">
<div class= "userview" class = "clearfix">
<h3>Your Details</h3>
<div class = "line-one">
<p>We are excited you have joined to take on your fear!</p>
</div>
<div class = "flex-container" class="d-flex justify-content-center">

	<div class = "stats">
		<p>Your username is ${user1.getUsername()}. Use this to log in to your account.</p>
		<br>
		 <p>Your ranking:</p>
		 <p> ${user1.getRank()}  <span class="fa fa-star"></span>
         </p>
                 
                           
                     <!--       <a href="#">
                                <span class="fa fa-star-o"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star-o"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star-o"></span>
                            </a>
                            <a href="#">
                                 <span class="fa fa-star-o"></span>
                            </a>  --> 
   
		
	</div>
<div class = "fearstats">
	<p>Currently, we have your fear registered as ${userFear.getShortFear()}. Don't worry; you and your partner will overcome this fear together!</p>
	<p>The medical term for this fear is: ${userFear.getLongFear() }</p>
	<p>It is defined as: ${word}</p>
	<p><a href = "${userFear.getWebMDLink()}">Here</a> you can access more information</p>
</div>
</div>
<div class = "steps">
<p>Here are the steps you will need to take to overcome your fear of ${userFear.getShortFear()}</p>
<p>Step 1: ${userFear.getStep1()}</p>
<p>Step 2: ${userFear.getStep2()}</p>
<p>Step 3: ${userFear.getStep3()}</p>
<p>Step 4: ${userFear.getStep4()}</p>
</div>
<p>Progress completed:</p>
<p><progress value = "${user1.getFearProgress()}" max = 4></progress></p>
<p>You have currently completed ${user1.getFearProgress()} of the 4 steps!</p>


<div class = "messagesdiv">
<p>Here are the messages between you and your partner, ${partner.getFirstName()}: </p>
	<c:forEach var = "userMessage" items = "${userMessages}">
	From ${userMessage.getSenderName()} on ${userMessage.getMessageSent()}: ${userMessage.getUserMessage()}<br /> 
	</c:forEach>
<form action = "/messages" id="userform">
<p>Send ${partner.getFirstName()} a message!</p>
<textarea name ="messagebox" id= "userform"></textarea>
<input type = "submit">
</form>
</div>
</div>
</div>

<div class = "partnerview" class = "clearfix">
<h3>Your partner's name is ${partner.getFirstName()}</h3>
<div class = "line-one" class = "text-center">
	<p>You are each other's accountability partner and moral support. You will be there for each other every step of your journey towards conquering your fears.</p>
</div>
<div class = "stats">
<p>${partner.getFirstName()}'s current ranking:</p>
<p> ${partner.getRank()}<span class="fa fa-star"></span></p> <br><br><br>
</div>
 



<div class = "flex-container" class="d-flex justify-content-center">

<div class = "fearstats" id = "partnerfearstats">
<p>Currently, ${partner.getFirstName()}'s fear is ${partnerFear.getShortFear()}. You'll help them conquer their fear while they help you conquer yours.</p>
<p>The medical term for this fear is: ${partnerFear.getLongFear() }</p>
<p>It is defined as: ${word2}.</p>
<p><a href = "${partnerFear.getWebMDLink()}">Here</a> you can access more information</p>
</div>
</div>
<div class = "steps">
<p>Here is what your partner will need to do to overcome their fear of ${partnerFear.getShortFear()}</p>
<p>Step 1: ${partnerFear.getStep1()}<a href = "/steps">Done!</a></p>
<p>Step 2: ${partnerFear.getStep2()}<a href = "/steps">Done!</a></p>
<p>Step 3: ${partnerFear.getStep3()}<a href = "/steps">Done!</a></p>
<p>Step 4: ${partnerFear.getStep4()}<a href = "/steps">Done!</a></p>
</div>

<p>Your partner's progress:</p>
<p><progress value = "${partner.getFearProgress()}" max = 4></progress></p>
<p>Your partner has currently completed ${partner.getFearProgress()} of the 4 steps!</p>

</div>
<p><a href = "/logout">Log Out</a></p>
<p><a href = "/newFearForm">New Fear</a></p>
</div>
</body>
</html>