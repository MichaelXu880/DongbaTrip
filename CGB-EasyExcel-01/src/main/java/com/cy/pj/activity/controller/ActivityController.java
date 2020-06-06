package com.cy.pj.activity.controller;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.excel.EasyExcel;
import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
	
     @Autowired
	 private ActivityService activityService;
     @RequestMapping("doExport")
     public String doExport(Integer id) {
    	 Activity aty=activityService.findById(id);
    	 EasyExcel.write("d:/activity.xlsx", Activity.class)
    	 .sheet("模板").doWrite(Arrays.asList(aty));
    	 return "forward:doFindActivitys";
     }
     
     @RequestMapping("doFindById")
     public String doFindById(Integer id,Model model) {
    	 Activity aty=activityService.findById(id);
    	 model.addAttribute("aty", aty);
    	 return "forward:doFindActivitys";
     }
     
     @RequestMapping("doDeleteById")
     public String doDeleteById(Integer id) {
    	 activityService.deleteById(id);
    	 return "forward:doFindActivitys";
     }
     
     @RequestMapping("doSaveActivity")
     public String doSaveActivity(Activity entity) {
    	 activityService.saveActivity(entity);
    	 return "redirect:doFindActivitys";
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
