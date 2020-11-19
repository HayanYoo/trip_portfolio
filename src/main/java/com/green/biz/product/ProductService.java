package com.green.biz.product;

import java.util.List;

import com.green.biz.condition.ConditionVO;
import com.green.biz.util.Criteria;

public interface ProductService {

	public List<ProductVO> getBestProductList();

	public ProductVO getProduct(int pseq);
	
	public List<ProductVO> listProduct(String name);
	
	public List<ProductVO> getListProductPaging(String name, Criteria cri);
	
	public int countProductList(String name);
	
	public List<ProductVO> listProductByAddress(String name);
	
	public List<ProductVO> randomProductByNum(ConditionVO condition);
	
}