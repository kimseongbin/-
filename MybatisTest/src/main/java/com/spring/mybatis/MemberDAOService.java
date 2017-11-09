package com.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAOService implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession; // Mybatis 라이브러리가 제공하는 클래스
	
	@Override
	public ArrayList<MemberVO> getMembers() {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		//getMembers()의 메소드명과 Mapper.xml의 id명은 동일해야한다
		memberList = memberMapper.getMembers();
		//memberList = memberMappder.getMembers("tab_mybatis");
		System.out.println(memberMapper.getCount());
		return memberList;
	}

	@Override
	public MemberVO getMember(MemberVO member) {
		MemberVO vo = new MemberVO();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		vo = memberMapper.getMember(member);
		return vo;
	}

	@Override
	public void insertMember(MemberVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(member);
	}

	@Override
	public void insertMember2(HashMap<String, String> map) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember2(map);
		
	}

	@Override
	public void updateMember(MemberVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateMember(member);
	}

	@Override
	public void deleteMember(MemberVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(member);
	}

	@Override
	public int getCount() {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.getCount();
	}

}
