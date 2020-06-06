package com.cy.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.activity.pojo.Activity;

@SpringBootTest
public class LombokTests {

	  @Test
	  public void testActivity() {
		  Activity aty=new Activity();
		  aty.setTitle("Title-A");
		  String title=aty.getTitle();
		  System.out.println(title);
		  System.out.println(aty);
	  }
}





