package com.cy.pj.activity.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;
import com.cy.pj.activity.pojo.*;
@Mapper
public interface ActivityDao {
	
	
	 int insertActivity(Activity entity);

	 @Select("select * from tb_activity order by createdTime desc")
	 List<Activity> findActivitys();
}
