package com.green.biz.member;

public interface MemberService {

	MemberVO getMember(MemberVO vo);

	MemberVO findMember(MemberVO vo);

	void insertMember(MemberVO vo);

}