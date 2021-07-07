<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/Add.css">
    <title>Edit customer</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function submit() {
            var customer = {
                id: $('#id').val(),
                name: $('#name').val(),
                email: $('#email').val(),
                phoneNumber: $('#phone').val(),
                password: $('#pass').val(),
                balance: $('#balance').val(),
                login: $('#login').val()
            }
            $.ajax({
                type: "POST",
                url: "/edit-customer",
                data: JSON.stringify(customer),
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    location.replace(result)
                },
                error: function (e) {
                    alert(e)
                    console.log(e);
                }
            });
        }
    </script>
</head>

<body>
    <c:set var="customer" scope="session" value="${customerInfo}" />
    <fieldset>
        <legend>Edit customer</legend>
        <input id="id" value="${customer.id}" type="hidden" />
        <label>Name:</label>
        <input id="name" placeholder="Enter name" value="${customer.name}" type="text" /> <br>
        <label>Email:</label>
        <input id="email" placeholder="Enter email" value="${customer.email}" type="text" /> <br>
        <label>Phone number:</label>
        <input id="phone" placeholder="Enter phone number" value="${customer.phoneNumber}" type="text" /> <br>
        <label>Password:</label>
        <input id="pass" placeholder="Enter password" value="${customer.password}" type="password" /> <br>
        <input id="login" value="${customer.login}" type="hidden" />
        <input id="balance" value="${customer.balance}" type="hidden" />
        <input type="submit" class="submit" value="Save" onclick="submit()">
    </fieldset>
</body>

</html>