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
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMemberByNameAndEmail", vo);
	}
	
	public MemberVO getMemberByIdAndNameAndEmail(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMemberByIdAndNameAndEmail", vo);
	}
	
	public void changePassword(MemberVO vo) {
		mybatis.update("MemberDAO.changePassword",vo);
	}
	
	
}
