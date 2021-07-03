<<<<<<< HEAD
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="css/bootstrap.css" rel="stylesheet">
<title>Home</title>

<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <%
                    User isLogin = (User)request.getAttribute("session");
                    if(isLogin == null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Đăng nhập</a>
                </li>
                <%
                }
                else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Đăng xuất</a>
                </li>
                <%
                    }
                %>
            </ul>
            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" name = "name" id="txtSearch" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" id="search" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <br>
    <form action="add">
        <button type="submit" class="btn btn-secondary">Thêm</button>
    </form>
    <br>
<div id = "list">
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
    ArrayList<User> results = (ArrayList<User>) request.getAttribute("items");
    for (int i =0; i < results.size(); i++) {
%>
    <tbody>
    <tr id = "<%=results.get(i).getId()%>">
        <th scope="row"><%=results.get(i).getId()%></th>
        <td><%=results.get(i).getName()%></td>
        <td><%=results.get(i).getEmail()%></td>
        <td><%=results.get(i).getPhone()%></td>
        <td><%=results.get(i).getBalance()%></td>
        <td><a href="edit/<%=results.get(i).getId()%>" class = "btn btn-outline-primary">Sửa</a> <delete class = "delete" name="<%=results.get(i).getId()%>"><a class="btn btn-outline-danger">Xoá</a></delete> </td>
    </tr>
    </tbody>
<%
    }
%>
</table>
</div>
</div>
</body>


<script src="/js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>
=======
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Home</title>
<style>

    button {
        background-color: cadetblue;
        color: white;
        padding: 5px 15px;
        margin: 10px 0;
        border: none;
        cursor: pointer;
        /* width: 10%;*/
    }

    /* Add a hover effect for buttons */
    button:hover {
        opacity: 0.8;
    }
    #customers {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #customers tr:nth-child(even){background-color: #f2f2f2;}

    #customers tr:hover {background-color: #ddd;}

    #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: olivedrab;
        color: white;
    }


</style>
<body>
<form action="add">
    <button type="submit">Thêm</button>
</form>
<form action="login">
    <button type="submit">Đăng nhập</button>
</form>
<table id="customers">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Balance</th>
        <th></th>
    </tr>


<%
    ArrayList<User> results = (ArrayList<User>) request.getAttribute("items");
    for (int i =0; i < results.size(); i++) {
%>
<h1>
    <tr>
        <td><%=i+1%></td>
        <td><%=results.get(i).getName()%></td>
        <td><%=results.get(i).getEmail()%></td>
        <td><%=results.get(i).getPhone()%></td>
        <td><%=results.get(i).getBalance()%></td>
        <td><a href="edit">Edit</a> </td>
    </tr>
</h1>
<%
    }
%>
</table>
</body>
>>>>>>> 7834ff41e7663548ff48a128c22048c0cb26cf7a
</html>