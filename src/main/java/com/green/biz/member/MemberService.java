package com.green.biz.member;

public interface MemberService {

	public MemberVO getMember(MemberVO vo);

	public MemberVO findMember(MemberVO vo);

	public void insertMember(MemberVO vo);

	public MemberVO getMemberByNameAndEmail(MemberVO vo);
	
	public MemberVO getMemberByIdAndNameAndEmail(MemberVO vo);
	
	public void changePassword(MemberVO vo);
	
}