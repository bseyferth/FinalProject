<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
<p>${message}</p>

<form action = "/newFear">
<p>Current Fear</p>
<select name = "fear">
<option value = "Spiders">Spiders</option>
<option value = "Heights">Heights</option>
<option value = "Germs">Germs</option>
<option value = "Small Spaces">Small Spaces</option>
<option value = "Public Speaking">Public Speaking</option>
<option value = "Needles">Needles</option>
<option value = "Clowns">Clowns</option>
<option value = "Driving">Driving</option>
</select>
<button type = "submit">Create New Fear</button>
</form>

</body>
</html>