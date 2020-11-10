package com.green.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.biz.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//@RequestMapping("")
	
}
