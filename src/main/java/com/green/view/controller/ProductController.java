package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.green.biz.condition.ConditionVO;
import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;

@Controller

public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="product_detail")
	public String productDetailView(ProductVO vo, Model model) {
		vo = productService.getProduct(vo);
		model.addAttribute("product", vo);
		return "product/productDetail";
	}
	
	@RequestMapping(value="product_list")
	public String productListView(@RequestParam(value="key", defaultValue="", required=false) String key, ConditionVO vo, Model model) {
		List<ProductVO> productList = productService.listProduct(key);
		model.addAttribute("condition" ,vo);
		model.addAttribute("productList", productList);
		return "product/product_list";
	}
	
	
}
