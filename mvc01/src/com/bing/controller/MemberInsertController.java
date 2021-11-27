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
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글깨짐 방지

		// 1. 파라미터 수집(VO)
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("pass"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		// 파라미터수집(VO)
		MemberVO vo = new MemberVO();

		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);

//		System.out.println(vo.toString());

		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);

		PrintWriter out = resp.getWriter();

		if (cnt > 0) {
			out.println("insert success");
		} else {
			// 가입실패 -> 예외객체를 만들어서 was에 던지기
			throw new ServletException("can't insert");
		}

	}

}
