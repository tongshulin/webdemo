package com.zerokong.webdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class SecurityController {
	private static Logger logger = LoggerFactory.getLogger(SecurityController.class);	
	
	@RequestMapping(value="/userid/{userId}/userpwd/{userPwd}/admin")
	public String adminLogin(@PathVariable("userId") String userId,@PathVariable("userPwd") String userPwd){
		logger.info("准备登入管理员后台:" +userId + ":" + userPwd);
		return "admin";
	}
	
	@RequestMapping(value="/userid/{userId}/userpwd/{userPwd}/common")
	public String commonLogin(@PathVariable("userId") String userId,@PathVariable("userPwd") String userPwd){
		logger.info("准备进入普通页面:"+userId + "--" + userPwd);
		return "common";
	}
}
