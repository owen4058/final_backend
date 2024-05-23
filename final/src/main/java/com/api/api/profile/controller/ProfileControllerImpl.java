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
import com.api.api.profile.UserFollow;
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
	public ResponseEntity<Integer> updateProfile(@RequestBody Profile profile, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.println("updateProfile controller");
		int updated = profileService.updateProfile(profile);
        if (updated > 0) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@RequestMapping(value = "/profile/nickname", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<Boolean> checkNicknameAvailablity(@RequestParam String nickname, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("checkNickname Controller " + nickname);
		boolean isAvailable = profileService.isNicknameAvailable(nickname);
		if (isAvailable) {
            return ResponseEntity.ok().body(isAvailable);
        } else {
            return ResponseEntity.ok().body(isAvailable);
        }
	}
	
	@RequestMapping(value = "/profile/follow", produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<Boolean> followUser(@RequestBody UserFollow userFollow, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("userFollow Controller " + userFollow.getUser_id() + " " + userFollow.getOpponent_id());
		boolean success = profileService.followUser(userFollow);
		if (success) {
            return ResponseEntity.ok().body(success);
        } else {
            return ResponseEntity.ok().body(success);
        }
	}
	
	@RequestMapping(value = "/profile/follow", produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	@Override
	public ResponseEntity<Boolean> unfollowUser(@RequestBody UserFollow userFollow, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("userUnfollow Controller " + userFollow.getUser_id() + " " + userFollow.getOpponent_id());
		boolean success = profileService.unfollowUser(userFollow);
		if (success) {
            return ResponseEntity.ok().body(success);
        } else {
            return ResponseEntity.ok().body(success);
        }
	}
	
}
