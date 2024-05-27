package com.api.api.profile.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.profile.Profile;
import com.api.api.profile.ProfileImg;
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
	public ResponseEntity<?> updateProfile(@RequestBody Profile profile,
			@RequestPart(required = false, name = "files") MultipartFile file,
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) throws Exception {
		System.out.println("updateProfile controller");
		
		String filepath = httpServletRequest.getSession().getServletContext().getRealPath("imgs\\profile\\upload");
		
		try {
			ProfileImg profileImg = new ProfileImg();
			
			if (!file.isEmpty()) {
				String filename = System.currentTimeMillis()+"_"+file.getOriginalFilename();
//				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filepath, filename));
				File filePath = new File(filepath + filename);
				file.transferTo(filePath);
				profileImg.setImg_name(filename);
				profileImg.setImg_path(filepath+"/"+ filename);
			}	
			int updated = profileService.updateProfile(profile, profileImg);
			
			if (updated > 0) {
				return ResponseEntity.ok().body(updated);
			} else {
				return ResponseEntity.notFound().build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("파일 등록 실패", HttpStatus.EXPECTATION_FAILED);
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
