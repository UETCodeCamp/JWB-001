<%@ page import="com.CodeCamp2019.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Transfer Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <% Integer id = (Integer) request.getAttribute("id"); %>
    <center>
        <div class="container-fluid" style="background-color: blueviolet">
            <h5 style="font-weight: bold; font-size: 50px"> Transfers </h5>
            <div class="form-group">
                <form action="transferToID" method="post">
                    <input type="hidden" value="<%= id %>" name="fromId">

                    <div class="form-group">
                        <h5> <input type="number" name="id" placeholder="ID"></h5> <br>
                    </div>
                    <div class="form-group">
                        <h5> <input type="number" name="amount" placeholder="Amount"></h5> <br>
                    </div>
                    <input type="submit" class="btn btn-warning" value="Continue">
                </form>
            </div>
        </div>
    </center>

</body>
</html>