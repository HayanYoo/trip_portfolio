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
	
	// 선택했던 옵션을 삭제하는 기능
	@RequestMapping(value="delete_selected")
	public String deleteSelectedAction(@RequestParam(value="page") String page , SelectedVO vo, ConditionVO condition, Model model) {
		scheduleService.deleteSelected(vo);	
		
		
		//page가 1일경우 selectedOption을 delte 한 뒤 activity로 돌아감
		if (page.equals("1")){
			return "redirect:/product_list";
		} else 	{	//page가 2일경우 selectedOption을 delte 한 뒤 makeTrip으로 돌아감
					
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

	// 조건에 맞는 여행지를 랜덤으로 만들기
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
					
					// 값 초기화
					vo.setMinoption(origin_minoption);
					vo.setMaxoption(origin_maxoption);
					selectedTotalPrice = 0;	
					makeTrip.clear();
					selectedProduct.clear();
					
					// selected된 상품들을 가져옴
					selectedList = scheduleService.selectSelected(loginUser.getUser_id());
					
					for (SelectedVO selected : selectedList) {
						// hashset에 selected 상품정보들을 저장함.
						makeTrip.add(productService.getProduct(selected.getPseq()));
						selectedProduct.add(productService.getProduct(selected.getPseq()));
					}
	
					// 원하는 옵션수에서 selected된 옵션 수만큼 빼줌
					vo.setMaxoption(vo.getMaxoption() - makeTrip.size());
					vo.setMinoption(vo.getMinoption() - makeTrip.size());
	
					// 옵션 수만큼 랜덤하게 상품을 검색해옴
					randomProduct  = productService.randomProductByNum(vo);
					
					// hashset에 랜덤 옵션에 대한 상품정보들을 추가저장함
					for (ProductVO random : randomProduct) {
						makeTrip.add(random);
					}
					
					// 선택된 옵션의 총 비용을 계산		
					for (ProductVO product : makeTrip) {
						selectedTotalPrice += vo.getAdult()*product.getAprice() + vo.getKid()*product.getKprice();
					}
	
					// 여행경비가 범위에 맞고 여행옵션수가 범위에 맞으면 루프문을 빠져나옴
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
						// 값을 찾을수 없을 때 무한루프로 빠지는것을 방지하기 위해 검색횟수 설정
						if (i >5000) {
							model.addAttribute("condition", vo);
							model.addAttribute("message", "검색하신 조건의 결과를 찾을 수 없습니다");
							return "product/makeTrip";
						}
					}

					
					// 최종 상품 정보를 temp_trip에 저장함
					TempTripVO tempTrip = new TempTripVO();
					tempTrip.setUser_id(loginUser.getUser_id());
					
					
					for(ProductVO product : makeTrip) {
						tempTrip.setPseq(product.getPseq());
						scheduleService.saveTrip(tempTrip);
					}
					
					// 저장된 temp_trip 리스트를 불러옴
					List<TempTripVO> tempTripList = scheduleService.getTempTrip(loginUser.getUser_id());
					
					// temp_trip에 저장된 상품들을 리스트에 저장해줌
					
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

	
	// 저장된 일정에 tempTrip 담기
	@RequestMapping("make_schedule")
	public String makeSchedule(RandomVO random, ScheduleVO schedule,  HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "member/login";
		} else {
					
			schedule.setUser_id(loginUser.getUser_id());
			scheduleService.insertSchedule(schedule);	// schedule테이블에 저장
			List<TempTripVO> tempTrip = scheduleService.getTempTrip(loginUser.getUser_id());	// temptrip 불러오기

			// 가장 최근 sseq에 temptrip 저장
			random.setSseq(scheduleService.latestSseq());
			
			// randomVO에 pseq에 맞는 product 값을 넣어줌
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
			
			// 저장된 scheduleList
			List<ScheduleVO> scheduleList = scheduleService.getAllSchedule(loginUser.getUser_id());
			
			// 저장된 randomList
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
		// 저장된 scheduleList
		List<ScheduleVO> scheduleList = scheduleService.getAllSchedule(loginUser.getUser_id());
		
		// 저장된 randomList
		List<RandomVO> randomList = scheduleService.getRandomByUserid(loginUser.getUser_id());
					
		model.addAttribute("randomList", randomList);
		model.addAttribute("scheduleList", scheduleList);
		return "mypage/saveTrip";
		}
	}
	
	
	@RequestMapping("delete_schedule")
	public String deleteSchedule(@RequestParam(value="sseq") int sseq) {
		// Random테이블의 해당sseq에 저장되어있는 product 삭제
		scheduleService.deleteRandom(sseq);

		// Schedule테이블의 해당sseq에 저장되어있는 product 삭제	
		scheduleService.deleteSchedule(sseq);
		
		return "redirect:/cart";
	}
	
}
