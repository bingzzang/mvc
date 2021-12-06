<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bing.model.*"%>
<%@ page import="java.util.*"%>
<%
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<script type="text/javascript">
  function deleteFn(num){
	  location.href="memberDelete.do?num="+num; // ?num=12
  }
</script>
</head>
<body>
<h3>mvc03 회원리스트</h3>
	<table class="table table-bordered">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>나이</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>삭제</td>
		</tr>
		<%
			for (MemberVO vo : list) {
		%>
		<tr>
			<td><%=vo.getNum()%></td>
			<td><a href="/mvc03/memberContent.do?num=<%=vo.getNum()%>"><%=vo.getId()%></a></td>
			<td><%=vo.getPass()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getAge()%></td>
			<td><%=vo.getEmail()%></td>
			<td><%=vo.getPhone()%></td>
			<td><input type="button" value="삭제" class="btn btn-warning"
				onclick="deleteFn(<%=vo.getNum()%>)"></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="8" align="right"><input type="button" value="회원가입"
				class="btn btn-primary"
				onclick="location.href='member/memberRegister.html'" /></td>
		</tr>
	</table>
</body>
</html>
