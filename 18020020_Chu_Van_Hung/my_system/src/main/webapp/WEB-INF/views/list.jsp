<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
            ArrayList<User> results = (ArrayList<User>) request.getAttribute("items");
            for (int i =0; i < results.size(); i++) {
        %>
        <tbody>
        <tr id = "<%=results.get(i).getId()%>">
            <th><%=results.get(i).getId()%></th>
            <td><%=results.get(i).getName()%></td>
            <td><%=results.get(i).getEmail()%></td>
            <td><%=results.get(i).getPhone()%></td>
            <td><%=results.get(i).getBalance()%></td>
            <td><a href="edit/<%=results.get(i).getId()%>" class = "btn btn-outline-primary">Sửa</a> <delete class = "delete" name="<%=results.get(i).getId()%>"><a class="btn btn-outline-danger">Xoá</a></delete> </td>
        </tr>
        </tbody>
        <%
            }
        %>
    </table>
<script src="/js/jquery.min.js"></script>
<script src="js/custom.js"></script>