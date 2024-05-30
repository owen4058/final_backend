package com.api.api.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.member.LoginForm;
import com.api.api.member.Member;
import com.api.api.member.service.MemberService;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/assign" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<String> save(@RequestBody Member member, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		int vo = memberService.addmember(member);
		if (vo!=1) {
			return new ResponseEntity<>("�쉶�썝媛��엯 �떎�뙣", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("�쉶�썝媛��엯 �꽦怨�",HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/login" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<?> login(@RequestBody LoginForm loginform, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		Member loginmember = memberService.login(loginform);
		if (loginmember.getActive_state() == 0) {
			return ResponseEntity.badRequest().body("정지된 회원입니다.");
		}
		if (loginmember == null) {
			return ResponseEntity.badRequest().body("없는 회원입니다.");
		}
		
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("loginMember", loginmember);
		
		return new ResponseEntity<>(loginmember,HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/logout" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<String> logout(
			HttpServletRequest request
			) throws Exception {
		HttpSession session = request.getSession(false);	
		 if (session != null) {
	            session.invalidate();
	        }
		return new ResponseEntity<>("濡쒓렇�븘�썐 �꽦怨�", HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/admin/Manage_member" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<Member>> memberlist(@RequestParam(defaultValue = "1") int page, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		 
		return new ResponseEntity<>(memberService.memberlist(page),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/Manage_member" ,produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	@Override
	public ResponseEntity<String> memberdleate(@RequestParam int user_id, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		;
		
		 if (memberService.memberdelate(user_id) == 0) {
			 return new ResponseEntity<>("�쉶�썝 �궘�젣 �떎�뙣",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("�쉶�썝 �궘�젣 �꽦怨�",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/assign/email", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<Boolean> checkEmailAvailablity(@RequestParam String user_email, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("checkEmail Controller " + user_email);
		boolean isAvailable = memberService.isEmailAvailable(user_email);
		System.out.println("isAvailable " + isAvailable);
		if (isAvailable) {
            return ResponseEntity.ok().body(isAvailable);
        } else {
            return ResponseEntity.ok().body(isAvailable);
        }
	}

}
