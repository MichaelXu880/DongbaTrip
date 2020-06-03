package com.cy.pj.goods.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;

@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger log=
       LoggerFactory.getLogger(GoodsServiceImpl.class);
    
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> findGoods() {
		long t1=System.currentTimeMillis();
		List<Goods> goods=goodsDao.findGoods();
		long t2=System.currentTimeMillis();
		log.info("execute time {}",t2-t1);
		return goods;
	}

}
