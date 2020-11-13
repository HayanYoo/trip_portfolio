package com.green.biz.qna.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.qna.QnaVO;

@Repository
public class QnaDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<QnaVO> qnaList(String user_id) {
		return mybatis.selectList("QnaDAO.qnaList", user_id);
			
	}
	
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
	
	public QnaVO selectQnaByQseq(int qseq) {
		return mybatis.selectOne("QnaDAO.selectQnaByQseq", qseq);
	}
	
	public void deleteQna(int qseq) {
		mybatis.delete("QnaDAO.deleteQna", qseq);
	}
}
