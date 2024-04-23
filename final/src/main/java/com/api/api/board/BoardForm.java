package com.api.api.board;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("boardForm")
@Getter
@Setter

public class BoardForm{
	int board_id; // 게시물 아이디
	int section_id; // 섹션아이디
	int forum_id; // 포럼 아이디
	int user_id; // 유저 아이디
	String pro_path; 
	String nickname; // 유저 닉네임
	String title; // 제목
	String content; // 본문
	int hits; // 조회수
	int like_count; // 좋아요수
	Date create_date; // 생성날짜
	List<BoardImg> img; // 게시글 이미지
	List<Hashtag> tag; // 해쉬태그
}
