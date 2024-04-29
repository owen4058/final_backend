package com.api.api.board;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("boardCreateForm")
@Getter
@Setter

public class BoardCreateForm {	
	
	int board_id;
	int forum_id;
	int section_id;
	int user_id;
	String title;
	String content;

}
