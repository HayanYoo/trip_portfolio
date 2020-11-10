package com.green.biz.member;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	  private String user_id;
	  private String pwd;
	  private String name;
	  private Date birth;
	  private String phone;
	  private  String email;
	  private String  useyn;
	  private Date   regdate;
}
