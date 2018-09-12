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
<p>Your username for the site is ${user1.getUsername()}. This will be what is used to login to your account.</p>
<p>Currently we have your fear registered as ${userFear.getShortFear()}. Don't worry you and your partner will overcome this fear together!</p>
<p>Did you know that this fears medical term is: ${userFear.getLongFear() }</p>
<p>It is defined as: ${word}.</p>
<p><a href = "${userFear.getWebMDLink()}">Here</a> you can access more information</p>
<p>Here is what you will need to do to overcome your fear of ${userFear.getShortFear()}</p>
<p>Step 1: ${userFear.getStep1()}</p>
<p>Step 1: ${userFear.getStep2()}</p>
<p>Step 1: ${userFear.getStep3()}</p>
<p>Step 1: ${userFear.getStep4()}</p>

<p>Unfortunately our system does not have a fear partner who matches the needed criteria.
If you continue to login you will be paired with a partner randomly and your view will change to the correct view when a partner is automatically assigned.</p>

<a href = "/logout">Log Out</a>

</body>
</html>