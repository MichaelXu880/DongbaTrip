package com.cy.pj.activity.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;
import com.cy.pj.activity.pojo.*;
@Mapper
public interface ActivityDao {

	 @Select("select * from tb_activity")
	 List<Activity> findActivitys();
}
