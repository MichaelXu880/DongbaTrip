package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysUserService;

@RestController
@RequestMapping("/user/")
public class SysUserController {
     @Autowired
	 private SysUserService sysUserService;
     
     @RequestMapping("doValidById")
     public JsonResult doValidById(Integer id,Integer valid) {
    	 sysUserService.validById(id, valid);
    	 return new JsonResult("update ok");
     }
     
     @RequestMapping("doFindPageObjects")
     public JsonResult doFindPageObjects(String username,Integer pageCurrent) {
    	 return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
     }
}
