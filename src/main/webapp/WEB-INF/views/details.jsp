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

<h3>Hello, ${user1.getFirstName()}</h3>
<p>We are excited you have joined to take on your fear!</p>
<p>Your username for the site is ${user1.getUsername()}. This will be what is used to login to your account.</p>
<p>Currently we have your fear registered as ${userFear.getShortFear()}. Don't worry you and your partner will overcome this fear together!</p>
<p>Did you know that this fears medical term is: ${userFear.getLongFear() }</p>
<p>It is defined as: ${word}.</p>
<p><a href = "${userFear.getWebMDLink()}">Here</a> you can access more information</p>
<p>Here is what you will need to do to overcome your fear of ${userFear.getShortFear()}</p>
<p>Step 1: ${userFear.getStep1()}</p>
<p>Step 2: ${userFear.getStep2()}</p>
<p>Step 3: ${userFear.getStep3()}</p>
<p>Step 4: ${userFear.getStep4()}</p>
<p>Progress completed:</p>
<p><progress value = "${user1.getFearProgress()}" max = 4></progress></p>
<p>You have currently completed ${user1.getFearProgress()} of the 4 steps!</p>


<h3>Hello, ${partner.getFirstName()}</h3>
<p>We are excited you have joined to take on your fear!</p>
<p>Your username for the site is ${partner.getUsername()}. This will be what is used to login to your account.</p>
<p>Currently we have your fear registered as ${partnerFear.getShortFear()}. Don't worry you and your partner will overcome this fear together!</p>
<p>Did you know that this fears medical term is: ${partnerFear.getLongFear() }</p>
<p>It is defined as: ${word2}.</p>
<p><a href = "${partnerFear.getWebMDLink()}">Here</a> you can access more information</p>
<p>Here is what you will need to do to overcome your fear of ${partnerFear.getShortFear()}</p>
<p>Step 1: ${partnerFear.getStep1()}<a href = "/steps">test</a></p>
<p>Step 2: ${partnerFear.getStep2()}<a href = "/steps">test</a></p>
<p>Step 3: ${partnerFear.getStep3()}<a href = "/steps">test</a></p>
<p>Step 4: ${partnerFear.getStep4()}<a href = "/steps">test</a></p>
<p>Progress completed:</p>
<p><progress value = "${partner.getFearProgress()}" max = 4></progress></p>
<p>Your partner has currently completed ${partner.getFearProgress()} of the 4 steps!</p>


<p>${word}</p>
<p>${user1}</p>
<p>${partner}</p>
<p>${userFear}</p>
<p>${partnerFear }</p>
<p>${word2}</p>
<p></p>
<p>Step 1: <input type="button" value="Complete" onclick="/steps"></p>
<p>Step 2:  <input type="button" value="Complete" onclick="/steps"></p>
<p>Step 3:  <input type="button" value="Complete" onclick="steps"></p>
<p>Step 4:  <input type="button" value="Complete" onclick="steps"></p>





<a href = "/logout">Log Out</a>
</body>
</html>