package com.zerokong.webdemo.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SystemUtils {
	private static Logger logger = LoggerFactory.getLogger(SystemUtils.class);	
	public static void main(String[] args){
		logger.debug("这里是DEBUG日志");
		logger.info("这里是INFO日志");
		logger.warn("这里是WARN日志");
		logger.error("这里是ERROR日志");
	}
}
