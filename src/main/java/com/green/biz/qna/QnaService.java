package com.green.biz.qna;

import java.util.List;

public interface QnaService {

	List<QnaVO> qnaList(String user_id);

	void insertQna(QnaVO vo);

	public QnaVO selectQnaByQseq(int qseq);
	
	public void deleteQna(int qseq);
}