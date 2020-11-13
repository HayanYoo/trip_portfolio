package com.green.biz.qna;

import java.util.Date;

import lombok.Data;

@Data
public class QnaVO {
	 private int qseq;
	 private String user_id;
	 private String subject;
	 private String content;
	 private String reply;
	 private String rep;
	  private Date indate;

}
