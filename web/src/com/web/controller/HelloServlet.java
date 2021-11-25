package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;		//web용 api
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.util.MyUtil;

@WebServlet("/hs.do")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		//1-100까지의 합
		MyUtil my = new MyUtil();
		
		int sum = my.hap();

		//출력스트림 -> 요청한 클라이언트에게 응답
		PrintWriter out = resp.getWriter();		//요청한 클라이언트와 연결된 빨대, out을 통해 http를 내려보냄
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
	}

	
}
