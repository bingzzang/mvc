package com.bing.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 클라이언트의 요청받기(memberList.do)
		// 2. 전체 회원리스트 가져오기
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.getMemberList();

		// 3. 회원 전체리스트를 html로 만들어서 응답하기
		// 한글이 있는경우 인코딩 해주어야 함
		response.setContentType("text/html;charset=utf-8"); // mime type, printwriter 전에 해줘야 함
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>번호</th>");
		out.println("<th>아이디</th>");
		out.println("<th>비밀번호</th>");
		out.println("<th>이름</th>");
		out.println("<th>나이</th>");
		out.println("<th>이메일</th>");
		out.println("<th>전화번호</th>");
		out.println("<th>삭제</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for (MemberVO vo : list) {

			out.println("<tr>");
			out.println("<td>" + vo.getNum() + "</td>");
			out.println("<td><a href='/mvc01/memberContent.do?num=" + vo.getNum() + "'>" + vo.getId() + "</td>");
			out.println("<td>" + vo.getPass() + "</td>");
			out.println("<td>" + vo.getName() + "</td>");
			out.println("<td>" + vo.getAge() + "</td>");
			out.println("<td>" + vo.getEmail() + "</td>");
			out.println("<td>" + vo.getPhone() + "</td>");
			out.println("<td><a href='/mvc01/memberDelete.do?num=" + vo.getNum() + "'>삭제</td>"); // get방식 -> QueryString
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("<tr>");
		out.println("<td colspan='8'>");
		out.println("<a href='member/memberRegister.html'>회원가입</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
