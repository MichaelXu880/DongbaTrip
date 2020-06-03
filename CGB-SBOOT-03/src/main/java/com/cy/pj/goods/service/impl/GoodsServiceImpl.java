package com.cy.pj.goods.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
/**
 * 商品业务层对象实现
 * 1)核心业务(例如存钱-将金额更新到自己的账户)
 * 2)拓展业务(存储过程中进行日志的记录，权限校验，。。。)
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	private static final Logger logger = 
			LoggerFactory.getLogger(GoodsServiceImpl.class);
	@Autowired
	private GoodsDao goodsDao;
	
	
	@Override
	public int saveObject(Goods entity) {
		//1.对参数进行校验
		//2.保存对象
		long start=System.currentTimeMillis();
		int rows=goodsDao.insertObject(entity);
		long end=System.currentTimeMillis();
		logger.info("execute time: {}",(end-start));
		return rows;
	}
	
	@Override
	public int deleteById(Integer id) {
		long start=System.currentTimeMillis();
		int rows=goodsDao.deleteById(id);
		long end=System.currentTimeMillis();
		logger.info("execute time: {}",(end-start));
		return rows;
	}
	
	@Override
	public List<Goods> findObjects() {
		long start=System.currentTimeMillis();
		List<Goods> list=goodsDao.findObjects();
		long end=System.currentTimeMillis();
		//System.out.println("execute time:"+(end-start));
		logger.info("execute time: {}",(end-start));
		return list;
	}
}
