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
			
			// �ߺ��� ��ǰ�� ������ �ʵ��� ��
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
				// �� �ʱ�ȭ
				vo.setMinoption(origin_minoption);
				vo.setMaxoption(origin_maxoption);
				selectedTotalPrice = 0;	
				makeTrip.clear();
				
				// selected�� ��ǰ���� ������
				List<SelectedVO> selectedList = scheduleService.selectSelected(loginUser.getUser_id());
				System.out.println(selectedList);
				
				for (SelectedVO selected : selectedList) {
					// hashset�� selected ��ǰ�������� ������.
					makeTrip.add(productService.getProduct(selected.getPseq()));
				}
				System.out.println(" ù��° makeTrip.size : " + makeTrip.size());
				// ���ϴ� �ɼǼ����� selected�� �ɼ� ����ŭ ����
				vo.setMaxoption(vo.getMaxoption() - makeTrip.size());
				vo.setMinoption(vo.getMinoption() - makeTrip.size());
				System.out.println("vo.getMaxoption() : " + vo.getMaxoption());
				System.out.println("vo.getMinoption() : " + vo.getMinoption());
				// �ɼ� ����ŭ �����ϰ� ��ǰ�� �˻��ؿ�
				System.out.println(vo);
				randomProduct  = productService.randomProductByNum(vo);
				
				// hashset�� ���� �ɼǿ� ���� ��ǰ�������� �߰�������
				for (ProductVO random : randomProduct) {
					makeTrip.add(random);
				}
				
				// ���õ� �ɼ��� �� ����� ���		
				for (ProductVO product : makeTrip) {
					selectedTotalPrice += vo.getAdult()*product.getAprice() + vo.getKid()*product.getKprice();
				}
				System.out.println("�ι�° : " + makeTrip.size());
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
