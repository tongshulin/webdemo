package com.zerokong.webdemo.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zerokong.webdemo.demo.SystemUtils;
/**
 * HTTP URL 转码
 * @author dh
 *
 */
public class Coder {

	private static Logger logger = LoggerFactory.getLogger(Coder.class);	
	public static void main(String[] args){
		try{
			String s = "assettype%3D%E8%82%A1%E7%A5%A8%E5%9F%BA%E9%87%91%26fundcompany%3D%E5%AE%89%E6%9C%AC%E5%9B%BD%E9%99%85%E5%9F%BA%E9%87%91%E7%AE%A1%E7%90%86%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8%26geograpyDistri%3D%E4%B8%9C%E5%8D%8F%26themesort%3D%2a";
			logger.debug(URLDecoder.decode(s,"UTF-8"));
		}catch(Exception e){
			logger.error(e.toString());
		}
	}
}
