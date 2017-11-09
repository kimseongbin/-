package com.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberMapper {
	ArrayList<MemberVO> getMembers();
	MemberVO getMember(MemberVO member);
	void insertMember(MemberVO member);
	void insertMember2(HashMap<String, String> map);
	void updateMember(MemberVO member);
	void deleteMember(MemberVO member);
	int getCount();
}
