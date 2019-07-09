<%@ page import="com.CodeCamp2019.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

    <center>
        <div class="container" style="background-color: yellow">
            <h3 style="font-weight: bold"> LogIn</h3>

            <form action="/login" method="post">
                <div class="form-group">
                    <input type="text" class="form-group" style="width: 40%" name="username" placeholder="Enter Email">
                </div>

                <div class="form-group">
                    <input type="password" class="form-group" style="width: 40%" name="password" placeholder="Enter Password"> <br>
                </div>
                <input type="submit" class="btn btn-primary" style="margin: 10px" value="Login">
            </form>
        </div>
    </center>
</body>
</html>