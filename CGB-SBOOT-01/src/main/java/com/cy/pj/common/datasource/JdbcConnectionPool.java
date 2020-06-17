package com.cy.pj.common.datasource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnectionPool {

	public JdbcConnectionPool() {
		System.out.println("JdbcConnectionPool()");
	}
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	@PreDestroy
	public void close(){
		System.out.println("close()");
	}
}
