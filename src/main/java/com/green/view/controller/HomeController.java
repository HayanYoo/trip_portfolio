package com.green.view.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	
	//@Autowired
	//private ProductService productService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home( Model model) {
		
		// �Ż�ǰ ��ȸ ���� ȣ��
		//List<ProductVO> newProductList = productService.getNewProductList();
		//model.addAttribute("newProductList", newProductList);
		
		// ����Ʈ ��ǰ ��ȸ ���� ȣ��
		//List<ProductVO> bestProductList = productService.getBestProductList();
		//model.addAttribute("bestProductList", bestProductList);
		
		return "index";
	}
	
}
