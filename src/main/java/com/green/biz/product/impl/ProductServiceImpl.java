package com.green.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO product;
	
	@Override
	public List<ProductVO> getBestProductList() {
		return product.getBestProductList();
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {	
		return product.getProduct(vo);
	}

	@Override
	public List<ProductVO> listProduct(String name) {
		return product.listProduct(name);
	}

}
