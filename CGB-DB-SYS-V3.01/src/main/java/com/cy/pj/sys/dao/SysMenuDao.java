package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sun.javafx.collections.MappingChange.Map;

@Mapper
public interface SysMenuDao {
     /**
      * 查询菜单表中所有的菜单记录
      * 一行菜单记录映射为一个map对象(key为字段名，值为字段对应值)
      * @return
      */
	 List<Map<String,Object>> findObjects();
}



