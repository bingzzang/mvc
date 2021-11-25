package com.bing.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// controller 역할

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 클라이언트에서 넘어오는 폼 파라메터를 받기(파라메터 수집 : su1, su2)
		int su1 = Integer.parseInt(request.getParameter("su1")); // getParameter : return 타입이 String
		int su2 = Integer.parseInt(request.getParameter("su2"));

		// su1~su2
		int sum = 0;
		for (int i = su1; i <= su2; i++) {
			sum += i;
		}

		// 응답
		PrintWriter out = response.getWriter();
		out.println("total : " + sum);
	}

}
