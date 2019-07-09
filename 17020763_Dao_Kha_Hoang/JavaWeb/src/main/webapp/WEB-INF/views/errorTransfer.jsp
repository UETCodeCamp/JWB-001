<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Error Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <center>
        <h3 style="font-weight: bold"> So du khong kha dung!</h3>
        <form action="transfer" method="get">
            <button type="submit" class="btn btn-danger">Transfer</button>
        </form>
        <br> <br>
        <form action="/" method="get">
            <input type="submit" class="btn btn-success" value="Home">
        </form>
    </center>
</body>
</html>