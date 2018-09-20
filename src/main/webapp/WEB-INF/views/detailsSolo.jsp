<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile Solo</title>
</head>
<!--  <body>
<img src="https://graph.facebook.com/${user1.getFacebookId()}/picture?type=large">

<h3>Hello, ${user1.getFirstName()}</h3> 
<p>We are excited you have joined to take on your fear!</p>
<p>Your username is ${user1.getUsername()}. Use this to log in to your account.</p>
<p>Your ranking is ${user1.getRank()}</p>
<p>Currently, we have your fear registered as ${userFear.getShortFear()}. Don't worry you and your partner will overcome this fear together!</p>
<p>The medical term for this fear is: ${userFear.getLongFear() }</p>
<p>It is defined as: ${word}.</p>
<p><a href = "${userFear.getWebMDLink()}">Here</a> you can access more information</p>
<p>Here are the steps you will need to take to overcome your fear of ${userFear.getShortFear()}</p>
<p>Step 1: ${userFear.getStep1()}</p>
<p>Step 2: ${userFear.getStep2()}</p>
<p>Step 3: ${userFear.getStep3()}</p>
<p>Step 4: ${userFear.getStep4()}</p> -->

<body class = "detailsbody">
<div class = "container" class = "col-lg-3">


<div class = "container" class = "col-lg-3" class= "clearfix">
<div class = "hellojumbo">
	<h1 class = "hello">Hello, ${user1.getFirstName()}!</h1>
  		<img class = "detailslogo" src = "images/Little_Victories_Logo.png">
    	</div>
    	</div>


<div class= "userview" class = "clearfix">
<h3>Your Details</h3>
<div class = "line-one">
<p>We are excited you have joined to take on your fear!</p>
</div>
<div class = "flex-container" class="d-flex justify-content-center">

	<div class = "stats">
		<p>Your username is ${user1.getUsername()}. Use this to log in to your account.</p>
		<br>
		
		
                        <p>Your ranking is ${user1.getRank()}
                
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                <span class="fa fa-star"></span>
                            </a>
                            <a href="#">
                                 <span class="fa fa-star-o"></span>
                            </a> 
                            </p>
                       

		
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
<p>Unfortunately our system does not currently have a fear partner who matches your needs.
Please continue to check back in. When a suitable partner becomes available, your profile view will display your partner's information.</p>

</div>


<a href = "/logout">Log Out</a>
<a href = "/newFearForm">New Fear</a>
</body>
</html>