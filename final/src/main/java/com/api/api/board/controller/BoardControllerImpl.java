package com.api.api.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.BoardLike;
import com.api.api.board.BoardSave;
import com.api.api.board.Hashtag;
import com.api.api.board.service.BoardService;


@Controller("boardController")
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
	
	@GetMapping("/board/display")
	public ResponseEntity<byte[]> getImage(@RequestParam String fileName, HttpServletRequest request) {
		
		System.out.println("getImage()........." + fileName);
		
		File file = new File(request.getSession().getServletContext().getRealPath("imgs\\board\\upload"+File.separator+fileName));
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
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
			@RequestPart(required = false, name = "files") MultipartFile[] files,
			HttpServletRequest request) throws Exception {
		
		System.out.println("board_detail : ");
		
		String filepath = request.getSession().getServletContext().getRealPath("imgs\\board\\upload");
		List<Hashtag> tag  = new ArrayList<>();
		List<BoardImg>  boardImgs = new ArrayList<BoardImg>();
		try {
			if (files != null) {
				for (MultipartFile multipart : files) {
					if (!multipart.isEmpty()) {
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
			
			return new ResponseEntity<List<?>>(boardService.boardcreate(board, boardImgs, tag), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("파일등록에 실패했습니다.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	@RequestMapping(value = "/board_detail" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<BoardDetailForm>> boarddetail(
			@RequestParam Integer board_id
			, @RequestParam Integer user_id) throws Exception {
		Map<String, Object> board_info = new HashMap<String, Object>();
		board_info.put("board_id", board_id);
		board_info.put("user_id", user_id);
		return new ResponseEntity<List<BoardDetailForm>>(boardService.boarddetail(board_info), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_detail" ,produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> boarddelete(
			@RequestParam Integer board_id
			) throws Exception {
		return new ResponseEntity<Integer>(boardService.boarddelete(board_id), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_like" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<String> boardlike(
			@RequestBody BoardLike board
			) throws Exception {
		int result =  boardService.boardlike(board);
		
		if (result == 1) {
			return new ResponseEntity<String>("정상입력 됐습니다.", HttpStatus.OK);
		}else if (result == 2) {
			return new ResponseEntity<String>("싫어요는 두번 이상 불가능합니다.", HttpStatus.BAD_REQUEST);
		}else if (result == 3) {
			return new ResponseEntity<String>("입력오류입니다.", HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<String>("좋아요는 두번 이상 불가능합니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
	@RequestMapping(value = "/board_save" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<Integer> boardsave(
			@RequestBody BoardSave board
			) throws Exception {
		return new ResponseEntity<Integer>(boardService.boardsave(board), HttpStatus.OK);
	}
	
	
	@Override
	@RequestMapping(value = "/board_update" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<?> boardupdate(
			@RequestPart(name = "board") BoardCreateForm board, 
			@RequestParam int my_id, 
			@RequestPart(required = false, name = "hashtag") List<Hashtag> hashtag, 
			@RequestPart(required = false, name = "img") List<BoardImg> img, 
			@RequestPart(required = false, name = "files") MultipartFile[] files) throws Exception {
		
		if (board.getUser_id() != my_id) {
			return new ResponseEntity<String>("게시글 작성자가 아닙니다.", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
		
		String filepath = "c:\\imgs\\board\\upload";
		List<Hashtag> tag  = new ArrayList<>();
		List<BoardImg> imgs  = new ArrayList<>();
	
		try {
			
		// 수정 전 버전이랑 수정 될 버전이랑 다를떄 파일 삭제 알고리즘 구현 및 데이터 입력 부분 수정 필요
			
			
			// 태그수정 추가해야함
			if (hashtag != null) {
				tag  = hashtag;
			}
			
			// 기존이미지 와의 검증 및 파일 삭제
			List<BoardImg> imgcheck = boardService.boardcheck(board, img);
			boolean count = false;
			for (int i=0; i<imgcheck.size(); i++) {
				for (int j=0; j<img.size(); j++) {
					if (imgcheck.get(i).getImg_name().equals(img.get(j).getImg_name())) {
						System.out.println(imgcheck.get(i).getImg_name()+" = "+img.get(j).getImg_name());
						count = true;
						}
					}
				if (!count) {
					//현재 게시판에 존재하는 파일객체를 만듬
					File file = new File(imgcheck.get(i).getImg_path());
							
					if(file.exists()) { // 파일이 존재하면
						file.delete(); // 파일 삭제	
					}
					// db데이터 삭제
					boardService.imgdelete(imgcheck.get(i));
					
				}
				count = false;
			}
			
			// 멀티파트를 통한 새로운 이미지 추가
			if (files != null) {
				for (MultipartFile multipart : files) {
					if (!multipart.isEmpty()) {
						String filename = System.currentTimeMillis()+"_"+multipart.getOriginalFilename();
						FileUtils.copyInputStreamToFile(multipart.getInputStream(), new File(filepath, filename));
						BoardImg boardImg = new BoardImg();
						boardImg.setImg_name(filename);
						boardImg.setImg_path(filepath+"/"+ filename);
						
						imgs.add(boardImg);
					}	
				}	
			}
			
			return new ResponseEntity<>(boardService.boardupdate(board, imgs, my_id, tag), HttpStatus.OK);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("파일등록에 실패했습니다.", HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	


}
