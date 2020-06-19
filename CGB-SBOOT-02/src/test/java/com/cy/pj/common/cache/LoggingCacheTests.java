package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggingCacheTests {

	@Autowired
	private LoggingCache loggingCache;
	
	@Test
	void testLogingCache() {
		System.out.println(loggingCache);
	}
	
}
