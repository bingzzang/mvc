package com.bing.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberVO;

/**
 * Servlet implementation class ForwardController
 */
@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "boksu";
		int age = 29;
		String email = "parkbs@abc.zzz";

		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);

		// 특정 객체에 데이터를 넣어줘야 함 -> 객체 바인딩
		request.setAttribute("vo", vo);

		// forwarding
		RequestDispatcher rd = request.getRequestDispatcher("view/forward.jsp");
		rd.forward(request, response); // 기존에 있는 request, response를 넘겨줌

	}

}
