<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>요청에 대한 실습</h1>
	<a href="regist?boardId=20220222001&boardContent=Good day&boardWriter=bing">전송</a>
<%-- 	<a href="regist?boardId=${boardId}&boardContent=${boardContent}&boardWriter=${boardWriter}">전송</a> --%>

	<form action="/test/request/registVO" method="get">
		<label>구매요청번호 : </label>
		<input type="text" name="purchaseRequestNo" value="20220222001" /><br/>
		<label>구매요청일자 : </label>
		<input type="text" name="purchaseRequestDate" value="20220222" /><br/>
		<label>구매품목 : </label>
		<input type="text" name="purchaseRequestItem" value="돼지 삼겹살 20KG" /><br/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>