package com.api.api.board.controller;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.board.service.BoardService;

@Controller("boardController")
public class BoardControllerImpl implements BoardController{
	
	@Autowired
	private BoardService boardService;
	
	@Override
	@RequestMapping(value = "/home" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<BoardForm>> homelist(
			@RequestParam(defaultValue = "1") Integer page, 
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

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
	public ResponseEntity boardcreate(
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
						System.out.println("데이터 "+ multipart.getOriginalFilename());
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
			
			return new ResponseEntity(boardService.boardcreate(board, boardImgs, tag), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("파일 등록에 실패했습니다.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	@RequestMapping(value = "/board_detail" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity boarddetail(
			@RequestParam Integer board_id
			, @RequestParam Integer user_id) throws Exception {
		Map<String, Object> board_info = new HashMap<String, Object>();
		board_info.put("board_id", board_id);
		board_info.put("user_id", user_id);
		return new ResponseEntity(boardService.boarddetail(board_info), HttpStatus.OK);
	}
	


}
