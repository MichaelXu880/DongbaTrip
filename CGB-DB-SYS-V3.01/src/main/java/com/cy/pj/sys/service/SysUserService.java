package com.cy.pj.sys.service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.entity.SysUserDept;

public interface SysUserService {
	
	 int validById(Integer id,Integer valid);

	 PageObject<SysUserDept> findPageObjects(String username,
			                               Integer pageCurrent);
}
