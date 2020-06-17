package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public int deleteObject(Integer id) {
		//1.参数校验
		if(id==null||id<1)
		 throw new IllegalArgumentException("id值无效");
		//2.删除关系数据
		//2.1删除角色菜单关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		//2.2删除角色和用户关系数据
		sysUserRoleDao.deleteObjectsByRoleId(id);
		//3.删除自身信息
		int rows=sysRoleDao.deleteObject(id);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}
	
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
