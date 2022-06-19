<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" href="contactus.css"/>
</head>	
<body>
	<div class="bg-container">
		<h1>Contact Us</h1>
		<p>Please fill this form in a descent manner</p>
		<form class="form-container" action="contactus" method="post">
			Full Name :<input class="input" type="text" name="name" required/><br/>
			E-mail :<input class="input" type="email" name="email" required><br/>
			Message :
			<textarea class="text-area" col="100" rows="10" name="message" required></textarea><br/>
			<input type="submit"/>
		</form>
	</div>
</body>
</html>