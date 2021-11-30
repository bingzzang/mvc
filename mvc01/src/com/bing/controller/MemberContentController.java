package com.bing.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;

/**
 * Servlet implementation class MemberContentController
 */
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));

		MemberDAO dao = new MemberDAO();

		MemberVO vo = dao.getMemberContent(num);
		response.setContentType("text/html;charset=utf-8"); // mime type, printwriter 전에 해줘야 함
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='/mvc01/memberUpdate.do' method='post'>");
		out.println("<input type='hidden' name='num' value='" + vo.getNum() + "' />");
		out.println("<table border='1'>");
		out.println("<tbody>");
		if (vo != null) {
			out.println("<tr>");
			out.println("<th colspan='2'>" + vo.getNum() + ". " + vo.getName() + "의 상세보기</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>아이디</th>");
			out.println("<td>" + vo.getId() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>비밀번호</th>");
			out.println("<td>" + vo.getPass() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>이름</th>");
			out.println("<td>" + vo.getName() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>나이</th>");
			out.println("<td><input type='text' name='age' value='" + vo.getAge() + "'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>이메일</th>");
			out.println("<td><input type='text' name='email' value='" + vo.getEmail() + "'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>번호</th>");
			out.println("<td><input type='text' name='phone' value='" + vo.getPhone() + "'/></td>");
			out.println("</tr>");
			out.println("</tbody>");

		} else {
			out.println("<tr>");
			out.println("<th>일치하는 회원이 없습니다.</th>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='수정하기'/>");
		out.println("<input type='reset' value='취소'/>");
		out.println("<a href='/mvc01/memberList.do'>리스트</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
