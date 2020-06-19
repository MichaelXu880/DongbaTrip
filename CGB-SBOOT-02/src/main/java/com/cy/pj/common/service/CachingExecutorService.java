package com.cy.pj.common.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cy.pj.common.cache.Cache;

@Service
public class CachingExecutorService {

	private Cache cache;
	@Autowired
	public CachingExecutorService(@Qualifier("softCache")Cache cache) {
		this.cache=cache;
		System.out.println("this.cache="+this.cache);
	}
}
