package com.bing.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.controller.BasicController;
import com.bing.controller.MemberContentController;
import com.bing.controller.MemberDeleteController;
import com.bing.controller.MemberInsertController;
import com.bing.controller.MemberListController;
import com.bing.controller.MemberLoginController;
import com.bing.controller.MemberRegisterController;
import com.bing.controller.MemberUpdateController;

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

		request.setCharacterEncoding("UTF-8");

		// client가 어떤 요청을 했는지 파악하기
		String url = request.getRequestURI(); // request에서 클라이언트가 요청 uri 얻어오기
		System.out.println(url);
		String ctx = request.getContextPath();
//		System.out.println(ctx);

		// 실제로 요청한 명령이 무엇인지 파악
		String command = url.substring(ctx.length());
//		System.out.println(command);

		// 요청에 따른 분기 작업
		BasicController ctr = null;

		String nextPage = null;

		// 핸들러 매핑 -> HandlerMapping
		if (command.equals("/memberList.do")) { // 회원리스트 보기
			ctr = new MemberListController();
			nextPage = ctr.requestHandler(request, response);
		} else if (command.equals("/memberInsert.do")) { // 회원가입
			ctr = new MemberInsertController();
			nextPage = ctr.requestHandler(request, response);
		} else if (command.equals("/memberRegister.do")) { // 회원가입화면
			ctr = new MemberRegisterController();
			nextPage = ctr.requestHandler(request, response);
		} else if (command.equals("/memberContent.do")) {
			ctr = new MemberContentController();
			nextPage = ctr.requestHandler(request, response);

		} else if (command.equals("/memberUpdate.do")) {
			ctr = new MemberUpdateController();
			nextPage = ctr.requestHandler(request, response);
		} else if (command.equals("/memberDelete.do")) {
			ctr = new MemberDeleteController();
			nextPage = ctr.requestHandler(request, response);
		} else if (command.equals("/memberLogin.do")) {
			ctr = new MemberLoginController();
			nextPage = ctr.requestHandler(request, response);
		}

		// forward, redirect
		if (nextPage != null) {
			if (nextPage.indexOf("redirect:") != -1) {
				// redirect:/MVC04/memberList.do
				response.sendRedirect(nextPage.split(":")[1]); // redirect
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage)); // forward
				rd.forward(request, response);
			}
		}

	}

}
