<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.web.util.*"%>
<%

MyUtil my = new MyUtil();
int sum = my.hap();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
  <tr>
    <th>1-10 합</th>
    <td width="100px"><%=sum %></td>
  </tr>
  
</table>
</body>
</html>