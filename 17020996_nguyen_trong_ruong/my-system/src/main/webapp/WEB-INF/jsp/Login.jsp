<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/Login.css">
        <title>Login</title>
    </head>
    <body>
            <form action="/login" method="POST">
            <fieldset>
                <legend>Login</legend>
                <label>Email:</label> <br>
                <input name = id value="${customerInfo.id}" type="hidden"/> <br>
                <lable>Password:</lable>
                <input name = pw placeholder="Enter password" type="password"/> <br>
                <input type="submit" class="submit" value="Login">
            </fieldset>
        </form>
    </body>
</html>