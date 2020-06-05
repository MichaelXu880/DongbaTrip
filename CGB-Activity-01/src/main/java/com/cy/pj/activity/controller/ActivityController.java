package com.cy.pj.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
     @Autowired
	 private ActivityService activityService;
     
     @RequestMapping("doSaveActivity")
     public String doSaveActivity(Activity entity) {
    	 activityService.saveActivity(entity);
    	 return "forward:doFindActivitys";
     }
     @RequestMapping("doActivityEditUI")
     public String doActivityEditUI() {
    	 return "activity_edit";
     }
	 @RequestMapping("doFindActivitys")
	 public String doFindActivitys(Model model) {
		 List<Activity> list=activityService.findActivitys();
		 model.addAttribute("list", list);
		 return "activity";
	 }
}
