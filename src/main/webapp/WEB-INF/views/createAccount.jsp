<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
<head>
<meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><title>New User</title>
</head>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">	Little Victories</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/">Home</a></li>
    </ul>
    
  </div>
</nav>
<body>
<main class="container">
		
	

	<img src="image123/avatar.jpg">
<br>
<br>
<br>
	<form action="/create-new-user">
		<input type="hidden" name="facebookId" value= "" />
		<!--  <div class="row"> -->
			<div class="col-sm-6">
				<input type="text" class="form-control" placeholder="First Name"name="firstname" required minlength="2" maxlength="10" /> 
				<br>
				<input type="text" class="form-control" placeholder="Username" name="username" required /> 
				<br>
					<input type="text" class="form-control" placeholder="Email" name="email" required />
					<br> 
					<input type="text" class="form-control" placeholder="City" name="city"required /> 
				<br>
					<h3>State:
					<select name ="state">
	<option value="AL">Alabama</option>
	<option value="AK">Alaska</option>
	<option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option>
	<option value="CA">California</option>
	<option value="CO">Colorado</option>
	<option value="CT">Connecticut</option>
	<option value="DE">Delaware</option>
	<option value="DC">District Of Columbia</option>
	<option value="FL">Florida</option>
	<option value="GA">Georgia</option>
	<option value="HI">Hawaii</option>
	<option value="ID">Idaho</option>
	<option value="IL">Illinois</option>
	<option value="IN">Indiana</option>
	<option value="IA">Iowa</option>
	<option value="KS">Kansas</option>
	<option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option>
	<option value="ME">Maine</option>
	<option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option>
	<option value="MI">Michigan</option>
	<option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option>
	<option value="MO">Missouri</option>
	<option value="MT">Montana</option>
	<option value="NE">Nebraska</option>
	<option value="NV">Nevada</option>
	<option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option>
	<option value="NM">New Mexico</option>
	<option value="NY">New York</option>
	<option value="NC">North Carolina</option>
	<option value="ND">North Dakota</option>
	<option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option>
	<option value="OR">Oregon</option>
	<option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option>
	<option value="SC">South Carolina</option>
	<option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option>
	<option value="TX">Texas</option>
	<option value="UT">Utah</option>
	<option value="VT">Vermont</option>
	<option value="VA">Virginia</option>
	<option value="WA">Washington</option>
	<option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option>
	<option value="WY">Wyoming</option>
</select>	
</h3>	
		 </div> 
			
			<div class="col-sm-6">
				<input type="text" class="form-control" placeholder="Last Name"name="lastname" required minlength="2" maxlength="10" />
				<br>
				<input type="text" class="form-control" placeholder="Password" name="password" required /> 
				<br>
				<input type="text" class="form-control" placeholder="Street Address"name="address" required /> 
				<br> 
				</div>
		</div>
		
		<h3> What is your current fear : 
				<select name="fear">
					<option value="Spiders">Spiders</option>
					<option value="Heights">Heights</option>
					<option value="Germs">Germs</option>
					<option value="Small Spaces">Small Spaces</option>
					<option value="Public Speaking">Public Speaking</option>
					<option value="Needles">Needles</option>
					<option value="Clowns">Clowns</option>
					<option value="Driving">Driving</option>

				</select> </h3>
				
				
					
				
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>

			

		<button type="submit" class="btn btn-primary mb-2">Create Account</button>
	</form>
	<br>
		<p>Please note that the following details will be shared with your
			partner in this app: first name, fear, progress, ranking, and email
			address. If you are not comfortable sharing these details, please do
			not use this app.</p>
<br>
		<p>Disclaimer: Please note that we are not mental health
			professionals. The content offered in Little Victories is solely
			based on opinion. This content is not reviewed by a physician. Do not
			consider Little Victories as medical advice. Never delay or disregard
			seeking professional medical advice from your doctor or other
			qualified healthcare provider because of something you have read on
			Little Victories. You should always speak with your doctor before you
			start, stop, or change any prescribed part of your care plan or
			treatment. Little Victories understands that accomplishing small
			victories can be a helpful step in overcoming fears and relieving
			anxiety, but it is never a substitute for professional medical
			advice, diagnosis, or treatment from a qualified health care
			provider. If you think you may have a medical emergency, call your
			doctor or dial 911 immediately.</p>
	</main>
</body>
</html>

