<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/Transfer.css">
        <title>Transfer</title>
    </head>
    <body>
        <form action="/transfer" method="POST">
            <fieldset>
                <legend>Transfer</legend>
                <label>Sent Id: ${customerId}</label><br>
                <label>Available: ${balance}$</label><br>
                <label>Received Id:</label>
                <input name = receivedId placeholder="Enter receiver's ID" type="number" required/> <br>
                <input type="hidden" value="${customerId}" name="sentId">
                <label>Amount:</label>
                <input name = amount placeholder="Enter amount" type="number" min="0" required/> <br>
                <input type="submit" class="submit" value="Confirm">
            </fieldset>
        </form>
    </body>
</html>