package com.green.biz.util;

/*
 * ���� �������� ���õ� ������ �����ϴ� Ŭ����
 * - ���� ������ ��ȣ
 * - �������� ��� �׸� ����
 * - �� �������� ���� �׸� ��ȣ
 */

public class Criteria {
	private int pageNum;	// ���� ������ ��ȣ
	private int numPerPage;	// �������� ��� �׸� ����
	
	public Criteria() {
		// �⺻�� ���� : ���������� : 1��, �������� �׸�� : 10��
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
	
	// �������� �׸� �� ����
	// �ִ� �׸� �� : 30��
	public void setNumPerPage(int numPerPage) {
		if (numPerPage <= 0 || numPerPage >30) this.numPerPage = 30;
		else this.numPerPage = numPerPage;
	}
	
	// ���� �������� ���� �׸� ��ȣ�� ��ȯ
	public int getStartPage() {
		return (this.pageNum -1) * this.numPerPage + 1;
	}
	
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", numPerPage=" + numPerPage + "]";
	}

}
