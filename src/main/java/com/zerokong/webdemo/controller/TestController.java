package com.zerokong.webdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class TestController {
	private static Logger logger = LoggerFactory.getLogger(TestController.class);	
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("1");
		logger.info("进入了系统，并且得到了ID："+id);
		return mv;
	}
	
	@RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
	public String getUserInfo(HttpServletRequest request,HttpServletResponse response){
		logger.info("getUserInfo");
		return "cc";
	}
	
}
