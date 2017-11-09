package com.spring.mybatis;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MybatisController {

	@Autowired
	private MemberDAOService memberDAOService;

	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);

	@RequestMapping("/list.do")
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome list.", locale);
		List<MemberVO> memberList = memberDAOService.getMembers();
		ModelAndView result = new ModelAndView();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}

	@RequestMapping("/insert.do")
	public ModelAndView insert(MemberVO member) {
		memberDAOService.insertMember(member);

		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");

		return result;
	}

	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(MemberVO member) {
		System.out.println("updateForm Complete");
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		member = memberDAOService.getMember(member);
		result.addObject("memberList", memberList);
		result.addObject("member", member);
		result.setViewName("updateForm");
		return result;
	}

	@RequestMapping("/update.do")
	public ModelAndView update(MemberVO member) {
		memberDAOService.updateMember(member);
		System.out.println("update complete");
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");

		return result;
	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(MemberVO member) {
		memberDAOService.deleteMember(member);
		System.out.println("Delete Complete");

		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}

}
