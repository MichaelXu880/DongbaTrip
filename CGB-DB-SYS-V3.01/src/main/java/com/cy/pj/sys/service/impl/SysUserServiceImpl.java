package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.common.exception.ServiceException;
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
	public int validById(Integer id, Integer valid) {
	    //1.参数校验
		if(id==null||id<1)
			throw new IllegalArgumentException("id值无效");
		if(valid!=1&&valid!=0)
			throw new IllegalArgumentException("状态值无效");
		//2.修改用户状态
		int rows=sysUserDao.validById(id, valid, "admin");//后续会将用户名修改为登陆用户，现在是假数据
		//3.验证结果
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}
	
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
