package com.green.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.green.biz.member.MemberVO;
import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;
import com.green.biz.schedule.ScheduleService;
import com.green.biz.schedule.SelectedVO;

@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("insert_product")
	public String insertProductAction(SelectedVO vo, HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setUser_id(loginUser.getUser_id());
			
			
			List<SelectedVO> selectedList = scheduleService.selectSelected(loginUser.getUser_id());
			
			// 중복된 상품이 들어오지 않도록 함
			for (SelectedVO selected : selectedList) {
				if(selected.getPseq() == vo.getPseq()){
					return "redirect:/product_list";
				}

			}
			
			scheduleService.insertSelected(vo);
			return "redirect:/product_list";
		}
		
		
	}

}
