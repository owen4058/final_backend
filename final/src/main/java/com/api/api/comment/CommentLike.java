package com.api.api.comment;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("commentLike")
@Getter
@Setter

public class CommentLike {
	
	int comment_id;
	int user_id;
	int board_id;
	int cmt_like_ud;

}
