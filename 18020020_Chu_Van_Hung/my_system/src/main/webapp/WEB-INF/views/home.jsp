<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.css"/>

    <meta name="theme-color" content="#EE6E73">
    <title>Home</title>
</head>

<body>

    <div class="navbar-fixed">
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo center">My Wallet</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>


            </div>
        </nav>
    </div>
<br>
    <div class="row">
        <div class="col s12 m6 l3">
            <%
                User user = (User)request.getAttribute("session");
                if(user == null){
            %>
                <h5 class="center header">Đăng nhập</h5>
                <div class="col s12 z-depth-6 card-panel">
                    <form method="post" action="login" class="login-form">
                        <div class="row">
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">mail_outline</i>
                                <input class="validate" name="email" type="email" id="email">
                                <label for="email" data-error="wrong" data-success="right">Email</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">lock_outline</i>
                                <input id="password" type="password" name="password">
                                <label for="password">Password</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <button type="submit" class="btn waves-effect waves-light col s12">Đăng nhập</button>
                            </div>
                        </div>


                        <%
                            if(request.getAttribute("messLogin") != null)
                            {
                        %>
                        <style>.icon_style{
                            position: absolute;
                            right: 10px;
                            top: 10px;
                            font-size: 20px;
                            color: white;
                            cursor:pointer;
                        }</style>
                        <div class="row" id="alert_box">
                            <div class="col s12 m12">
                                <div class="card red darken-1">
                                    <div class="row">
                                        <div class="col s12 m10">
                                            <div class="card-content white-text">
                                                <p>${messLogin}</p>
                                            </div>
                                        </div>
                                        <div class="col s12 m2">
                                            <i class="material-icons icon_style" id="alert_close" aria-hidden="true">close</i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%
                            }
                        %>

                    </form>

                </div>

            <%
                }
                else {
            %>



            <h5 class="header">Thông tin cá nhân</h5>
            <div class="card">
                    <div class="card-content">
                        <p>
                            <b>Tài khoản:</b> <%=user.getName()%><br>
                            <b>ID:</b> <%=user.getId()%><br>
                            <b>Email:</b> <%=user.getEmail()%><br>
                            <b>Số điện thoại:</b> <%=user.getPhone()%><br>
                            <b>Số tiền:</b> <%=user.getBalance()%>
                        </p>
                    </div>
                    <div class="card-action">
                        <a href="transfer" class="waves-effect waves-light btn">Chuyển khoản</a>
                        <a href="logout" class="waves-effect waves-light btn">Thoát</a>
                    </div>

            </div>
            <%
                }
            %>
        </div>
        <div class="col s12 m6 l9">
            <div class="col s12 m4 3">
                <h5 class="header">Danh sách tài khoản</h5>
            </div>
            <div class="col s12 m4 4">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">search</i>
                        <input type="text" id="search" class="autocomplete">
                        <label for="search">Tìm kiếm tài khoản</label>
                    </div>
                </div>
            </div>

            <div class="col s12 m2 3">
                <a href="add" class="btn-floating waves-effect waves-light red"><i class="material-icons">add</i></a>
            </div>


<div id = "list">
<table class = "responsive-table highlight">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Balance</th>
        <th>Action</th>
    </tr>
    </thead>

<%
    ArrayList<User> results = (ArrayList<User>) request.getAttribute("items");
    for (int i =0; i < results.size(); i++) {
%>
    <tbody>
    <tr id = "<%=results.get(i).getId()%>">
        <th><%=results.get(i).getId()%></th>
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
</table></div>
</div>
    </div>
</body>


<script src="/js/jquery.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/custom.js"></script>
</html>