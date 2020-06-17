package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PerpetualCacheTests {

	@Autowired
	private PerpetualCache perpetualCache01;
	
	@Autowired
	private PerpetualCache perpetualCache02;
	
	@Test
	void testPrototypeScope() {
		//通过测试如下输出为false
		System.out.println(perpetualCache01==perpetualCache02);
	}
	
}
