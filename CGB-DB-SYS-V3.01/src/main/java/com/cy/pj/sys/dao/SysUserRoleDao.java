package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleDao {
     /**
      * 基于角色id删除用户和角色关系数据
      * @param id
      * @return
      */
	 @Delete("delete from sys_user_roles where role_id=#{id}")
	 int deleteObjectsByRoleId(Integer id);
}
