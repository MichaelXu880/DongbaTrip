package com.cy.pj.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class ShopingService {

	private PayService payService;
	@Autowired
	public ShopingService(@Qualifier("cardPayService")PayService payService) {
		this.payService=payService;
	}
	/**支付*/
	public void doPayService() {
		payService.pay();
	}
}
