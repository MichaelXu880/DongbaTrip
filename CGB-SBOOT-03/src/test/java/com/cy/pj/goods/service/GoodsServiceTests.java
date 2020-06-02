package com.cy.pj.goods.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.goods.pojo.Goods;

@SpringBootTest
public class GoodsServiceTests {

	@Autowired
	private GoodsService goodsService;
	
	@Test
	void testFindObjects() {
		List<Goods> list=goodsService.findObjects();
		list=goodsService.findObjects();
		for(Goods g:list) {
			System.out.println(g);//g.toString()
		}
	}
	
}
