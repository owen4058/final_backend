package com.api.api.save.service;

import org.springframework.dao.DataAccessException;

import com.api.api.save.Save;

public interface SaveService {
	public int saveSavedBoard(Save save) throws DataAccessException;
	public int deleteSavedBoard(Save save) throws DataAccessException;
}
