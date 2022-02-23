<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script>
$(document).ready(function() {
	
	$("#btnRegister").on("click", function() {
		
		$("#formData").submit();
		
	});
	
	$("#btnList").on("click", function() {
		
		location.href = "/board/list";
		
	});
	
});
</script>
</head>
<body>
<form id="formData" method="post" action="/board/register">
게시판 id  <input type="text" id="boardId" name="id" /><br/>
게시판 제목  <input type="text" id="boardTitle" name="title" /><br/>
게시판 내용  <input type="text" id="boardContents" name="contents" />
</form>
<input type="button" id="btnRegister" value="등록"/>
<input type="button" id="btnList" value="목록"/>
</body>
</html>