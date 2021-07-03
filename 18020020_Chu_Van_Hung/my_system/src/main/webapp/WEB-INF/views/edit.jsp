
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="/css/bootstrap.css" rel="stylesheet"/>
<title>Edit member</title>

<body>
<div class="container">
    <center>
<div class="w-25 p-3">
    <form method = "post" action = "/edit/${id}">
        <div class="form-group">
        <h3>Sửa người dùng</h3><hr><br>
        <input type = "text" class="form-control" name = "name" value="${name}"/><br>
        <input type = "text" class="form-control" name = "email" value="${email}"/><br>
        <input type = "text" class="form-control" name = "phone" value="${phone}"/><br>
        <input type = "number" class="form-control" name = "balance" value="${balance}"/><br>
        <button type="submit" class="btn btn-primary">Sửa</button>
        </div>
    </form>
</div>
</center>
</div>
</body>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.js"></script>
</html>