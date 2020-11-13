package com.green.view.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.condition.ConditionVO;
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
	public String home(ConditionVO vo, Model model) {
		
		
		//����Ʈ ��ǰ ��ȸ ���� ȣ��
		List<ProductVO> bestProductList = productService.getBestProductList();
		model.addAttribute("condition", vo);
		model.addAttribute("bestProductList", bestProductList);
		
		return "index";
	}
	
	
	
}
