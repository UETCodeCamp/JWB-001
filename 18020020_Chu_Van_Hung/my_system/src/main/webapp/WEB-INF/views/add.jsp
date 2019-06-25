
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="/css/bootstrap.css" rel="stylesheet">
<title>Add member</title>
<body><div class="container">
    <center>
    <div class="w-25 p-3">
    <form method = "post" action = "add">
        <div class="form-group">
        <h3>Thêm người dùng</h3><hr><br>
        <input type = "text" class="form-control" name = "name" placeholder="Enter name"/><br>
        <input type = "text" class="form-control" name = "email" placeholder="Enter email"/><br>
        <input type = "text" class="form-control" name = "phone" placeholder="Enter phone"/><br>
        <input type = "number" class="form-control" name = "balance" placeholder="Enter balance"/><br>
        <button type="submit" class="btn btn-primary">Thêm</button>
        </div>
    </form>
    </div>
</center>
</div>
</body>


<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.js"></script>
</html>