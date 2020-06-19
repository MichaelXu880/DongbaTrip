package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUserDept;
import com.cy.pj.sys.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
    private SysUserDao sysUserDao;
	@Override
	public PageObject<SysUserDept> findPageObjects(String username, Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页码值无效");
		//2.设置分页参数
		int pageSize=3;
		Page<SysUserDept> page=PageHelper.startPage(pageCurrent,pageSize);
		//3.查询当前页记录
		List<SysUserDept> records=sysUserDao.findPageObjects(username);
		return new PageObject<>(records, (int)page.getTotal(), (int)page.getPages(), pageSize, pageCurrent);
	}

}
