package com.cy.pj.common.cache;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PerpetualCache {

	public PerpetualCache() {
		System.out.println("PerpetualCache()");
	}
}
