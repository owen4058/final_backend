package com.api.api.board;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("boardForm")
@Getter
@Setter
@NoArgsConstructor

public class BoardForm{
	int board_id; 
	int section_id; 
	int forum_id; 
	int user_id; 
	int board_like_state;
	int board_save_state;
	String forum_name; 
	String pro_path;
	String pro_img;
	String nickname; 
	String title; 
	String content; 
	int hits; 
	int like_count; 
	int comment_count; 
	Date create_date; 
	List<BoardImg> img; 
	List<Hashtag> tag; 
}
