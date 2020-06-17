package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SynchronizedCacheTests {

	  @Autowired
	  private SynchronizedCache synchronizedCache01;
	  @Autowired
	  private SynchronizedCache synchronizedCache02;
	  
	  @Test
	  void testSingletonScope() {
		  //通过测试如下输出为true，表示两个引用指向同一个对象
		  System.out.println(synchronizedCache01==synchronizedCache02);
	  }
}
