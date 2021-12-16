package com.bing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bing.model.MemberDAO;
import com.bing.model.MemberVO;

public class MemberInsertController implements BasicController {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath(); // /mvc04

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		MemberVO vo = new MemberVO();

		if (request.getParameter("mode").equals("fadd")) {
			String filename = request.getParameter("filename");
			vo.setFilename(filename);
		}

		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);

		MemberDAO dao = new MemberDAO();
		int cnt = -1;

		if (request.getParameter("mode").equals("fadd")) {
			cnt = dao.memberInsertFile(vo); // 파일 이름을 저장해야하는 경우
		} else {
			cnt = dao.memberInsert(vo);
		}

		String nextPage = null;

		if (cnt > 0) {
			nextPage = "redirect:" + ctx + "/memberList.do";
		} else {
			// 가입실패 -> 예외객체를 만들어서 was에 던지기
			throw new ServletException("can't insert");
		}
		return nextPage;
	}

}
