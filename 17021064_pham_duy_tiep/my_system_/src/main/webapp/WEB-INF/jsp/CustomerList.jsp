<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer list</title>
    <style>
        #CustomerList {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #CustomerList td, #CustomerList th {
            border: 1px solid #ddd;
            padding: 5px;
            text-align: center;
        }
        #CustomerList tr:nth-child(even){background-color: #f2f2f2;}
        #CustomerList tr:hover {background-color: #ddd;}
        #CustomerList th {
            padding-top: 9px;
            padding-bottom: 9px;
            text-align: center;
            background-color: #4253fe;
            color: white;
        }
        #CustomerList td:last-child{
            text-align: center;
        }
        .button {
            background-color: #4253fe;
            border: none;
            color: white;
            padding: 12px 28px;
            font-size: 16px;
            margin-bottom: 19px;
            border-radius: 5px;
            cursor: pointer;
            outline: none;
        }
        .button:hover {
            background-color: #104f66;
            color: white;
        }
    </style>
</head>
<body>
<div>
    <button class = "button" type="button" onclick="location.href = '/Add-customer'">New Customer</button>
    <button class = "button" type="button" onclick="location.href = '/Login-customer'">Login</button>
    <table id="CustomerList">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Balance</th>
            <th colspan="2">Option</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="Customer" items="${CustomerList}">
            <tr>
                <td>${Customer.id}</td>
                <td>${Customer.name}</td>
                <td>${Customer.email}</td>
                <td>${Customer.phone}</td>
                <td>${Customer.balance}</td>
                <td>
                    <form action="/Edit-customer" method="GET">
                        <input type="hidden" value="${Customer.id}" name="CustomerId">
                        <input class="button" type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="/Delete-customer" method="GET">
                        <input type="hidden" value="${Customer.id}" name="CustomerId">
                        <input class="button" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>