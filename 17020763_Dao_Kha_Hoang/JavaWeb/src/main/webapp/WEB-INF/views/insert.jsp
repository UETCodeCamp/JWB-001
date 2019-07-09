<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Page</title>
    <meta charset="utf-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<center>
    <div class="container" style="background-color: #b0ecea">
        <br><h3 style="font-size: 50px; margin: 10px; font-weight: bold; font-family: sans-serif; "> ADD USER</h3>
        <form action="/add" method="post">
            <div class="form-group">
                <input type="number" class="form-control" style="width: 40%" name="id" placeholder="ID">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" style="width: 40%" name="fullname" placeholder="FullName">
            </div>
            <div class="form-group">
                <input type="text" class="form-control " style="width: 40%" name="email" placeholder="Email">
            </div>
            <div class="form-group">
                <input type="text" class="form-control " style="width: 40%" name="phone" maxlength="10" placeholder="SDT">
            </div>
            <div class="form-group">
                <input type="number" class="form-control" style="width: 40%" name="balance" placeholder="Balance"> <br>
            </div>
            <button type="submit" class="btn btn-success btn-lg" style="margin: 10px"> Add User</button> <br>
        </form>
    </div>
</center>
</body>
</html>