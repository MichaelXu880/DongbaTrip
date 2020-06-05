package com.cy.pj.goods.service;
import java.util.List;
import com.cy.pj.goods.pojo.Goods;

/**
 * 商品模块业务层接口，负责商品业务的定义及处理
 */
public interface GoodsService {
	
	 
   
	 int saveObject(Goods entity);
	 List<Goods> findObjects();
	 int deleteById(Integer id);
}
