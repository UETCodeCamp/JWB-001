<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/Add.css">
    <title>Add customer</title>
</head>

<body>
    <div id="fSet">
        <fieldset>
            <legend>Add customer</legend>
            <form:form id="addForm" action="/add-customer" method="POST" modelAttribute="customerInfo">
                <label>Name:</label>
                <form:input path="name" placeholder="Enter name" type="text" /> <br>
                <label>Email:</label>
                <form:input path="email" placeholder="Enter email" type="text" /> <br>
                <label>Phone number:</label>
                <form:input path="phoneNumber" placeholder="Enter phone number" type="text" /> <br>
                <label>Balance:</label>
                <form:input path="balance" placeholder="Enter balance" type="number" min = "0" /> <br>
                <input type="submit" class="submit" value="Add">
            </form:form>
        </fieldset>
    </div>
</body>

</html>