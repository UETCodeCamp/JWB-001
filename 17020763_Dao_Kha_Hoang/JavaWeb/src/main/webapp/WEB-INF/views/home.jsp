<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.CodeCamp2019.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta charset="UTF-8">
        <style type="text/css">
            th{
                background-color: chartreuse;
            }</style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<div class="container-fluid" style="background-color: #b8d0b7">
    <div>
        <div class="btn btn-primary" style="margin-bottom: 15px; margin-top: 20px; margin-left: 70%; width: 10%">
            <form action="insert" method="get">
                <input type="submit" class="btn btn-primary btn-sm" value="Insert">
            </form>
        </div>

        <div class="btn btn-primary" style="margin-bottom: 15px; margin-top: 20px; margin-right: 5%; width: 10%">
            <form action="login" method="get">
                <input type="submit" class="btn btn-primary btn-sm" value="Login">
            </form>
        </div>

    </div>
    <div class="btn btn-secondary" style="margin-left: 70%">
        <form action="search" method="get">
            <input type="text" name="information" placeholder="Enter Information Search...">
            <input type="submit" class="btn btn-light" value="Search">
        </form>
    </div>
    <div>
        <table border="1"  width="100%">
            <div>
                <tr>
                    <th width="5%">ID</th>
                    <th width="30%">FullName</th>
                    <th width="25%">Email</th>
                    <th width="20%">Phone</th>
                    <th width="10%">Plance</th>
                    <th width="4%"></th>
                    <th width="6%"></th>
                </tr>
            </div>

            <c:forEach items="${customerList}" var="cus" >
                <tr>
                    <td> ${cus.id} </td>
                    <td> ${cus.name} </td>
                    <td> ${cus.email} </td>
                    <td> ${cus.phone} </td>
                    <td> ${cus.balance} </td>
                    <td>
                        <form action="replace" method="get">
                            <input type="hidden" value="${cus.id}" name="customerId">
                            <input type="submit" class="btn btn-warning" value="Edit">
                        </form>
                    </td>
                    <td>
                        <form action="delete" method="get">
                            <input type="hidden" value="${cus.id}" name="deleteID" >
                            <input type="submit" class="btn btn-danger" value="Remove">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


</body>
</html>