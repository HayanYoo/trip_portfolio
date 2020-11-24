package com.green.biz.schedule;

import java.util.Date;

import lombok.Data;


public class ScheduleVO {

	   private int sseq;
	   private String user_id;
	   private String area;
	   private String startdate;
	   private String enddate;
	   private int minbudget;
	   private int maxbudget;
	   private int minoption;
	   private int  maxoption;
	   private int  adult;
	   private int kid;
	   private Date regdate;
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStartdate() {
		return startdate.substring(0, 10);
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate.substring(0, 10);
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getMinbudget() {
		return minbudget;
	}
	public void setMinbudget(int minbudget) {
		this.minbudget = minbudget;
	}
	public int getMaxbudget() {
		return maxbudget;
	}
	public void setMaxbudget(int maxbudget) {
		this.maxbudget = maxbudget;
	}
	public int getMinoption() {
		return minoption;
	}
	public void setMinoption(int minoption) {
		this.minoption = minoption;
	}
	public int getMaxoption() {
		return maxoption;
	}
	public void setMaxoption(int maxoption) {
		this.maxoption = maxoption;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	   
	   
}
