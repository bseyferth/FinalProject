<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>

<form action = "/create-new-user">
<p>Create username</p>
<input type = "text" name= "username">
<p>Create password</p>
<input type = "text" name = "password">
<p>First name</p>
<input type = "text" name = "firstName">
<p>Last name</p>
<input type = "text" name = "lastName">
<p>Email address</p>
<input type = "email" name = "email">
<p>Street address</p>
<input type = "text" name = "address">
<p>City</p>
<input type = "text" name = "city">
<p>State</p>
<input type = "text" name = "state">
<p>Zip</p>
<input type = "text" name = "zip">
<p>Current Fear</p>
<select name = "fear">
<option value = "Spiders">Spiders</option>
<option value = "Heights">Heights</option>
<option value = "Germs">Germs</option>
</select>
<button type = "submit">Create Account</button>
</form>
</body>
</html>