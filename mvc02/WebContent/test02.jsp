<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bing.model.*"%>
<%
	MyCalc mc = new MyCalc();
	int v = mc.hap(1, 30);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc02-두 수의 합</title>
</head>
<body>
	<table>
		<tr>
			<td>1-30까지의 총합</td>
			<td><%=v %></td>
		</tr>
	</table>
</body>
</html>