package com.green.biz.schedule;

import java.util.Date;

import lombok.Data;

@Data
public class ScheduleVO {

	   private int sseq;
	   private String user_id;
	   private String area;
	   private Date startdate;
	   private Date enddate;
	   private int minbudget;
	   private int maxbudget;
	   private int minoption;
	   private int  maxoption;
	   private int  adult;
	   private int kid;
	   private Date regdate;
}
