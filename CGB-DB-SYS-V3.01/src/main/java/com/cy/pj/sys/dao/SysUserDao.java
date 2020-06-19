package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysUserDept;

@Mapper
public interface SysUserDao {

	 /**
	  * 基于条件查询用户以及用户对应的部门信息
	  * @param username
	  * @return
	  */
	 List<SysUserDept> findPageObjects(String username);
}
