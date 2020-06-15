package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.service.SysMenuService;
import com.sun.javafx.collections.MappingChange.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> list=sysMenuDao.findObjects();
		if(list==null||list.size()==0)
			throw new ServiceException("没有找到对应的菜单");
		return list;
	}

}
