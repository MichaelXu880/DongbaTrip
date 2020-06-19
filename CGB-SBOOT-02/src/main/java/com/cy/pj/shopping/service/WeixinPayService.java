package com.cy.pj.shopping.service;

import org.springframework.stereotype.Component;

@Component
public class WeixinPayService implements PayService {

	@Override
	public void pay() {
		System.out.println("weixin pay service");
	}

}
