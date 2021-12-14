package com.bing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;
import com.google.gson.Gson;

public class MemberAjaxListController implements BasicController {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();

		// GSON API
		Gson g = new Gson();
		String json = g.toJson(list);

		// $.ajax() --> json 응답
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().print(json);

		return null;
	}

}
