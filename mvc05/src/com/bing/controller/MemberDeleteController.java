package com.bing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;

public class MemberDeleteController implements BasicController {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath(); // /mvc04

		int num = Integer.parseInt(request.getParameter("num"));

		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);

		String nextPage = null;

		if (cnt > 0) {
			nextPage = "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not delete");
		}

		return nextPage;
	}

}
