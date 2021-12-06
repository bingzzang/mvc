<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cnt" value="7"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc03-jstl</title>
</head>
<body>
<!-- 조건 -->
<c:if test="${cnt%2==0}">
짝수
</c:if>
<c:if test="${cnt%2!=0}">
홀수
</c:if>
</body>
</html>