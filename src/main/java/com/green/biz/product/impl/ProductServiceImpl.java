package com.green.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.condition.ConditionVO;
import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;
import com.green.biz.util.Criteria;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO product;
	
	@Override
	public List<ProductVO> getBestProductList() {
		return product.getBestProductList();
	}

	@Override
	public ProductVO getProduct(int pseq) {
		return product.getProduct(pseq);
	}

	@Override
	public List<ProductVO> listProduct(String name) {
		return product.listProduct(name);
	}

	@Override
	public List<ProductVO> getListProductPaging(String name, Criteria cri) {
		return product.getListProductPaging(name, cri);
	}

	@Override
	public int countProductList(String name) {
		return product.countProductList(name);
	}

	@Override
	public List<ProductVO> listProductByAddress(String name) {
		return product.listProductByAddress(name);
	}

	@Override
	public List<ProductVO> randomProductByNum(ConditionVO condition) {
		return product.randomProductByNum(condition);
	}

}
