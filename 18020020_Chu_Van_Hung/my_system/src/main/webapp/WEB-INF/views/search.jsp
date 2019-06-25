<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="css/bootstrap.css" rel="stylesheet">
<title>Search</title>
</head>
<body>
<table class = "table table-hover">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Balance</th>
        <th scope="col">Action</th>
    </tr>
    </thead>


    <%
        ArrayList<User> lstItems = (ArrayList<User>) request.getAttribute("items");
        ArrayList<Integer> results = (ArrayList<Integer>) request.getAttribute("lstSearch");
        for (int i =0; i < results.size(); i++) {
    %>
    <tbody>
    <tr id = "<%=lstItems.get(results.get(i)).getId()%>">
        <th scope="row"><%=i+1%></th>
        <td><%=lstItems.get(results.get(i)).getName()%></td>
        <td><%=lstItems.get(results.get(i)).getEmail()%></td>
        <td><%=lstItems.get(results.get(i)).getPhone()%></td>
        <td><%=lstItems.get(results.get(i)).getBalance()%></td>
        <td><a href="edit/<%=lstItems.get(results.get(i)).getId()%>" class = "btn btn-outline-primary">Sửa</a> <delete class = "delete" name="<%=lstItems.get(results.get(i)).getId()%>"><a class="btn btn-outline-danger">Xoá</a></delete> </td>
    </tr>
    </tbody>
    <%
        }
    %>
</table>
</body>

<script src="/js/jquery.min.js"></script>
<script src="js/custom.js"></script>
</html>