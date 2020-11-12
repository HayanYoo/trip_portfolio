package com.green.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;

@Controller
@SessionAttributes("loginUser")
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
		
		if (vo.getUser_id() == "") {
			model.addAttribute("message", "아이디를 입력해주세요.");
			return "member/login";
		} else if (vo.getPwd() == "") {
			model.addAttribute("message", "비밀번호를 입력해주세요.");
			return "member/login";
		}
		else if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
			System.out.println(loginUser);
			return "redirect:index";
			
		} else {
			model.addAttribute("message", "아이디 또는 비밀번호가 틀렸습니다");
			return "member/login";
		}
	}
	
	@RequestMapping(value="logout")
	public String logoutAction(SessionStatus session) {
		session.setComplete();
		
		return "redirect:index";
		
	}
	
	@RequestMapping(value="contract")
	public String contractView() {
		return "member/contract";
	}
	
	@RequestMapping(value="join_form")
	public String joinFormView() {
		return "member/join_form";
	}
	
	@RequestMapping(value="id_check_form")
	public String idCheckFormView(@RequestParam(value="user_id") String user_id, Model model) {
		model.addAttribute("user_id", user_id);
		return "member/id_check_form";
	}
	
	@RequestMapping(value="id_check_form", method=RequestMethod.POST)
	public String idCheckAction(MemberVO vo, Model model) {
		MemberVO user = memberService.findMember(vo);
		if (user != null) {
			model.addAttribute("message", 1);
			model.addAttribute("user_id", vo.getUser_id());
		} else {
			model.addAttribute("message", -1);
			model.addAttribute("user_id", vo.getUser_id());
		}
		
		return "member/id_check_form";
	}
	
	@RequestMapping(value="join")
	public String joinAction(MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/index";
	}
	
	@RequestMapping(value="find_id_pwd")
	public String findIdAndPwdView() {
		return "member/findUseridAndPwd";
	}
	
	@RequestMapping(value="find_id")
	public String findIdAction(MemberVO vo, Model model) {
		MemberVO member = memberService.getMemberByNameAndEmail(vo);
		
		if(member != null) {
			model.addAttribute("member", member);
			model.addAttribute("message", 1);		
		} else {
			model.addAttribute("message", -1);
		}
		return "member/findId";
	}
	
	@RequestMapping(value="find_pwd")
	public String findPwdAction(MemberVO vo, Model model) {
		MemberVO member = memberService.getMemberByIdAndNameAndEmail(vo);
		
		if(member != null) {
			model.addAttribute("member", member);
			model.addAttribute("message", 1);		
		} else {
			model.addAttribute("message", -1);
		}
		return "member/findPwd";
	}
	
	@RequestMapping(value="change_pwd")
	public String changePwdAction(MemberVO vo, Model model) {
		memberService.changePassword(vo);
		
		return "member/successChangePwd";
	}
}
