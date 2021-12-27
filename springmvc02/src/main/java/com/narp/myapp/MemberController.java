package com.narp.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.narp.mapper.MemberMapper;
import com.narp.model.MemberVO;

@Controller
public class MemberController {

//	private MembermemberMapper memberMapper;

	@Autowired
	private MemberMapper memberMapper;

	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		List<MemberVO> list = memberMapper.memberList();
		// 객체바인딩
		model.addAttribute("list", list);

		return "member/memberList";
	}

	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		// 파라미터 수집(VO)

		int cnt = memberMapper.memberInsert(vo);

		return "redirect:/memberList.do";
	}

	@RequestMapping("/memberRegister.do")
	public String memberRegister() {

		return "member/memberRegister";
	}

	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam("num") int num) {

		int cnt = memberMapper.memberDelete(num);

		return "redirect:/memberList.do";
	}

	@RequestMapping("/memberContent.do")
	public String memberContent(@RequestParam("num") int num, Model model) {

		MemberVO vo = memberMapper.memberContent(num);

		// 객체 바인딩
		model.addAttribute("vo", vo);

		return "member/memberContent";
	}

	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {

		int cnt = memberMapper.memberUpdate(vo);

		return "redirect:/memberList.do";
	}

	@RequestMapping("/memberAjaxList.do")
	public @ResponseBody List<MemberVO> memberAjaxList(MemberVO vo) {

		List<MemberVO> list = memberMapper.memberList();
		// $.ajax() -> callback 함수로 응답 -> json

		return list; // object -> json : @ResponseBody -> API (jackson-databind)
	}
}
