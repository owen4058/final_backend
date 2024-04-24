package com.api.api.board;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("hashtag")
@Getter
@Setter

public class Hashtag {
	int hastag_id;
	String hashtag_name;
	int board_id;
}
