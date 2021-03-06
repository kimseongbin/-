package com.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberDAO {
	public ArrayList<MemberVO> getMembers();
	public MemberVO getMember(MemberVO member);
	public void insertMember(MemberVO member);
	public void insertMember2(HashMap<String, String> map);
	public void updateMember(MemberVO member);
	public void deleteMember(MemberVO member);
	public int getCount();
	
}
