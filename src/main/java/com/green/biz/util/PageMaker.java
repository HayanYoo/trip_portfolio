package com.green.biz.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private Criteria cri;	// ���� ������ ����
	private int totalCount;	// ��ü �Խñ��� ��
	private int startPage;	// ǥ�õ� ���� ������ ��ȣ
	private int endPage;	// ǥ�õ� �� ������ ��ȣ
	private boolean prev;	// ���� ������ ����
	private boolean next;	// ���� �������� ����
	
	private int displayPageNum = 10;	// ȭ�� �ϴܿ� ���̴� �������� ��
	private int realEndPage;			// ��ü �׸��� ���� ���� ���� ������ �������� ��ȣ
	
	public Criteria getCri() {
		return cri;
	}
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	// ��ȸ�� ��ü �׸��� ������ �� �� ��������� �ʱ�ȭ ����
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		memberInit();
	}
	
	/*
	 * ��� ������ �ʱⰪ ����
	 */
	
	public void memberInit() {
		// ǥ�õ� �������� ���
		// �ø�(���� ������ ��ȣ/ǥ���� ������ ����) * ǥ���� ������ ����
		endPage = (int)(Math.ceil(cri.getPageNum() / (double)displayPageNum)) * displayPageNum;
		
		// ���������� : �������� ��ȣ - ǥ���� ������ �� + 1
		startPage = endPage - displayPageNum + 1;
		
		// ���� ������ ������ ���
		// �ø�(��ȸ�� ��ü �׸��� �� / �������� ��� �׸� ��)
		realEndPage = (int)(Math.ceil(totalCount / (double)cri.getNumPerPage()));
		
		// ���� ������ ������(realEndPage)�� ����� ������ ������(endPage)�� ���� Ʋ����
		// ������ �������� realEndPage�� ������
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		prev = (startPage == 1) ? false : true;
		
		// ��ȸ�� ��ü �׸���� ������ ������ * �������� ǥ�� �׸������ ũ�� ������������ ���� ��.
		next = (totalCount > endPage * cri.getNumPerPage()) ? true : false;
		
	}
	
	/*
	 * ������ ��ȣ�� �Է� �޾� product_list ���� ��Ʈ���� ������ִ� �޼ҵ�
	 * �Է� �Ű����� :
	 * 			page : ǥ���� ������ ��ȣ
	 * ��� �� :
	 * 		?pageNum=2&numPerPage=10
	 */
	 
	public String makeQuery(int page) {
		UriComponents uriComp = UriComponentsBuilder.newInstance()
								.queryParam("pageNum", page)
								.queryParam("numPerPage", cri.getNumPerPage())
								.build();
		
		return uriComp.toString();
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	public int getRealEndPage() {
		return realEndPage;
	}
	
	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	@Override
	public String toString() {
		return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum
				+ ", realEndPage=" + realEndPage + "]";
	}
	
	
}
