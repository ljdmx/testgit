package com.ljd.account.tset;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ljd.account.entity.Account;
import com.ljd.account.service.AccountService;
import com.ljd.account.util.MyConfig;
public class InsertTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountService ud=(AccountService)ac.getBean("accountService");
			   Account at=new Account();
	           at.setAccountNumber("789563");
	           at.setUserName("root");
	           at.setUserPassword("root");
	           at.setCertificateNumber("sdhafj");
	           Date date=new Date();
	   	       SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	           at.setAccountOpeningDate(fmt.format(date));
	           at.setBalanceMoney(1000);
		 ud.insert(at);
		  ac.close();
	   }
}
