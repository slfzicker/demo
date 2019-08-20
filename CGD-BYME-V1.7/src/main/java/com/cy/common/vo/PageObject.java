package com.cy.common.vo;

import java.io.Serializable;
import java.util.List;

import com.cy.common.vo.PageObject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 261397120618305385L;
	/**当前页的页码值*/
	private Integer pageCurrent;
	/**页面大小*/
	private Integer pageSize;
	/**总行数(通过查询获得)*/
	private Integer rowCount;
	/**总页数(通过计算获得)*/
	private Integer pageCount;
	/**当前页记录*/
	private List<T> records;
	public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;
		this.pageCount=(this.rowCount-1)/this.pageSize+1;
	}
}