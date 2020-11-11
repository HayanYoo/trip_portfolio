package com.green.biz.product;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
	private int pseq;
	private String name;
	private String kind;
	private int aprice;
	private int kprice;
	private String image;
	private String useyn;
	private String bestyn;
	private Date regdate;
	private String parea;
	private String sarea;
	private String address;
	private String des;

}
