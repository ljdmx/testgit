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

public class lessMoneySelectTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountService ud=(AccountService)ac.getBean("accountService");
			   Account at=new Account();
	           at.setAccountNumber("122");
	           at.setUserName("liming");
	           at.setUserPassword("4545545");
	           at.setCertificateNumber("5453");
	           Date date=new Date();
	   	       SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	           at.setAccountOpeningDate(fmt.format(date));
	           at.setBalanceMoney(200);
		int a= ud.lessMoneySelect(at.getCertificateNumber(), 100);
		 System.out.println("可以取款:{可以�?1，不可以�?-1}"+a);
		 ac.close();
}}
