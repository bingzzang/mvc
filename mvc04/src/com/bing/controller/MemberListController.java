package com.bing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;

public class MemberListController implements BasicController {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// pojo가 해야할 일의 범위

		// 1. model연동
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.getMemberList();

		// 2. 객체 바인딩
		request.setAttribute("list", list);

		// 3. 다음페이지 정보(view)
		return "memberList";
	}

}
