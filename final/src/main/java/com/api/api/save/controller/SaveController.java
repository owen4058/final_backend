package com.api.api.save.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.api.api.save.Save;

public interface SaveController {
	public ResponseEntity<Integer> createSavedBoard(Save save, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
	public ResponseEntity<Integer> deleteSavedBoard(Save save, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
}
