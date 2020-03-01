package com.dq.photomanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dq.photomanagement.bean.Msg;
import com.dq.photomanagement.dao.PhotoMapper;

@Controller
public class PhotoDeleteController {
	@Autowired
	PhotoMapper photo;
	
	
	
}
