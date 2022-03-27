package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequestDTO;

@RestController
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<String> authenticate(@RequestBody LoginRequestDTO loginRequestDTO) {
		logger.info("[LoginController][authenticate][BEGIN][username: " + loginRequestDTO.getUsername() + "]");
		logger.info("[LoginController][authenticate][END]");
		return ResponseEntity.ok().body("Hello!");
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> test() {		
		logger.info("[LoginController][test][BEGIN]");
		return ResponseEntity.ok().body("Test!!!");
	}
	
}
