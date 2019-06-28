<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <table class = "responsive-table highlight">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Balance</th>
            <th>Action</th>
        </tr>
        </thead>

        <%
            ArrayList<User> lstItems = (ArrayList<User>) request.getAttribute("items");
            for (int i =0; i < lstItems.size(); i++) {
        %>
        <tbody>
        <tr id = "<%=lstItems.get(i).getId()%>">
            <th scope="row"><%=lstItems.get(i).getId()%></th>
            <td><%=lstItems.get(i).getName()%></td>
            <td><%=lstItems.get(i).getEmail()%></td>
            <td><%=lstItems.get(i).getPhone()%></td>
            <td><%=lstItems.get(i).getBalance()%></td>
            <td><a href="edit/<%=lstItems.get(i).getId()%>" class = "btn btn-outline-primary">Sửa</a> <delete class = "delete" name="<%=lstItems.get(i).getId()%>"><a class="btn btn-outline-danger">Xoá</a></delete> </td>
        </tr>
        </tbody>
        <%
            }
        %>
<script src="/js/jquery.min.js"></script>
<script src="js/custom.js"></script>
</html>