package com.green.view.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.biz.condition.ConditionVO;
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
	
	@RequestMapping("delete_selected")
	public String deleteSelectedAction(SelectedVO vo) {
		scheduleService.delete_selected(vo);
		
		return "redirect:/product_list";
	}

	@RequestMapping("make_trip")
	public String makeTripAction(ConditionVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setUser_id(loginUser.getUser_id());
				
			HashSet<ProductVO> makeTrip = new HashSet<>();
			List<ProductVO> randomProduct = new ArrayList<>();
			
			int selectedTotalPrice = 0;	
			int origin_minoption = vo.getMinoption();
			int origin_maxoption = vo.getMaxoption();

			boolean temp = true;
			while(temp) {
				// 값 초기화
				vo.setMinoption(origin_minoption);
				vo.setMaxoption(origin_maxoption);
				selectedTotalPrice = 0;	
				makeTrip.clear();
				
				// selected된 상품들을 가져옴
				List<SelectedVO> selectedList = scheduleService.selectSelected(loginUser.getUser_id());
				System.out.println(selectedList);
				
				for (SelectedVO selected : selectedList) {
					// hashset에 selected 상품정보들을 저장함.
					makeTrip.add(productService.getProduct(selected.getPseq()));
				}
				System.out.println(" 첫번째 makeTrip.size : " + makeTrip.size());
				// 원하는 옵션수에서 selected된 옵션 수만큼 빼줌
				vo.setMaxoption(vo.getMaxoption() - makeTrip.size());
				vo.setMinoption(vo.getMinoption() - makeTrip.size());
				System.out.println("vo.getMaxoption() : " + vo.getMaxoption());
				System.out.println("vo.getMinoption() : " + vo.getMinoption());
				// 옵션 수만큼 랜덤하게 상품을 검색해옴
				System.out.println(vo);
				randomProduct  = productService.randomProductByNum(vo);
				
				// hashset에 랜덤 옵션에 대한 상품정보들을 추가저장함
				for (ProductVO random : randomProduct) {
					makeTrip.add(random);
				}
				
				// 선택된 옵션의 총 비용을 계산		
				for (ProductVO product : makeTrip) {
					selectedTotalPrice += vo.getAdult()*product.getAprice() + vo.getKid()*product.getKprice();
				}
				System.out.println("두번째 : " + makeTrip.size());
				System.out.println("totalPrice" + selectedTotalPrice);
				if(selectedTotalPrice >= vo.getMinbudget() && selectedTotalPrice <= vo.getMaxoption()) {
					if(makeTrip.size() >= origin_minoption && makeTrip.size() <= origin_maxoption) {
						temp = false;
						break;
					}
				}		
			}
			
			model.addAttribute("makeTrip", makeTrip);
			model.addAttribute("selectedTotalPrice", selectedTotalPrice);
			model.addAttribute("randomProduct", randomProduct);
			model.addAttribute("condition", vo);
			return "product/makeTrip";
		
		}
	}
}
