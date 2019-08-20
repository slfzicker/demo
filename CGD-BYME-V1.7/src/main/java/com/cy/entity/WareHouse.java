package com.cy.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class WareHouse implements Serializable{
   /**
    * 仓库实体类
    */
	private static final long serialVersionUID = 6501018257872979498L;
		private Integer id;
         private String name;//名称
         private String standard;//规格
         private String costPrice;//成本价格
         private String quantity;//数量
         private String costTotalPrice;//成本总价格
         private String Admin;//管理人员
         
}
