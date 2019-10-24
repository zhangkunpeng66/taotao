package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * datagrid 展示数据的pojo 包括商品的pojo
 * @author 80535
 *
 */
public class EasyUIDataGridResult implements Serializable {
	
	private Integer total; // 记录分页查询的总条数
	private List rows; // 记录每页查询多少行数据
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	

}
