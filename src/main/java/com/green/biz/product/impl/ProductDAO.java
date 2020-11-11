package com.green.biz.product.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.product.ProductVO;

@Repository
public class ProductDAO  {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ProductVO> getBestProductList() {
		return mybatis.selectList("ProductDAO.getBestProductList");
	}
	
	public ProductVO getProduct(ProductVO vo) {
		return mybatis.selectOne("ProductDAO.getProduct", vo);
	}
	
	public List<ProductVO> listProduct(String name){
		return mybatis.selectList("ProductDAO.listProduct", name);
	}
}
