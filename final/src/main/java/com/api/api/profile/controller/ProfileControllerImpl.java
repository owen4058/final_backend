//package com.api.api.profile.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.api.api.board.BoardForm;
//import com.api.api.profile.Profile;
//import com.api.api.profile.service.ProfileService;
//
//public class ProfileControllerImpl implements ProfileController{
//	@RequestMapping(value = "profile", produces = "application/json; charset=utf8", method = RequestMethod.GET)
//	@Override
//	public ResponseEntity<Profile> profileOne(@RequestBody int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//		Profile profile = ProfileService.;
//	}
//	
//	
//	public ResponseEntity<Profile> memberUpdate(@RequestBody int user_id, Profile profile, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
//	public ResponseEntity<List<BoardForm>> boardlist(@RequestBody int user_id, Integer page, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
//			throws Exception;
//}