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

<form action = "/create-new-user">
<input type="hidden" name="facebookId" value= "" />
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
<option value = "Small Spaces">Small Spaces</option>
<option value = "Public Speaking">Public Speaking</option>
<option value = "Needles">Needles</option>
<option value = "Clowns">Clowns</option>
<option value = "Driving">Driving</option>

</select>

<p>Please note that the following details will be shared with your partner in this app: first name, fear, progress, ranking, and email address. 
If you are not comfortable sharing these details, please do not use this app.</p>

<p>Disclaimer: Please note that we are not mental health professionals. 

The content offered in Little Victories is solely based on opinion.
This content is not reviewed by a physician. Do not consider Little Victories as medical advice. Never 
delay or disregard seeking professional 
medical advice from your doctor or other qualified healthcare provider because of 
something you have read on Little Victories. 
You should 
 always speak with your doctor before you start, stop, or change any prescribed part of your care plan
 or treatment. Little Victories understands that accomplishing small victories can be a helpful 
 step in overcoming fears and relieving anxiety, but it is never a substitute for professional 
 medical advice, diagnosis, or treatment 
 from a qualified health care provider. If you think you may have a medical emergency, call 
 your doctor or dial 911 immediately. </p>

<button type = "submit">Create Account</button>
</form>
</body>
</html>