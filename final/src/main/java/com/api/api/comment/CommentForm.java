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
	String content;
	int comment_like;
	Date create_date;

}
