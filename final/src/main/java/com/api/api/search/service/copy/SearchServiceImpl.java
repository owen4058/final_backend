package com.api.api.search.service.copy;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.board.BoardForm;
import com.api.api.forum.ForumForm;
import com.api.api.search.repository.copy.SearchRepository;


@Service("searchService")
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchRepository searchRepository;

	@Override
	public List<ForumForm> searchforum(Map<String, Object> searchinfo) {
		return searchRepository.searchforum(searchinfo);
	}

	@Override
	public List<BoardForm> searchboardtitle(Map<String, Object> searchinfo) {
		return searchRepository.searchboardtitle(searchinfo);
	}

	@Override
	public List<BoardForm> searchboardcontent(Map<String, Object> searchinfo) {
		return searchRepository.searchboardcontent(searchinfo);
	}

}
