<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Customer list</title>
    <link rel="stylesheet" type="text/css" href="css/CustomerList.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function del(r, id) {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById("customerTable").deleteRow(i);
            $.post("/delete", {
                id
            });
        }

        $(document).ready(function () {
            $("#search").keyup(function () {
                var info = $("#search").val();
                if (info != "") {
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "/search",
                        data: JSON.stringify(info),
                        dataType: 'json',
                        success: function (result) {
                            $("#searchResult").empty();
                            $("#searchResult").append(result)
                        },
                        error: function (e) {
                            alert("Error!" + e)
                            console.log(e);
                        }
                    });
                } else {
                    $("#searchResult").empty();
                }
            })
        })
    </script>
</head>

<body>
    <div>
        <input type="text" placeholder="search.." id="search">
        <table id=searchResult></table>
    </div>
    <div>
        <table id="customerTable">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Balance</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.balance}</td>
                        <c:if test="${customer.login == 1}">
                            <td>
                                <form action="/editing-form" method="GET">
                                    <input type="hidden" value="${customer.id}" name="customerId">
                                    <input type="submit" value="Edit">
                                </form>

                                <form action="/transfering-form" method="GET">
                                    <input type="hidden" value="${customer.id}" name="customerId">
                                    <input type="hidden" value="${customer.balance}" name="availableBalance">
                                    <input type="submit" value="Transfer">
                                </form>

                                <form action="/logout" method="GET">
                                    <input type="hidden" value="${customer.id}" name="customerId">
                                    <input type="submit" value="Logout">
                                </form>
                                <input class="dlt" type="button" value="Delete" onclick="del(this,'${customer.id}')">
                            </td>
                        </c:if>
                        <c:if test="${customer.login == 0}">
                            <td>
                                <form action="/login-form" method="GET">
                                    <input type="hidden" value="${customer.id}" name="customerId">
                                    <input type="submit" value="Login">
                                </form>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                <td><button id=add type="button" onclick="location.href = '/adding-form'">Add</button></td>
            </tbody>
        </table>
    </div>
</body>

</html>