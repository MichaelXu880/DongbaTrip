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

import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import com.cy.pj.activity.util.ExcelUtils;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
	
     @Autowired
	 private ActivityService activityService;
     @RequestMapping("doExport")
     @ResponseBody
     public void doExport(Integer id,HttpServletResponse response) {
    	 Activity aty=activityService.findById(id);
    	 List<Map<String , String>> fieldList = new ArrayList<>();
         Map<String , String> field = new HashMap<>();
         field.put(ExcelUtils.FIELDNAME , "title");
         field.put(ExcelUtils.FIELDZNAME , "标题");
         fieldList.add(field);

         field = new HashMap<>();
         field.put(ExcelUtils.FIELDNAME , "category");
         field.put(ExcelUtils.FIELDZNAME , "分类");
         fieldList.add(field);
         
         Workbook workbook = ExcelUtils.dealWorkbook(Arrays.asList(aty) , fieldList);

         OutputStream out = null;
         try {
             String fileName = URLEncoder.encode("activity.xls", "UTF-8");
             response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
             // 这句话的意思，是让浏览器用utf8来解析返回的数据
             response.setHeader("Content-type", "text/html;charset=UTF-8");
             //设置响应为excel
             response.setContentType("application/vnd.ms-excel");

             //将文件输出
             out = response.getOutputStream();
             workbook.write(out);
             out.flush();
         } catch (Exception e) {
            // logger.error("response error " , e);
         } finally {
             IOUtils.closeQuietly(out);
         }
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
