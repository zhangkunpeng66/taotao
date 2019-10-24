package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 显示页面
 * @author 80535
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("/")
	public String shwoIndex(){
		return "index";
	}
	
	// 显示商品的查询页面
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}

}
