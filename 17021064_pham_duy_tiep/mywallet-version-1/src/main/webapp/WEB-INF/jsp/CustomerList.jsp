<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer list</title>
</head>
<body>
    <table id="CustomerList">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Balance</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="Customer" items="${customer}">
            <tr>
                <td>${Customer.Id}</td>
                <td>${Customer.Name}</td>
                <td>${Customer.Email}</td>
                <td>${Customer.Phone}</td>
                <td>${Customer.Balance}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>