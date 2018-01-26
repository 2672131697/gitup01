package com.tmj.bookshop.controller;

import com.tmj.bookshop.biz.IBookBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/input")
public class InputController {

	public InputController() {
        super();
	}

	@RequestMapping("/{dir}/{page}")
	public String toDirOfPage(@PathVariable String dir,
			@PathVariable String page) {
		String path = dir + "/" + page;
		return path;
	}

	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page) {
		return page;
	}


}




