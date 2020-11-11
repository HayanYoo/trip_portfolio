package com.green.biz.product;

import java.util.List;

public interface ProductService {

	public List<ProductVO> getBestProductList();

	public ProductVO getProduct(ProductVO vo);
	
	public List<ProductVO> listProduct(String name);
}