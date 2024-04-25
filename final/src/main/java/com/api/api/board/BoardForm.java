package com.api.api.board;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("boardForm")
@Getter
@Setter
@NoArgsConstructor

public class BoardForm{
	int board_id; // �Խù� ���̵� 
	int section_id; // ���Ǿ��̵�
	int forum_id; // ���� ���̵�
	int user_id; // ���� ���̵�
	String pro_path; 
	String nickname; // ���� �г���
	String title; // ����
	String content; // ����
	int hits; // ��ȸ��
	int like_count; // ���ƿ��
	int comment_count; // ��ۼ�
	Date create_date; // ������¥
	List<BoardImg> img; // �Խñ� �̹���
	List<Hashtag> tag; // �ؽ��±�
}
