<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc03-jstl</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" step="1">
<font size="${i}">야호<br/></font>
</c:forEach>
</body>
</html>