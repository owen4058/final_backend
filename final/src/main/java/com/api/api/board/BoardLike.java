package com.api.api.board;



import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("boardLike")
@Getter
@Setter

public class BoardLike {	
	
	int board_id;
	int user_id;
	int like_ud;

}
