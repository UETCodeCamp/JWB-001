<<<<<<< HEAD

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="/css/bootstrap.css" rel="stylesheet">
<title>Profile</title>

<body>
<div class="container">
<br>
<center>
    <div class="w-25 p-3">
        <form action = "transfer">
            <div class="form-group">
        <h3>Thông tin tài khoản</h3><hr>
        <p>Tên: ${session.getName()} </p>
        <p>Email: ${session.getEmail()} </p>
        <p>Phone: ${session.getPhone()} </p>
        <p>Số dư khả dụng: ${session.getBalance()} </p>
                <button type="submit" class="btn btn-primary">Chuyển tiền</button>
            </div>
        </form>
    </div>
</center>
</div>
</body>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.js"></script>

=======

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Profile</title>
<style>
    form {
        border: 3px solid #f1f1f1;
        width: 21%;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        /* width: 10%;*/
    }

    /* Add a hover effect for buttons */
    button:hover {
        opacity: 0.8;
    }
    hr{
        border-color: aqua;
    }
    p{
        text-align: left;
        margin-left: 10px;
    }

</style>
<body>
<br>
<center>
    <form action = "transfer">
        <h3>Thông tin tài khoản</h3><hr>
        <p>Tên: ${session.getName()} </p>
        <p>Email: ${session.getEmail()} </p>
        <p>Phone: ${session.getPhone()} </p>
        <p>Số dư khả dụng: ${session.getBalance()} </p>
        <button type="submit">Chuyển tiền</button>
    </form>
</center>
</body>
>>>>>>> 7834ff41e7663548ff48a128c22048c0cb26cf7a
</html>