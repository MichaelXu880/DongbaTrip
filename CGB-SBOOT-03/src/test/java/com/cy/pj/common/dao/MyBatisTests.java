package com.cy.pj.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisTests {
     @Autowired
	 private SqlSession sqlSession;
	 @Test
	 void testSqlSession() {
		 System.out.println(sqlSession);
		 System.out.println(sqlSession.getConnection());
	 }
}
