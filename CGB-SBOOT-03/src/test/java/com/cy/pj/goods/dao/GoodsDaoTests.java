package com.cy.pj.goods.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsDaoTests {
	/**
	 * FAQ: goodsDao指向的对象是谁？(两种方式)
	 */
	@Autowired
	private GoodsDao goodsDao;
	
	@Test
	void testDeleteObjects() {
		int rows=goodsDao.deleteObjects(12);
		System.out.println("delete.rows="+rows);
	}
	
	@Test
    void testDeleteById() {
		/*
		 * FAQ? deleteById方法内部做了什么事情。(与数据库会话)
		 * 1)第一步：通过会话工厂(SqlSessionFactory)创建一个SqlSession对象
		 * 2)第二步：开启事务
		 * 3)第三步：通过sqlSession实现与数据库的会话(最底层就是基于jdbc实现)
		 * 4)第四步：提交或回滚事务
		 * 5)第五步：释放资源
		 */
    	int rows=goodsDao.deleteById(10);
    	System.out.println("rows="+rows);
    }
}
