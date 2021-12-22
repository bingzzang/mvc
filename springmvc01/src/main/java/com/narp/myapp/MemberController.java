package com.narp.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.narp.model.MemberDAO;
import com.narp.model.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;

	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		List<MemberVO> list = dao.memberList();
		// 객체바인딩
		model.addAttribute("list", list);

		return "member/memberList";
	}

	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		// 파라미터 수집(VO)

		int cnt = dao.memberInsert(vo);

		return "redirect:/memberList.do";
	}

	@RequestMapping("/memberRegister.do")
	public String memberRegister() {

		return "member/memberRegister";
	}

	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam("num") int num) {

		int cnt = dao.memberDelete(num);

		return "redirect:/memberList.do";
	}

	@RequestMapping("/memberContent.do")
	public String memberContent(@RequestParam("num") int num, Model model) {

		MemberVO vo = dao.getMemberContent(num);

		// 객체 바인딩
		model.addAttribute("vo", vo);

		return "member/memberContent";
	}

	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {

		int cnt = dao.updateMember(vo);

		return "redirect:/memberList.do";
	}
}
