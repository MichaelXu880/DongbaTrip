package com.cy.pj.goods.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;

/**
 * Spring MVC中的后端处理器(Handler)
 * @author pc
 */
//http://localhost:8080/goods/doGoodsUI
@Controller
@RequestMapping("/goods/")
public class GoodsController {
	  @Autowired
	  private GoodsService goodsService;
	  
	  @RequestMapping("doDeleteById")
	  public String doDeleteById(Integer id,Model model) {
		  goodsService.deleteById(id);
		  //获取商品信息
		  List<Goods> list=goodsService.findObjects();
		  //将商品信息存储到请求作用域
		  model.addAttribute("list", list);
		  return "goods";//viewname
		  //return "redirect:doGoodsUI";//重定向
	  }
	  
	  @RequestMapping("doGoodsUI")
	  public String doGoodsUI(Model model) {//Model为springmvc中存储数据的一个对象
		  //获取商品信息
		  List<Goods> list=goodsService.findObjects();
		  //将商品信息存储到请求作用域
		  model.addAttribute("list", list);
		  return "goods";//viewname
		  //1)此view会返回给DispatcherServlet对象
		  //2)DispatcherServlet对象将view传递给视图解析器ViewResolver
		  //3)ViewResolver会对view的名字进行解析(例如添加前缀，后缀,..)
		  //4)ViewResolver会将结果返回给DispatcherServlet对象。
		  //5)DispatcherServlet将结果响应到客户端。
	  }
}



