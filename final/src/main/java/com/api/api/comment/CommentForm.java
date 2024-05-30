package com.api.api.comment;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("commentForm")
@Getter
@Setter

public class CommentForm {
	
	int comment_id;
	int pa_comment_id;
	int board_id;
	int user_id;
	String cmt_content;
	String nickname;
	String pro_path;
	int comment_like;
	int recomment_count;
	int comment_like_state;
	int comment_state;
	Date create_date;
	String pro_img;

}
