package com.api.api.profile.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.board.BoardForm;
import com.api.api.profile.Profile;
import com.api.api.profile.service.ProfileService;

@Controller("profileController")
public class ProfileControllerImpl implements ProfileController{
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = "/profile", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<Profile> getProfile(@RequestParam int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.println("getProfile controller");
		Profile profile = profileService.getProfile(user_id);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@RequestMapping(value = "/profile", produces = "application/json; charset=utf8", method = RequestMethod.PUT)
	@Override
	public ResponseEntity<Profile> updateProfile(@RequestParam int user_id, Profile profile, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.println("updateProfile controller");
		Profile updatedProfile = profileService.updateProfile(user_id, profile);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@RequestMapping(value = "/profile/My_Board", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<BoardForm>> getMyBoardlist(@RequestParam int user_id, Integer page, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("getBoardList controller");
		List<BoardForm> boardList = profileService.getMyBoardList(user_id);
        if (boardList != null && !boardList.isEmpty()) {
            return ResponseEntity.ok(boardList);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
}
