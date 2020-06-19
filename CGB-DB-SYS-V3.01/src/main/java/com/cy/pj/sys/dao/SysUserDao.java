package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.sys.entity.SysUserDept;

@Mapper
public interface SysUserDao {
     /**
      * 禁用或启用用户信息
      * @param id
      * @param valid
      * @param username
      * @return
      */
	 @Update("update sys_users set valid=#{valid},modifiedUser=#{modifiedUser},modifiedTime=now() where id=#{id}")
	 int validById(Integer id,Integer valid,String modifiedUser);
	 /**
	  * 基于条件查询用户以及用户对应的部门信息
	  * @param username
	  * @return
	  */
	 List<SysUserDept> findPageObjects(String username);
}
