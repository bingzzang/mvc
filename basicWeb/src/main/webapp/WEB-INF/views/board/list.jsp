<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script>
$(document).ready(function() {
	
	$("#btnRegister").on("click", function() {
		
		location.href = "/board/register";
		
	});
	
});
</script>
</head>
<body>
<h1>게시판</h1>
	<table class="table table-striped">
		<c:forEach var="board" items="${resultList }" varStatus="status">
			<tr>
				<td>${board.id }</td>
				<td><a href="/board/detail?id=${board.id }">${board.title }</a></td>
				<td>${board.contents }</td>			
			</tr>
		</c:forEach>
	</table>
	<button id="btnRegister">등록</button>
</body>
</html>