package com.green.view.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;
import com.green.biz.util.Criteria;
import com.green.biz.util.PageMaker;

@Controller

public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="product_detail")
	public String productDetailView(ProductVO vo, Criteria cri, Model model) {
		vo = productService.getProduct(vo);
		model.addAttribute("product", vo);
		model.addAttribute("criteria", cri);
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
	public String productListView(@RequestParam(value= "key", defaultValue="", required=false) String key,
													Criteria criteria, Model model) {
		System.out.println("product_List:" + criteria.toString());
		List<ProductVO> prodList = productService.getListProductPaging(key, criteria);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		int prodCount = productService.countProductList(key);
		pageMaker.setTotalCount(prodCount);
		
		System.out.println("페이지 정보 :" + pageMaker.toString());
		
		model.addAttribute("productList", prodList);
		model.addAttribute("productListSize", prodCount);
		model.addAttribute("pageMaker", pageMaker);
		
		return "product/product_list";
		
	}
	
}
