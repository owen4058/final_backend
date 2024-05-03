package com.api.api.board;



import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("boardSave")
@Getter
@Setter

public class BoardSave {	
	
	int board_id;
	int user_id;


}
