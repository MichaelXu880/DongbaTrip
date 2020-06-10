package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import com.cy.pj.sys.entity.*;
import java.util.*;
/**
 * 日志模块数据层接口：定义数据访问规范
 */
@Mapper
public interface SysLogDao {
     /**
      * 基于查询条件统计记录总数
      * @param username 查询条件
      * @return 查询到的记录总数
      */
	 int getRowCount(String username);
	 /**
	  * 基于条件查询当前页的记录
	  * @param username 查询条件
	  * @param startIndex 起始位置(当前页的起始位置)
	  * @param pageSize 页面大小(每页最多显示多少条记录)
	  * @return 查询到的当前的日志记录
	  */
	 List<SysLog> findPageObjects(String username,
			 Integer startIndex,Integer pageSize);
}






