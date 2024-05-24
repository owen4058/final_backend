package com.api.api.comment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentLike;
import com.api.api.comment.CommentUpdateForm;
import com.api.api.comment.repository.CommentRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;

//	@Override
//	public List<CommentForm> commentinsert(CommentForm commentform) {
//		commentRepository.commentinsert(commentform);
//		return commentRepository.commentlist();
//	}

	@Override
	public List<CommentForm> commentlist() {
		return commentRepository.commentlist();
	}

	@Override
	public List<CommentForm> commentinsert(CommentForm commentform) {
		commentRepository.commentinsert(commentform);
		return commentRepository.commentlist();
	}

	@Override
	public List<CommentForm> recomment(Map<String, Object> commentinfo) {
		return commentRepository.recomment(commentinfo);
	}
	@Override
	public List<CommentForm> comment(Map<String, Object> commentinfo) {
		return commentRepository.comment(commentinfo);
	}

	@Override
	public int commentupdate(CommentUpdateForm commentUpdateForm) {
		return commentRepository.commentupdate(commentUpdateForm);
	}

	@Override
	public int commentdelete(int comment_id, int board_id, int pa_comment_id) {
		if (pa_comment_id != 0) {
			commentRepository.pacommentcountmi(pa_comment_id);
		}
		commentRepository.commentcountmi(board_id);
		return commentRepository.commentdelete(comment_id);
	}

	@Override
	public int commentlike(CommentLike commentLike) {
		CommentLike check;
		try {
			check = commentRepository.commentlikecheck(commentLike);
		} catch (Exception e) {
			check = null;
		}	
		
		// 좋아요를 눌렀을때
		if (commentLike.getCmt_like_ud() == 1) {
			// 이미 좋아요가 눌러져있을경우
			if (check != null) {
				// 기존의 좋아요가 1일 경우
				if (check.getCmt_like_ud() == 1) {
					// 좋아요는 두번 불가능합니다.
					return 0;
				}else {
					//기존의 좋아요가 -1일 경우
					System.out.println("좋아요 눌렀을떄 기존값이 -1일경우 : 시작");
					commentRepository.commentlikesetpl(commentLike);
					return commentRepository.commentlikepl2(commentLike);
				}
			// 좋아요가 눌러져 있지 않은경우	
			}else {
				System.out.println("좋아요 눌렀을떄 기존값이 없을경우 : 시작");
				return commentRepository.commentlike(commentLike);
			}
		// 싫어요를 눌렀을때
		}else if(commentLike.getCmt_like_ud() == -1){
			// 이미 좋아요가 눌러져있을경우
			if (check != null) {
				// 기존의 좋아요가 1일 경우
				if (check.getCmt_like_ud() == 1) {
					System.out.println("싫어요 눌렀을떄 기존값이 +1일 경우 : 시작");
					commentRepository.commentlikesetmi(commentLike);
					return commentRepository.commentlikemi2(commentLike);
					
				}else {
					//기존의 좋아요가 -1일 경우
					// 싫어요는 두번 불가능합니다
					return 2;
				}
			// 좋아요가 눌러져 있지 않은경우	
			}else {
				System.out.println("싫어요 눌렀을떄 기존값이 없을경우 : 시작");
				return commentRepository.commentlike(commentLike);
			}
		// 좋아요 없음 상태가 왔을떄	
		}else {
			// 이미 좋아요가 눌러져있을경우
			if (check != null) {
				// 기존의 좋아요가 1일 경우
				if (check.getCmt_like_ud() == 1) {
					System.out.println("상태없음을 눌렀을떄 기존값이 +1일 경우 : 시작");
					commentRepository.commentlikedelete(commentLike);
					return commentRepository.commentlikemi(commentLike);
				}else {
					//기존의 좋아요가 -1일 경우
					System.out.println("상태없음을 눌렀을떄 기존값이 -1일 경우 : 시작");
					commentRepository.commentlikedelete(commentLike);
					return commentRepository.commentlikepl(commentLike);
				}
			// 좋아요가 눌러져 있지 않은경우	
			}else {
				// 뭐임?
				return 3;
			}
		}
	}
	

}
