package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysRole;

@Mapper
public interface SysRoleDao {
     /**
      * 基于角色名统计角色个数
      * @param name
      * @return
      */
	 //int getRowCount(String name);
	 /**
	  * 基于条件查询当前页记录
	  * @param name
	  * @param startIndex
	  * @param pageSize
	  * @return
	  */
	 //List<SysRole> findPageObjects(String name,Integer startIndex,Integer pageSize);
	  
	  List<SysRole> findPageObjects(String name);
	 
}




