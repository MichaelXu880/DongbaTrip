package com.cy.pj.activity.service;
import java.util.*;
import com.cy.pj.activity.pojo.*;

public interface ActivityService {
	   int saveActivity(Activity entity);
	   List<Activity> findActivitys();
}
