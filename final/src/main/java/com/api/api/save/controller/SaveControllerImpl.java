package com.api.api.save.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.api.save.Save;
import com.api.api.save.service.SaveService;

@Controller("saveController")
public class SaveControllerImpl implements SaveController{
	
	@Autowired
	private SaveService saveService;
	
	@RequestMapping(value = "/save", produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<Integer> createSavedBoard(@RequestBody Save save, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("createSavedBoard controller");
		int result = saveService.saveSavedBoard(save);
        if (result > 0) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@RequestMapping(value = "/save", produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	@Override
	public ResponseEntity<Integer> deleteSavedBoard(@RequestBody Save save, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("delete/SavedBoard controller");
		int result = saveService.deleteSavedBoard(save);
        if (result > 0) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
	}

}
