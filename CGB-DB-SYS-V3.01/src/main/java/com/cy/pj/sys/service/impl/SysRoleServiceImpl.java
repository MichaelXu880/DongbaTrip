package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值无效");
		//2.查询当前页角色记录
		//2.1设置查询参数
		int pageSize=2;
		Page<SysRole> page=PageHelper.startPage(pageCurrent, pageSize);
		//2.2启动查询操作
		List<SysRole> records=sysRoleDao.findPageObjects(name);
		//3.封装查询结果
		return new PageObject<>(records, (int)page.getTotal(),
				               (int)page.getPages(), pageSize, pageCurrent);
	}
	
	/*
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
	    //1.参数校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页码值无效");
		//2.查询总记录数并校验
		int rowCount=sysRoleDao.getRowCount(name);
		
		if(rowCount==0)
			throw new ServiceException("没有对应的记录");
		//3.查询当前页角色记录
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=
		sysRoleDao.findPageObjects(name, startIndex, pageSize);
		//4.封装查询结果并返回
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}
	*/

}
