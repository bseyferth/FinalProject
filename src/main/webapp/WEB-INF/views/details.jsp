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

<p>${word}</p>
<p>${user1}</p>
<p>${partner}</p>
<p>${userFear}</p>
<p>${partnerFear }</p>
<p>${word2}</p>
<p><a href = "/steps">test</a></p>
<p>Step 1: <input type="button" value="Complete" onclick="/steps"></p>
<p>Step 2:  <input type="button" value="Complete" onclick="/steps"></p>
<p>Step 3:  <input type="button" value="Complete" onclick="steps"></p>
<p>Step 4:  <input type="button" value="Complete" onclick="steps"></p>



<p>Progress completed:</p>
<p><progress value = ${fearProgress } max = 4></progress></p>

<a href = "/logout">Log Out</a>
</body>
</html>