package com.green.biz.util;

/*
 * 현재 페이지와 관련된 정보를 저장하는 클래스
 * - 현재 페이지 번호
 * - 페이지당 출력 항목 갯수
 * - 각 페이지의 시작 항목 번호
 */

public class Criteria {
	private int pageNum;	// 현재 페이지 번호
	private int numPerPage;	// 페이지당 출력 항목 갯수
	
	public Criteria() {
		// 기본값 설정 : 현재페이지 : 1번, 페이지당 항목수 : 10개
		this(1, 10);
	}

	public Criteria(int pageNum, int numPerPage) {
		super();
		this.pageNum = pageNum;
		this.numPerPage = numPerPage;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		if (pageNum <= 0) {
			this.pageNum = 1;
		} else {
			this.pageNum = pageNum;
		}
	}
	
	public int getNumPerPage() {
		return numPerPage;
	}
	
	// 페이지당 항목 수 설정
	// 최대 항목 수 : 30개
	public void setNumPerPage(int numPerPage) {
		if (numPerPage <= 0 || numPerPage >30) this.numPerPage = 30;
		else this.numPerPage = numPerPage;
	}
	
	// 현재 페이지의 시작 항목 번호를 반환
	public int getStartPage() {
		return (this.pageNum -1) * this.numPerPage + 1;
	}
	
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", numPerPage=" + numPerPage + "]";
	}

}
