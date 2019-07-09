<%@ page import="java.util.ArrayList" %>
<%@ page import="com.CodeCamp2019.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Replace Page</title>
    <style>
        input{
            width: 90%;
            padding: 10px;
            margin: 5px;
            border-radius: 10px;
        }
        button{
            font-size: 20px;
            background-color: blue;
            margin: 15px;
            width: 15%;
            height: 30px;
        }
    </style>
</head>
<body>
    <% Customer customer = (Customer) request.getAttribute("customer1"); %>
    <% //Integer id = (Integer) request.getAttribute("customerId"); %>
<center>
        <form action="/replaceCus" method="post">
            <input type="hidden" name="id" value="<%=customer.getId() %> "> <br>
            <input type="text" name="name" placeholder="FullName" value="<%= customer.getName() %>" > <br>
            <input type="text" name="email" placeholder="Email" value="<%= customer.getEmail() %>"> <br>
            <input type="text" name="phone" maxlength="10" placeholder="SDT" value="<%= customer.getPhone() %>"> <br>
            <input type="number" name="balance" placeholder="Balance" value="<%= customer.getBalance() %>"> <br><br><br>
            <button type="submit"> Replace </button> <br>
        </form>

</center>

</body>
</html>