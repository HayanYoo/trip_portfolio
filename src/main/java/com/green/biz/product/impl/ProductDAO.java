package com.green.biz.product.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.condition.ConditionVO;
import com.green.biz.product.ProductVO;
import com.green.biz.util.Criteria;

@Repository
public class ProductDAO  {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ProductVO> getBestProductList() {
		return mybatis.selectList("ProductDAO.getBestProductList");
	}
	
	public ProductVO getProduct(int pseq) {
		return mybatis.selectOne("ProductDAO.getProduct", pseq);
	}
	
	public List<ProductVO> listProduct(String name){
		return mybatis.selectList("ProductDAO.listProduct", name);
	}
	
	// 페이지별 상품 목록 조회
	public List<ProductVO> getListProductPaging(String name, Criteria cri) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("criteria", cri);
		return mybatis.selectList("ProductDAO.listWithPaging", map);
	}
	
	public int countProductList(String name) {
		return mybatis.selectOne("ProductDAO.countProductList", name);
	}
	
	public List<ProductVO> listProductByAddress(String name){
		return mybatis.selectList("ProductDAO.listProductByAddress", name);
	}
	
	public List<ProductVO> randomProductByNum(ConditionVO condition){
		return mybatis.selectList("ProductDAO.randomProductByNum", condition);
	}
}
