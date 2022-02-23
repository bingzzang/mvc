<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>
<h1>수정화면</h1>
<form id="" method="post" action="/board/modify">
	<table class="table table-striped">
		<tr>
			<td>id</td>
			<td>제목</td>
			<td>내용</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="id" value="${resultData.id }" readonly/>
			</td>
			<td>
				<input type="text" name="title" value="${resultData.title }" />
			</td>
			<td>
				<input type="text" name="contents" value="${resultData.contents }" />
			</td>
		</tr>
	</table>
	<input type="submit" value="수정" />
</form>
</body>
</html>