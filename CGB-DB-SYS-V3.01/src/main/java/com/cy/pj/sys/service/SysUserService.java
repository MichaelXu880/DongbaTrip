package com.cy.pj.sys.service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.entity.SysUserDept;

public interface SysUserService {

	 PageObject<SysUserDept> findPageObjects(String username,
			                               Integer pageCurrent);
}
