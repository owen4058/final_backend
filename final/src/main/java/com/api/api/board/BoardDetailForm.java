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
	BoardForm board;
	List<CommentForm> comment;
	
}
