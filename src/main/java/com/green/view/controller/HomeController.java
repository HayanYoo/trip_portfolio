package com.green.view.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home( Model model) {
		
		//베스트 상품 조회 서비스 호출
		List<ProductVO> bestProductList = productService.getBestProductList();
		model.addAttribute("bestProductList", bestProductList);
		
		return "index";
	}
	
}
