<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
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
<p>Step 4: ${userFear.getStep4()}</p>
<p>Progress completed:</p>
<p><progress value = "${user1.getFearProgress()}" max = 4></progress></p>
<p>You have currently completed ${user1.getFearProgress()} of the 4 steps!</p>


<h3>Your partner's name is ${partner.getFirstName()}</h3>
<h5>You are each other's accountability partner and moral support. You will be there for each other every step of your journey towards conquering your fears.</h5>
<p>${partner.getFirstName()}'s ranking is ${partner.getRank()}</p>
<p>Currently, ${partner.getFirstName()}'s fear is ${partnerFear.getShortFear()}. You'll help them conquer their fear while they help you conquer yours.</p>
<p>The medical term for this fear is: ${partnerFear.getLongFear() }</p>
<p>It is defined as: ${word2}.</p>
<p><a href = "${partnerFear.getWebMDLink()}">Here</a> you can access more information</p>
<p>Here is what your partner will need to do to overcome their fear of ${partnerFear.getShortFear()}</p>
<p>Step 1: ${partnerFear.getStep1()}<a href = "/steps">test</a></p>
<p>Step 1:  <input type="button" value="Complete" onclick="steps"></p>
<p>Step 2: ${partnerFear.getStep2()}<a href = "/steps">test</a></p>
<p>Step 3: ${partnerFear.getStep3()}<a href = "/steps">test</a></p>
<p>Step 4: ${partnerFear.getStep4()}<a href = "/steps">test</a></p>
<p>Your partner's progess:</p>
<p><progress value = "${partner.getFearProgress()}" max = 4></progress></p>
<p>Your partner has currently completed ${partner.getFearProgress()} of the 4 steps!</p>

<a href = "/logout">Log Out</a>
</body>
</html>