<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css"/>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<div class="bg-container">
		<h1>Admin Login</h1>
		<form class="form-container" method="post">
			Username :<input class="input" type="text" name="username" required/><br/>
			Password :<input class="input" type="password" name="password" required><br/>
			<input type="submit"/>
		</form>
	</div>
</body>
</html>