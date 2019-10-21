<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>编辑</h1>
<form action="/api/updateEquipment" name="eForm" method="post">
    <input type="hidden" name="e_id" value="${equipment.e_id}">
    名称：<input type="text" name="name" value="${equipment.name}">
    <input type="submit" value="编辑" >
</form>
</body>
</html>