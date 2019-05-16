<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/Add.css">
        <title>Edit customer</title>
    </head>
    <body>
        <form:form action="/edit-customer" method="POST" modelAttribute="customerInfo">
            <fieldset>
                <legend>Edit customer</legend>
                <label>Name:</label>
                <form:input path = "name" placeholder="Enter name" type="text"/> <br>
                <label>Email:</label>
                <form:input path = "email" placeholder="Enter email" type="text"/> <br>
                <label>Phone number:</label>
                <form:input path = "phoneNumber" placeholder="Enter phone number" type="text"/> <br>
                <label>Password:</label>
                <form:input path = "password" placeholder="Enter password" type="password"/> <br>
                <input type="submit" class="submit" value="Save">
            </fieldset>
        </form:form>
    </body>
</html>