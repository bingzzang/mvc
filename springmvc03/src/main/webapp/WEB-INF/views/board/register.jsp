<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h2>Spring Web MVC 게시판 만들기</h2>
		<div class="panel panel-default">
			<div class="panel-heading">게시물 등록</div>
			<div class="panel-body">
				<form action="<c:url value='/register.do'/>" method="post">
					<div class="form-group">
						<label for="title">Title:</label> 
						<input type="text" class="form-control" id="title" name="title">
					</div>
					<div class="form-group">
						<label for="contents">Contents</label> 
						<textarea class="form-control" rows="3" id="contents" name="contents"></textarea>
					</div>
					<div class="form-group">
						<label for="writer">Writer:</label> 
						<input type="text" class="form-control" id="writer" name="writer">
					</div>
					
					<button type="submit" class="btn btn-default">등록</button>
					<button type="reset" class="btn btn-default">취소</button>
				</form>
			</div>
			<div class="panel-footer">made by bing</div>
		</div>
	</div>

</body>
</html>