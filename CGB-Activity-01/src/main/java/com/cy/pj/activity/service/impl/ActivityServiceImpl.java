package com.cy.pj.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.activity.dao.ActivityDao;
import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public Activity findById(Integer id) {
		return activityDao.findById(id);
	}
	
	@Override
	public int deleteById(Integer id) {
		//System.out.println();
		// TODO Auto-generated method stub
		return activityDao.deleteById(id);
		
	}
	@Override
	public int saveActivity(Activity entity) {
		if(entity.getId()==null) {
		  return activityDao.insertActivity(entity);
		}else {
		  return activityDao.updateActivity(entity);
		}
	}
	
	@Override
	public List<Activity> findActivitys() {
		//.....
		return activityDao.findActivitys();
	}

}




