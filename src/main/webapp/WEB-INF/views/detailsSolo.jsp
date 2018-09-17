<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile Solo</title>
</head>
<body>

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

<p>Unfortunately our system does not currently have a fear partner who matches your needs.
Please continue to check back in. When a suitable partner becomes available, your profile view will display your partner's information.</p>

<a href = "/logout">Log Out</a>
<a href = "/newFearForm">New Fear</a>
</body>
</html>