package com.cy.pj.sys.service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.entity.SysRole;

public interface SysRoleService {
	/**
	 * 基于角色id删除角色关系数据以及自身信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	 
	PageObject<SysRole> findPageObjects(
			 String name,Integer pageCurrent);
	 
}
