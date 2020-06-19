package com.cy.pj.shopping.service;

import org.springframework.stereotype.Component;

@Component
public class CardPayService implements PayService {

	@Override
	public void pay() {
		System.out.println("card pay service");
	}

}
