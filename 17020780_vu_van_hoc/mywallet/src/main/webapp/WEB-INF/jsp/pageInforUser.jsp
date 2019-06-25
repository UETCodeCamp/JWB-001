<%@ page import="com.uetcodecamp.vuvanhoc.model.Customer" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Thông tin tài khoản </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>
<link href="webjars/bootstrap/3.4.1/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<div class="header">
	<h1>MY WALLET</h1>
	<ul>
		<li><a href="/">Trang chủ</a></li>
	</ul>
</div>

<div class="form">
	<%
		Customer customer = (Customer) request.getAttribute("customer");
	%>
	<form action="/giao-dich/<%=customer.getId()%>" method="post" >
		<label>Thông tin tài khoản</label><br><br>
		ID: <%=customer.getId()%><br><br>
		Tên: <%=customer.getName()%><br><br>
		Email: <%=customer.getEmail()%><br><br>
		Phone: <%=customer.getPhone()%><br><br>
		Số dư khả dụng: <%=customer.getBalance()%> VNĐ<br><br>
		Ngày tạo tài khoản: <br><br>
		Ngày cập nhật: <br><br>
		<input type="submit" value="Chuyển tiền ">
	</form>

</div>
</body>
</html>