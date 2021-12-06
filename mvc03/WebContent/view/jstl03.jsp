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
<c:choose>
	<c:when test="${cnt%2==0}">
		짝수
	</c:when>
	<c:when test="${cnt%2!=0}">
		홀수
	</c:when>
	<c:otherwise>
		일치하지 when 절이 없는 경우에 실행
	</c:otherwise>
</c:choose>
</body>
</html>