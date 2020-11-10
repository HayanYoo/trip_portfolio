package com.green.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("login_form")
	public String loginView() {
		return "member/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginAction(MemberVO vo, Model model) {
		MemberVO loginUser = memberService.getMember(vo);
		
		if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
			return "redirect:index";
		} else {
			model.addAttribute("message", "아이디 또는 비밀번호가 틀렸습니다");
			return "member/login";
		}
	}
	
	@RequestMapping(value="contract")
	public String contractView() {
		return "member/contract";
	}
	
	
}
