<%@ page import="com.uetcodecamp.vuvanhoc.objects.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Home</title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet">
</head>
<body>
<div class="header">
	<h1>MY WALLET</h1>
	<a class="link" href="/">Home</a>
</div>
<div class="home">
	<h3>Danh sách người dùng</h3><br>
	
	<a class="buttonHome" href="/them-nguoi-dung">Thêm</a>
	<table id="customers">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Balance</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<%
				ArrayList<User> results = (ArrayList<User>) request.getAttribute("items");
				for (int i = 0; i < results.size(); i++) {
			%>
			<tr>
				<td style="text-align: center"><%=results.get(i).getId()%>
				</td>
				<td><%=results.get(i).getName()%>
				</td>
				<td><%=results.get(i).getEmail()%>
				</td>
				<td><%=results.get(i).getPhone()%>
				</td>
				<td style="text-align: right"><%=results.get(i).getBalance()%>
				</td>
				<td><a href="/sua-thong-tin/<%=results.get(i).getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
			
		</tbody>
	</table>
</div>


</body>
</html>