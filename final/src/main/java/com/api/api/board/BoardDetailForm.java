package com.api.api.board;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.api.comment.CommentForm;
import com.api.api.forum.ForumForm;

import lombok.Getter;
import lombok.Setter;

@Component("boardDetailForm")
@Getter
@Setter

public class BoardDetailForm {
	
	ForumForm forum;
	int board_id; 
	int section_id; 
	int forum_id; 
	int user_id; 
	int board_like_state;
	int board_save_state;
	String pro_img;
	String pro_path; 
	String nickname; 
	String title; 
	String content; 
	int hits; 
	int like_count; 
	int comment_count; 
	Date create_date; 
	List<BoardImg> img; 
	List<Hashtag> tag;
	List<CommentForm> comment;
	
	
}
