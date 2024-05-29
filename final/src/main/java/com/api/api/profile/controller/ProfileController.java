package com.api.api.profile.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.profile.Profile;
import com.api.api.profile.UserFollow;

public interface ProfileController {
	public ResponseEntity<Profile> getProfile(@RequestBody int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<?> updateProfile(Profile profile, MultipartFile file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<Boolean> checkNicknameAvailablity(@RequestParam String nickname, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<Boolean> followUser(@RequestBody UserFollow userFollow, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<Boolean> unfollowUser(@RequestBody UserFollow userFollow, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<Boolean> isFollowing(@RequestParam int user_id,
			@RequestParam int opponent_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<?> Follower(@RequestParam int user_id) throws Exception;
	public ResponseEntity<?> Following(@RequestParam int user_id) throws Exception;
}
