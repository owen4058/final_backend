package com.api.api.save.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.save.Save;
import com.api.api.save.repository.SaveRepository;

@Service("saveService")
public class SaveServiceImpl implements SaveService {

	@Autowired
	private SaveRepository saveRepository;
	
	@Override
	public int saveSavedBoard(Save save) {
		return saveRepository.insertSavedBoard(save);
	}
	
	@Override
	public int deleteSavedBoard(Save save) {
		return saveRepository.deleteSavedBoard(save);
	}
}
