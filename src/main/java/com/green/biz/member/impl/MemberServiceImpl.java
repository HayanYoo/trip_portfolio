package com.green.biz.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO member;
	
	@Override
	public MemberVO getMember(MemberVO vo) {
		return member.getMember(vo);
	}

	@Override
	public MemberVO findMember(MemberVO vo) {
		return member.findMember(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		member.insertMember(vo);
	}

}
