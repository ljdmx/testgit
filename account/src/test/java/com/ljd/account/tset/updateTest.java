package com.ljd.account.tset;

import java.text.ParseException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ljd.account.entity.Account;
import com.ljd.account.service.AccountService;
import com.ljd.account.util.MyConfig;

public class updateTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountService ud=(AccountService)ac.getBean("accountService");
			   int id=2;
			   Account at=new Account();
	           at.setUserPassword("6666");
	           at.setBalanceMoney(1235);
		 ud.update(at, id);
		  ac.close();
}
	}
