package com.bing.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardController
 */
@WebServlet("/rd.do")
public class RedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 1. forward 실습
		// int su = 100;
		String data = "apple";
		int age = 45;
		String gender = "female";

		// view(result.jsp)로 data 전달하여 view에서 출력
		// controller -> view로 페이지 전환하는 법
		// 1. redirect
		// 2. forward
//		req.setAttribute("data", data); // 객체바인딩(request 바인딩)
		res.sendRedirect("view/result.jsp?data=" + data + "&age=" + age + "&gender=" + gender);

	}

}
