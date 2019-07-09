<%@ page import="org.apache.catalina.util.CustomObjectInputStream" %>
<%@ page import="com.CodeCamp2019.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Confirm Page</title>
    <style type="text/css">
        h5{
            font-size: 30px;
            font-weight: bold;
            font-family: serif;
        }
        h2{

            font-weight: bold;
            font-family: sans-serif;
        }


    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<% Customer cus = (Customer) request.getAttribute("deleteCustomer");%>
<center>

    <div class="container-fluid" style="background-color: #84bb86">
        <h5 style="font-weight: bold; font-size: 30px">Do you sure remove information customer? </h5> <br> <br>
        <h5> ID: <%= cus.getId() %> </h5>
        <h5> Name: <%= cus.getName() %></h5>
        <h5> Email: <%= cus.getEmail() %></h5>
        <h5> Phone: <%= cus.getPhone() %></h5>
        <h5> Balance: <%= cus.getBalance()%></h5> <br>
        <div >
            <form action="deleteCustomer" method="post">
                <input type="hidden" name="id" value="<%= cus.getId()%>">
                <button type="submit" class="btn btn-danger" style="margin: 10px">OK</button>
            </form>
        </div>
        <div>
            <form action="cancel" method="post">
                <input type="hidden" name="id" value="<%= cus.getId()%>">
                <button type="submit" class="btn btn-secondary" style="margin: 10px">Cancel</button>
            </form>
        </div>
    </div>

</center>
</body>
</html>