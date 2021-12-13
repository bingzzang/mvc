package com.bing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements BasicController {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션을 가져와서 세션을 제거
		// 세션을 제거하는법
		// 1. 강제
		String ctx = request.getContextPath();

		request.getSession().invalidate();
		// 2. 브랑우저 종료(JSESSIONID 브라우저쿠키에 저장)
		// 3. 세션이 종료될때까지 기다리는것

		return "redirect:" + ctx + "/memberList.do";
	}

}
