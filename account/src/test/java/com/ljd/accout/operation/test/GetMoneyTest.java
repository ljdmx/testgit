package com.ljd.accout.operation.test;


import java.text.ParseException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ljd.account.service.AccountOperationService;
import com.ljd.account.tset.InsertTest;
import com.ljd.account.util.MyConfig;

public class GetMoneyTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
		   ac=new AnnotationConfigApplicationContext(MyConfig.class);
		   AccountOperationService ud=(AccountOperationService)ac.getBean("accountOperationService");
		   System.out.println("取款:"+ud.select("5453"));	 
		 ud.get("5453", 200);
		 System.out.println("取款:"+ud.select("5453"));
		
		 ac.close();
}
	}
