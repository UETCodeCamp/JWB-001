<%@ page import="com.uetcodecamp.vuvanhoc.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Wallet - Trang chủ </title>
<spring:url value="/resources/css/main.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet">
<link href="webjars/bootstrap/3.4.1/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<div class="page-header">
	<h1>MY WALLET</h1>
	<ul>
		<li><a href="/">Trang chủ </a></li>
		<li><a href="/dang-nhap">Đăng nhập </a></li>
		<li><a href="/them-nguoi-dung">Đăng ký</a></li>
	</ul>
</div>

<div class="home">
	<h3>Danh sách người dùng </h3>
	<p class="col-md-9"></p>
	<input type="text" id="myInput" placeholder="Tìm kiếm..." class="searchbar col-md-3">
	<table class="table table-hover" id="customers">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Balance</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="myTable">
		
			<%
				List<Customer> customerList= (List<Customer>) request.getAttribute("customerList");
				for (Customer c: customerList) {


			%>
			<tr id="<%=c.getId()%>">
				<td style="text-align: center"><%=c.getId()%>
				</td>
				<td><%=c.getName()%>
				</td>
				<td><%=c.getEmail()%>
				</td>
				<td><%=c.getPhone()%>
				</td>
				<td style="text-align: right"><%=c.getBalance()%>
				</td>
				<td>
					<button class="btn btn-primary" onclick="editUser(<%=c.getId()%>)">Sửa </button>
					<button class="btn btn-danger" onclick="removeUser(<%=c.getId()%>)">Xóa </button>
				</td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	<script src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script>
		$(function () {
		    // Tim kiem nguoi dung.
			$("#myInput").on("keyup", function () {
				var value = $(this).val().toLowerCase();
				$("#myTable tr").filter(function () {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
		function editUser(id) {
			$.ajax({
				url: "/sua-thong-tin",
				data:{
				    id:id
				},
				success:function () {
				    window.location = "/sua-thong-tin?id=" + id;
                }
			})
        }
        function removeUser(id) {
	        if (!confirm("Bạn muốn xóa người dùng có mã ID: " + id +"?")) return ;
            $.delete({
                url: "/xoa-nguoi-dung?id=" + id,
				type: 'DELETE',
                data:{
                    id:id
                },
                success:function () {
					$("#"+id).remove();

                }
            })
            alert("Xóa thành công người dùng có ID: " + id );
        }
	</script>

</div>
<div class="panel-footer">

</div>
</body>
</html>