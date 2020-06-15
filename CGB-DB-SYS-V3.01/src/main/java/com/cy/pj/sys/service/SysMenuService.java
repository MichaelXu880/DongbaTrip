package com.cy.pj.sys.service;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 此接口中定义菜单模块的业务操作标准
 */
public interface SysMenuService {
     /**
      * 查询所有菜单以及菜单对应的上级菜单
      * @return
      */
	 List<Map<String,Object>> findObjects();
}
