package com.green.view.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.condition.ConditionVO;
import com.green.biz.member.MemberVO;
import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;
import com.green.biz.schedule.RandomVO;
import com.green.biz.schedule.ScheduleService;
import com.green.biz.schedule.ScheduleVO;
import com.green.biz.schedule.SelectedVO;
import com.green.biz.schedule.TempTripVO;

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
	
	// �����ߴ� �ɼ��� �����ϴ� ���
	@RequestMapping(value="delete_selected")
	public String deleteSelectedAction(@RequestParam(value="page") String page , SelectedVO vo, ConditionVO condition, Model model) {
		scheduleService.deleteSelected(vo);	
		
		
		//page�� 1�ϰ�� selectedOption�� delte �� �� activity�� ���ư�
		if (page.equals("1")){
			return "redirect:/product_list";
		} else 	{	//page�� 2�ϰ�� selectedOption�� delte �� �� makeTrip���� ���ư�
					
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

	// ���ǿ� �´� �������� �������� �����
	@RequestMapping("make_trip")
	public String makeTripAction( ConditionVO vo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		
		if(loginUser == null) {
			return "member/login";
		} else {
				scheduleService.deleteTempTrip(loginUser.getUser_id());
			
				vo.setUser_id(loginUser.getUser_id());
	
				HashSet<ProductVO> makeTrip = new HashSet<>();
				List<ProductVO> randomProduct = new ArrayList<>();
				List<SelectedVO> selectedList = new ArrayList<>();
				List<ProductVO> selectedProduct = new ArrayList<>();
				List<ProductVO> tempProduct = new ArrayList<>();
				
				int selectedTotalPrice = 0;	
				int origin_minoption = vo.getMinoption();
				int origin_maxoption = vo.getMaxoption();
	
				boolean temp = true;
				int i = 0;
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
					
						i++;
						System.out.println(i);
						// ���� ã���� ���� �� ���ѷ����� �����°��� �����ϱ� ���� �˻�Ƚ�� ����
						if (i >5000) {
							model.addAttribute("condition", vo);
							model.addAttribute("message", "�˻��Ͻ� ������ ����� ã�� �� �����ϴ�");
							return "product/makeTrip";
						}
					}

					
					// ���� ��ǰ ������ temp_trip�� ������
					TempTripVO tempTrip = new TempTripVO();
					tempTrip.setUser_id(loginUser.getUser_id());
					
					
					for(ProductVO product : makeTrip) {
						tempTrip.setPseq(product.getPseq());
						scheduleService.saveTrip(tempTrip);
					}
					
					// ����� temp_trip ����Ʈ�� �ҷ���
					List<TempTripVO> tempTripList = scheduleService.getTempTrip(loginUser.getUser_id());
					
					// temp_trip�� ����� ��ǰ���� ����Ʈ�� ��������
					
					for (TempTripVO temp1 : tempTripList) {
						tempProduct.add(productService.getProduct(temp1.getPseq()));
					}
				model.addAttribute("selectedProduct", selectedProduct);	
				model.addAttribute("selectedTotalPrice", selectedTotalPrice);
				model.addAttribute("condition", vo);
				model.addAttribute("tempProduct", tempProduct);
				return "product/makeTrip";
		}
	}	

	
	// ����� ������ tempTrip ���
	@RequestMapping("make_schedule")
	public String makeSchedule(RandomVO random, ScheduleVO schedule,  HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "member/login";
		} else {
					
			schedule.setUser_id(loginUser.getUser_id());
			scheduleService.insertSchedule(schedule);	// schedule���̺� ����
			List<TempTripVO> tempTrip = scheduleService.getTempTrip(loginUser.getUser_id());	// temptrip �ҷ�����

			// ���� �ֱ� sseq�� temptrip ����
			random.setSseq(scheduleService.latestSseq());
			
			// randomVO�� pseq�� �´� product ���� �־���
			for (TempTripVO temp : tempTrip) {
				random.setPseq(temp.getPseq());
				ProductVO product = productService.getProduct(temp.getPseq());
				random.setImage(product.getImage());
				random.setName(product.getName());
				random.setAprice(product.getAprice());
				random.setKprice(product.getKprice());
				random.setAddress(product.getAddress());
				random.setDes(product.getDes());
				
				scheduleService.insertRandom(random);
			}
			
			// ����� scheduleList
			List<ScheduleVO> scheduleList = scheduleService.getAllSchedule(loginUser.getUser_id());
			
			// ����� randomList
			List<RandomVO> randomList = scheduleService.getRandomByUserid(loginUser.getUser_id());
						
			model.addAttribute("randomList", randomList);
			model.addAttribute("scheduleList", scheduleList);
			return "mypage/saveTrip";
		}
	}
	
	@RequestMapping("cart")
	public String cartView(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
		// ����� scheduleList
		List<ScheduleVO> scheduleList = scheduleService.getAllSchedule(loginUser.getUser_id());
		
		// ����� randomList
		List<RandomVO> randomList = scheduleService.getRandomByUserid(loginUser.getUser_id());
					
		model.addAttribute("randomList", randomList);
		model.addAttribute("scheduleList", scheduleList);
		return "mypage/saveTrip";
		}
	}
	
	
	@RequestMapping("delete_schedule")
	public String deleteSchedule(@RequestParam(value="sseq") int sseq) {
		// Random���̺��� �ش�sseq�� ����Ǿ��ִ� product ����
		scheduleService.deleteRandom(sseq);

		// Schedule���̺��� �ش�sseq�� ����Ǿ��ִ� product ����	
		scheduleService.deleteSchedule(sseq);
		
		return "redirect:/cart";
	}
	
}
