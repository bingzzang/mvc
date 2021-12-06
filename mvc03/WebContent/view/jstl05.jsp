<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//컨르롤러 -> jsp 객체바인딩해서 넘겨줌
String[] str = {"박복수", "복대지", "김기린", "이곡길", "나왕눈", "청꼬꼬"};
request.setAttribute("str", str);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc03-jstl</title>
</head>
<body>
<c:forEach var="st" items="${str}"> <!-- 변수 -->
${st}<br/><!-- 속성 -->
</c:forEach>
</body>
</html>