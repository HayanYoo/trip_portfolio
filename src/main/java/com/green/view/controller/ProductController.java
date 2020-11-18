package com.green.view.controller;

import java.util.ArrayList;
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
import com.green.biz.schedule.ScheduleService;
import com.green.biz.schedule.SelectedVO;
import com.green.biz.util.Criteria;
import com.green.biz.util.PageMaker;

@Controller
@SessionAttributes("condition")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	
	@RequestMapping(value="product_detail")
	public String productDetailView(ProductVO vo, Criteria cri, HttpSession session, Model model) {
		ConditionVO condition = (ConditionVO)session.getAttribute("condition");
		System.out.println("detail의 조건 : " + condition);
		vo = productService.getProduct(vo);
		model.addAttribute("product", vo);
		model.addAttribute("criteria", cri);
		model.addAttribute("condition" ,condition);
		
		return "product/productDetail";
	}
	
	/* 페이징 처리가 구현되지 않은 목록 조회
	@RequestMapping(value="product_list")
	public String productListView(@RequestParam(value="key", defaultValue="", required=false) String key, ConditionVO vo, Model model) {
		List<ProductVO> productList = productService.listProduct(key);
		model.addAttribute("condition" ,vo);
		model.addAttribute("productList", productList);
		return "product/product_list";
	}
	*/
	
	@RequestMapping(value="product_list")
	public String productListView(@RequestParam(value= "key", defaultValue="", required=false) String key, ConditionVO condition,
													Criteria criteria, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		List<ProductVO> prodList = productService.getListProductPaging(key, criteria);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		int prodCount = productService.countProductList(key);
		pageMaker.setTotalCount(prodCount);
		
		// 선택된옵션 리스트를 불러옴
		// 로그아웃 상태일 경우 null포인트 에러가 나기 때문에 if문에 조건을 넣어주어야함
		if(loginUser != null) {
			List<SelectedVO> selectedList = scheduleService.selectSelected(loginUser.getUser_id());
			List<ProductVO> selectedProduct = new ArrayList<ProductVO>();
			
			// 선택된 옵션 리스트에 저장된 pseq의 상품 정보들을 selectedProduct에 저장
			for (SelectedVO selected : selectedList) {
				ProductVO vo = new ProductVO();
				vo.setPseq(selected.getPseq());
				selectedProduct.add(productService.getProduct(vo));		
			}
			
			model.addAttribute("selectedProduct", selectedProduct);
		}
			
		model.addAttribute("productList", prodList);
		model.addAttribute("productListSize", prodCount);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("condition" ,condition);
		System.out.println("List의 조건 : " + condition);
		
		return "product/product_list";
		
	}
	
}
