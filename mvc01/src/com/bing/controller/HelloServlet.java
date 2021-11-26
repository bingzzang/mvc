package com.bing.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/h.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 클라이언트의 요청을 받는 작업(파라미터 수집)
		// 2. 처리하는 작업(비즈니스 로직)
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		// 3. 요청한 클라이언트에게 응답하는 작업(프리젠테이션 로직) -> view(jsp)
		PrintWriter out = resp.getWriter(); // 요청한 클라이언트와 연결된 빨대, out을 통해 http를 내려보냄
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
	}

}
