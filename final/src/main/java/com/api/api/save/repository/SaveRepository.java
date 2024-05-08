package com.api.api.save.repository;

import org.springframework.dao.DataAccessException;

import com.api.api.save.Save;

public interface SaveRepository {
	public int insertSavedBoard(Save save) throws DataAccessException;
	public int deleteSavedBoard(Save save) throws DataAccessException;
}
