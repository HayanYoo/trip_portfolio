package com.green.view.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// page�� condition ���� ���޴� ������ �ذ��� ��! -> condition�� ��°�� �Ѱ��ִ°��� �ƴ� ����������� �ϳ��ϳ� �����������
	@RequestMapping(value="delete_selected")
	public String deleteSelectedAction(@RequestParam(value="page") String page , SelectedVO vo, ConditionVO condition, Model model) {
		scheduleService.delete_selected(vo);	

		if (page.equals("1")){
			return "redirect:/product_list";
		} else 	{
					
			model.addAttribute("area", condition.getArea());
			model.addAttribute("startdate", condition.getStartdate());
			model.addAttribute("enddate", condition.getEnddate());
			model.addAttribute("adult", condition.getAdult());
			model.addAttribute("kid", condition.getKid());
			model.addAttribute("minbudget", condition.getMinbudget());
			model.addAttribute("maxbudget", condition.getMaxbudget());
			model.addAttribute("minoption", condition.getMinoption());
			model.addAttribute("maxoption", condition.getMaxoption());	
			return "redirect:/make_trip";
		}
	}

	@RequestMapping("make_trip")
	public String makeTripAction(@RequestParam(value="page", defaultValue="", required=false) String page,  ConditionVO vo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			
			vo.setUser_id(loginUser.getUser_id());
			System.out.println("make_trip�� vo" + vo);	
			HashSet<ProductVO> makeTrip = new HashSet<>();
			List<ProductVO> randomProduct = new ArrayList<>();
			List<SelectedVO> selectedList = new ArrayList<>();
			List<ProductVO> selectedProduct = new ArrayList<>();
			
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
				selectedProduct.clear();
				
				// selected�� ��ǰ���� ������
				selectedList = scheduleService.selectSelected(loginUser.getUser_id());
				
				for (SelectedVO selected : selectedList) {
					// hashset�� selected ��ǰ�������� ������.
					makeTrip.add(productService.getProduct(selected.getPseq()));
					selectedProduct.add(productService.getProduct(selected.getPseq()));
				}

				// ���ϴ� �ɼǼ����� selected�� �ɼ� ����ŭ ����
				vo.setMaxoption(vo.getMaxoption() - makeTrip.size());
				vo.setMinoption(vo.getMinoption() - makeTrip.size());

				// �ɼ� ����ŭ �����ϰ� ��ǰ�� �˻��ؿ�
				randomProduct  = productService.randomProductByNum(vo);
				
				// hashset�� ���� �ɼǿ� ���� ��ǰ�������� �߰�������
				for (ProductVO random : randomProduct) {
					makeTrip.add(random);
				}
				
				// ���õ� �ɼ��� �� ����� ���		
				for (ProductVO product : makeTrip) {
					selectedTotalPrice += vo.getAdult()*product.getAprice() + vo.getKid()*product.getKprice();
				}

				// ������ ������ �°� ����ɼǼ��� ������ ������ �������� ��������
				if(selectedTotalPrice >= vo.getMinbudget() && selectedTotalPrice <= vo.getMaxbudget()) {
					if(makeTrip.size() >= origin_minoption && makeTrip.size() <= origin_maxoption) {
						vo.setMinoption(origin_minoption);
						vo.setMaxoption(origin_maxoption);
						temp = false;
						break;
					}
				}
				
				System.out.println(vo);
				System.out.println(selectedTotalPrice);
				
				
				/*
				// ���� ��ǰ ������ temp_trip�� ������
				for(ProductVO product : makeTrip) {
				scheduleService.saveTempTrip(loginUser.getUser_id(), product.getPseq());
				}
				
				// ����� temp_trip ����Ʈ�� �ҷ���
				List<TempTripVO> tempTripList = scheduleService.getTempTrip(loginUser.getUser_id());
				
				// temp_trip�� ����� ��ǰ���� ����Ʈ�� ��������
				List<ProductVO> tempProduct = new ArrayList<>();
				for (TempTripVO temp : tempTripList) {
					tempProduct.add(temp.getPseq());
				*/
			}
			
			model.addAttribute("makeTrip", makeTrip);
			model.addAttribute("selectedTotalPrice", selectedTotalPrice);
			model.addAttribute("selectedProduct", selectedProduct);
			model.addAttribute("randomProduct", randomProduct);
			model.addAttribute("condition", vo);
			//model.addAttribute("tempProduct", tempProduct);
			return "product/makeTrip";
		
		}
	}
}
