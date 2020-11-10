package com.green.biz.member.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.member.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberVO getMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMember", vo);
	}
	
	public MemberVO findMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.findMember", vo);
	}
	
	public void insertMember(MemberVO vo) {
		mybatis.insert("memberDAO.insertMember", vo);
	}
	
	
}
