package com.cy.pj.common.cache;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SynchronizedCache {

	public SynchronizedCache() {
		System.out.println("SynchronizedCache()");
	}
}
