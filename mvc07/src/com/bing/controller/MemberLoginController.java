package com.bing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;

public class MemberLoginController implements BasicController {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath();

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		// vo로 묶기
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPass(password);

		MemberDAO dao = new MemberDAO();
		String user_name = dao.memberLogin(vo);

		// user_name에 값이 있으면 성공 아니면 실패
		if (user_name != null && !"".equals(user_name)) {
			// 로그인 성공

			HttpSession session = request.getSession();
			session.setAttribute("userId", user_id);
			session.setAttribute("userName", user_name);

		} else {
			// 로그인 실패
			request.getSession().setAttribute("userId", "");
			request.getSession().setAttribute("userName", "");
			request.getSession().setAttribute("msg", "사용자 정보가 올바르지 않습니다.");
		}

		return "redirect:" + ctx + "/memberList.do";
	}

}
