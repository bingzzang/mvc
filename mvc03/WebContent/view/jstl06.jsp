<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//컨르롤러 -> jsp 객체바인딩해서 넘겨줌
List<String> list = new ArrayList<String>();
list.add("박복수");
list.add("복대지");
list.add("김기린");
list.add("이곡길");
list.add("나왕눈");
list.add("청꼬꼬");
request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc03-jstl</title>
</head>
<body>
<c:forEach var="st" items="${list}"> <!-- 변수 -->
${st}<br/><!-- 속성 -->
</c:forEach>
</body>
</html>