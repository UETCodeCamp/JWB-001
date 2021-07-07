<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/Add.css">
    <title>Add customer</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function submit() {
            var customer = {
                id: null,
                name: $('#name').val(),
                email: $('#email').val(),
                phoneNumber: $('#phone').val(),
                password: $('#pass').val(),
                balance: $('#balance').val(),
                login: 1
            }
            $.ajax({
                type: "POST",
                url: "/add-customer",
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
    <fieldset>
        <legend>Add customer</legend>
        <label>Name:</label>
        <input id="name" placeholder="Enter name" type="text"/> <br>
        <label>Email:</label>
        <input id="email" placeholder="Enter email" type="text"/> <br>
        <label>Phone number:</label>
        <input id="phone" placeholder="Enter phone number" type="text"/> <br>
        <label>Password:</label>
        <input id="pass" placeholder="Enter password" type="password"/> <br>
        <label>Balance:</label>
        <input id="balance" placeholder="Enter balance" type="number"/> <br>
        <p id="notification"></p>
        <input type="submit" class="submit" value="Save" onclick="submit()">
    </fieldset>
</body>

</html>