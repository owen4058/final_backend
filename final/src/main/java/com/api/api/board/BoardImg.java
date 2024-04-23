package com.api.api.board;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("boardImg")
@Getter
@Setter

public class BoardImg {
	int img_id;
	int board_id;
	String img_name;
	String img_path;
}
