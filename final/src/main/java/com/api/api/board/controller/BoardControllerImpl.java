package com.api.api.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.board.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("boardController")
public class BoardControllerImpl implements BoardController{
	
	@Autowired
	private BoardService boardService;
	
	
	@Override
	@RequestMapping(value = "/home" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<BoardForm>> homelist(
			@RequestParam(defaultValue = "1") Integer page
			) throws Exception {

		List<BoardForm> vo = boardService.homelist(page);
		
		return new ResponseEntity<List<BoardForm>>(vo, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<BoardForm>> boardlist(
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam Integer forum_id, 
			@RequestParam Integer section_id,
			@RequestParam Integer user_id) throws Exception {
		
		Map<String, Object> mapvo = new HashMap<String, Object>();
		mapvo.put("page",page);
		mapvo.put("forum_id",forum_id);
		mapvo.put("section_id",section_id);
		mapvo.put("user_id",user_id);

		List<BoardForm> vo = boardService.boardlist(mapvo);
		
		return new ResponseEntity<List<BoardForm>>(vo, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_detail" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<?> boardcreate(
			@RequestPart(name = "board") BoardCreateForm board, 
			@RequestPart(required = false, name = "hashtag") List<Hashtag> hashtag, 
			@RequestPart(required = false, name = "files") MultipartFile[] files) throws Exception {
		
		String filepath = "c:\\imgs\\board\\upload"+File.separator+board.getTitle();
		List<Hashtag> tag  = new ArrayList<>();
		List<BoardImg>  boardImgs = new ArrayList<BoardImg>();
		try {
			if (files != null) {
				for (MultipartFile multipart : files) {
					if (!multipart.isEmpty()) {
						System.out.println("������ "+ multipart.getOriginalFilename());
						String filename = System.currentTimeMillis()+"_"+multipart.getOriginalFilename();
						FileUtils.copyInputStreamToFile(multipart.getInputStream(), new File(filepath, filename));
						BoardImg boardImg = new BoardImg();
						boardImg.setImg_name(filename);
						boardImg.setImg_path(filepath+"/"+ filename);
						
						boardImgs.add(boardImg);
					}	
				}	
			}
			if (hashtag != null) {
				tag  = hashtag;
			}
			
			return new ResponseEntity<BoardCreateForm>(boardService.boardcreate(board, boardImgs, tag), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("���� ��Ͽ� �����߽��ϴ�.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	@RequestMapping(value = "/board_detail" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<?> boarddetail(
			@RequestParam Integer board_id
			, @RequestParam Integer user_id) throws Exception {
		Map<String, Object> board_info = new HashMap<String, Object>();
		board_info.put("board_id", board_id);
		board_info.put("user_id", user_id);
		return new ResponseEntity<List<?>>(boardService.boarddetail(board_info), HttpStatus.OK);
	}
	
	// ��Ȱ��ȭ �� �̹��� ���� ���� ���� �ϱ�   
	
	@Override
	@RequestMapping(value = "/board_update" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<?> boardupdate(
			@RequestPart(name = "board") BoardCreateForm board, 
			@RequestParam int my_id, 
			@RequestPart(required = false, name = "hashtag") List<Hashtag> hashtag, 
			@RequestPart(required = false, name = "img") List<BoardImg> img, 
			@RequestPart(required = false, name = "files") MultipartFile[] files) throws Exception {
		
		if (board.getUser_id() != my_id) {
			return new ResponseEntity<String>("�Խñ� �ۼ��ڰ� �ƴմϴ�.", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
		
		String filepath = "c:\\imgs\\board\\upload"+File.separator+board.getTitle();
		List<Hashtag> tag  = new ArrayList<>();
	
		try {
			if (files != null) {
				for (MultipartFile multipart : files) {
					if (!multipart.isEmpty()) {
						System.out.println("������ "+ multipart.getOriginalFilename());
						String filename = System.currentTimeMillis()+"_"+multipart.getOriginalFilename();
						FileUtils.copyInputStreamToFile(multipart.getInputStream(), new File(filepath, filename));
						BoardImg boardImg = new BoardImg();
						boardImg.setImg_name(filename);
						boardImg.setImg_path(filepath+"/"+ filename);
						
						img.add(boardImg);
					}	
				}	
			}
		// 수정 전 버전이랑 수정 될 버전이랑 다를떄 파일 삭제 알고리즘 구현 및 		
			
			if (hashtag != null) {
				tag  = hashtag;
			}
			
			List<BoardImg> imgcheck = boardService.boardcheck(board, img);
			int count = 0;
			for (int i=0; i<img.size(); i++) {
				for (int j=0; j<img.size(); j++) {
					if (img.get(i).getImg_name().equals(imgcheck.get(j).getImg_name())) {
							count ++;
						}
				}	
			}
			if (count < 3) {
				
				List<BoardDetailForm> boarddetail = boardService.boardupdate(board, img, my_id);
				
				String path = "c:\\imgs\\board\\upload"+File.separator+boarddetail.get(0).getTitle();
				
				
				// ������ ���ϵ� ����
				File folder = new File(path);

				try {

				    if (folder.exists()) {
				  	  FileUtils.cleanDirectory(folder);//���� ������ ���� ��� ����

				    if (folder.isDirectory()) {
				      folder.delete(); // ������� ����
				      System.out.println(folder + "������ �����Ǿ����ϴ�.");
				    }
				    }
				} catch (IOException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(boardService.boardupdate(board, img, my_id), HttpStatus.OK);
			}
			return new ResponseEntity<>(boardService.boardupdate(board, img, my_id), HttpStatus.OK);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("���� ��Ͽ� �����߽��ϴ�.", HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	


}
