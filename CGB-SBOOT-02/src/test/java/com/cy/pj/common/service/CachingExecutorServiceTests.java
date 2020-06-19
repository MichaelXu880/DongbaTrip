package com.cy.pj.common.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CachingExecutorServiceTests {

	 @Autowired
	 private CachingExecutorService cachingExecutorService;
	 @Test
	 void testCachingExecutorService() {
		 System.out.println(cachingExecutorService);
	 }
}
