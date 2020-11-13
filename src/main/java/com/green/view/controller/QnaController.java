package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.member.MemberVO;
import com.green.biz.qna.QnaService;
import com.green.biz.qna.QnaVO;

@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="qna_list")
	public String qnaListView(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "member/login";
		} else {
			List<QnaVO> qnaList = qnaService.qnaList(loginUser.getUser_id());
			model.addAttribute("qnaList", qnaList);
			return "qna/qnaList";
		}
	}
	
	@RequestMapping(value="qna_form")
	public String qnaFormView(){
		return "qna/qnaForm";
	}
	
	@RequestMapping(value="insert_qna")
	public String insertQnaAction(QnaVO vo) {
		qnaService.insertQna(vo);
		
		return "redirect:/qna_list";
	}
	
	@RequestMapping("qna_detail")
	public String qnaDetailView(@RequestParam(value="qseq") int qseq, Model model) {
		QnaVO qna = qnaService.selectQnaByQseq(qseq);
		
		model.addAttribute("qna", qna);
		return "qna/qnaDetail";
		
	}
	
	@RequestMapping("delete_qna")
	public String deleteQnaAction(@RequestParam(value="qseq") int qseq) {
		qnaService.deleteQna(qseq);
		return "redirect:/qna_list";
	}
	

}
