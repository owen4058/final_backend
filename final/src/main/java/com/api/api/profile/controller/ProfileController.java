package com.api.api.profile.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.api.profile.Profile;

public interface ProfileController {
	public ResponseEntity<Profile> getProfile(@RequestBody int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<Profile> updateProfile(@RequestBody int user_id, Profile profile, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<Boolean> checkNicknameAvailablity(@RequestBody String nickname, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;

}
