<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
<h1>Spring Form Tag</h1>
<form:form modelAttribute="orderRequest" method="post" action="/springform/register">
	<table>
		<tr>
			<td>발주요청번호</td>
			<td>
				<form:input path="orderRequestNo" />
			</td>
		</tr>
		<tr>
			<td>발주요청일</td>
			<td>
				<form:input path="orderRequestDate" />
			</td>
		</tr>
		<tr>
			<td>발주품목</td>
			<td>
				<form:input path="itemNm" />
			</td>
		</tr>
	</table>
	
	<form:button name="register">등록</form:button>
</form:form>
</body>
</html>