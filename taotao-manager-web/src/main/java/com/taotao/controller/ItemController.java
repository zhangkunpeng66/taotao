package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	// url:/item/list
	// method:get   请求方法是get，需要在mapper映射中设置get方式
	// 参数：page,rows
	// 返回值json
	@RequestMapping(value="/item/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		// 1.引入服务
		// 2.注入服务
		// 3.调用服务的方法
		
		return itemService.getItemList(page, rows);
	}

}
