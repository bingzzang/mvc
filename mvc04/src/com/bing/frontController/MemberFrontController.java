package com.bing.frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// client가 어떤 요청을 했는지 파악하기
		String url = request.getRequestURI(); // request에서 클라이언트가 요청 uri 얻어오기
//		System.out.println(url);
		String ctx = request.getContextPath();
//		System.out.println(ctx);

		// 실제로 요청한 명령이 무엇인지 파악
		String command = url.substring(ctx.length());
//		System.out.println(command);

		// 요청에 따른 분기 작업
		if (command.equals("/memberList.do")) { // 회원리스트 보기
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.getMemberList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
		} else if (command.equals("/memberInsert.do")) { // 회원가입

		} else if (command.equals("/memberRegister.do")) { // 회원가입화면

		} else if (command.equals("/memberContent.do")) {

		} else if (command.equals("/memberUpdate.do")) {

		} else if (command.equals("/memberDelete.do")) {

		}

	}

}
