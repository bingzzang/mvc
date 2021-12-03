<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.bing.model.*" %>
<%	
		request.setCharacterEncoding("utf-8");
		//파라미터 수집(VO)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		// 파라미터수집(VO)
		MemberVO vo = new MemberVO();

		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);

		if (cnt > 0) {
			response.sendRedirect("memberList.jsp"); // 응답을 다른페이지로 : redirect

		} else {
			// 가입실패 -> 예외객체를 만들어서 was에 던지기
			throw new ServletException("can't insert");
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>