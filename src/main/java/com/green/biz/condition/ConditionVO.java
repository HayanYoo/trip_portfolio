package com.green.biz.condition;

import lombok.Data;

@Data
public class ConditionVO {
	
	 private String user_id;
	 private String area;
	 private String  startdate;
	 private String  enddate;
	 private int   minbudget;
	 private int  maxbudget;
	 private int  minoption;
	 private int  maxoption;
	 private int  adult;
	 private int  kid;

}
