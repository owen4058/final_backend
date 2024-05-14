package com.api.api.profile.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/profile/nickname", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<Boolean> checkNicknameAvailablity(@RequestParam String nickname, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("checkNickname Controller " + nickname);
		boolean isAvailable = profileService.isNicknameAvailable(nickname);
		System.out.println("isAvailable " + isAvailable);
		if (isAvailable) {
            return ResponseEntity.ok().body(isAvailable);
        } else {
            return ResponseEntity.ok().body(isAvailable);
        }
	}
	
}
