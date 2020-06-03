package com.cy.pj.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/goods/doFindGoods")
	public String doFindGoods(Model model) {
		List<Goods> list=goodsService.findGoods();
		model.addAttribute("list", list);
		return "goods";
	}
}







