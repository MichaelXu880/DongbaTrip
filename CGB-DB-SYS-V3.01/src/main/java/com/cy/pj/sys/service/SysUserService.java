package com.cy.pj.sys.service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.entity.SysUserDept;

public interface SysUserService {
	
	 int saveObject(SysUser entity,Integer[] roleIds);
	
	 int validById(Integer id,Integer valid);

	 PageObject<SysUserDept> findPageObjects(String username,
			                               Integer pageCurrent);
}
