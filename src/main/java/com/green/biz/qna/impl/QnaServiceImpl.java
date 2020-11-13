package com.green.biz.qna.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.qna.QnaService;
import com.green.biz.qna.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaDAO qna;
	
	@Override
	public List<QnaVO> qnaList(String user_id) {
		return qna.qnaList(user_id);
	}

	@Override
	public void insertQna(QnaVO vo) {
		qna.insertQna(vo);
	}

	@Override
	public QnaVO selectQnaByQseq(int qseq) {
		return qna.selectQnaByQseq(qseq);
	}

	@Override
	public void deleteQna(int qseq) {
		qna.deleteQna(qseq);
	}

}
