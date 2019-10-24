package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		// 1. 设置的分页信息，使用pageHelper
		if(page==null)page=1;
		if(rows==null)rows=30;
		PageHelper.startPage(page, rows);
		// 2. 注入mapper
		// 3.创建example 对象  不需要设置查询条件
		TbItemExample example = new TbItemExample();
		// 4.根据mapper调用查询所有数据方法
		List<TbItem> list = itemMapper.selectByExample(example);
		// 5.获取分页的信息
		PageInfo<TbItem> info = new PageInfo<>(list);
		// 6.封装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		
//		System.out.println("total-----"+info.getTotal());
//		System.out.println("list数据"+info.getList());
//		
//		for(TbItem item : list){
//			System.out.println("itemtitle="+item.getTitle()+"itemid="+item.getId()+"itemPrice="+item.getPrice());
//		}
		// 7.返回
		return result;
	}

}
