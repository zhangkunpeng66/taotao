package com.taotao.test.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

	@Test
	public void testhelper(){
		// 1.初始化spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		// 2.获取mapper的代理对象
		TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
		// 3.设置分页信息
		PageHelper.startPage(1, 3); // 从第一条数据开始，查询3条记录，该设置紧跟着的第一个select语句才会被分页，后面的就不会了
		// 4.调用mapper的方法查询数据
		TbItemExample example = new TbItemExample(); // 条件查询，如果不加条件就是select * from tb_item;
		List<TbItem> list = itemMapper.selectByExample(example);
		List<TbItem> list2 = itemMapper.selectByExample(example);
		
		// 取出分页信息
		PageInfo<TbItem> info = new PageInfo<>(list);
		
		System.out.println("第一个分页的list集合的长度"+list.size());
		System.out.println("第二个分页的list集合的长度"+list2.size());
		
		info.getList();
		
		// 5.遍历结果集  打印
		System.out.println("查询第二个的总记录数"+info.getTotal());
		for(TbItem item : list){
			System.out.println(item.getId()+">>>>>商品名称"+item.getTitle());
		}
	}
}
