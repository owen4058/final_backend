package com.api.api.save;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("save")
@Getter
@Setter
public class Save {
	int user_id;
	int board_id;
}
