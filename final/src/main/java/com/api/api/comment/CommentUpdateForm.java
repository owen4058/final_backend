package com.api.api.comment;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("commentUpdateForm")
@Getter
@Setter

public class CommentUpdateForm {
	
	int comment_id;
	String cmt_content;


}
