package com.bing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 클라이언트의 요청을 받는작업 -> 파라미터 수집(vo)
		// 4개의 파라미터
		int num = Integer.parseInt(req.getParameter("num"));
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);

		// 모델 객체 연결
		MemberDAO dao = new MemberDAO();

		int cnt = dao.updateMember(vo);

		if (cnt > 0) {
			resp.sendRedirect("/mvc03/memberList.do");
		} else {
			throw new ServletException("fail to update");
		}
	}
}
