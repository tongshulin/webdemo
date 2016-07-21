package com.zerokong.webdemo.service;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;  
import org.springframework.security.core.GrantedAuthority;  
//import org.springframework.security.core.authority.GrantedAuthorityImpl;  
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zerokong.webdemo.dao.UserDAO;

@Service("userService")
public class UserService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	

	private UserDAO userDAO;
}
