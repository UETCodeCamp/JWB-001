<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Add user information</title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>
</head>
<body>
<div class="header">
	<h1>MY WALLET</h1>
	<a class="link" href="home">Home</a>
</div>

<div class="form">
	<form action="addUser2List" method="get" >
		<label>Thêm người dùng</label>
		<input type="text" name="name" id="name" placeholder="Enter name" required><br/>
		<input type="email" name="email" id="email" placeholder="Enter email" required><br/>
		<input type="tel" name="phone" id="phone" placeholder="Enter phone" required><br/>
		<input type="number" name="balance" id="balance" placeholder="Enter balance" required><br/>
		<input type="submit" value="Thêm">
	</form>
</div>
</body>
</html>