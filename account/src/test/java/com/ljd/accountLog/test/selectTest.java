package com.ljd.accountLog.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ljd.account.entity.AccountLog;
import com.ljd.account.service.AccountLogService;
import com.ljd.account.tset.InsertTest;
import com.ljd.account.util.MyConfig;
import com.ljd.account.util.Pager;

public class selectTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountLogService ud=(AccountLogService)ac.getBean("accountLogService");
	            List<AccountLog> accountlogs=new ArrayList<AccountLog>();
	            accountlogs=ud.select();
	            Pager<AccountLog> p = new Pager<AccountLog>(accountlogs);
	            accountlogs=p.getDatalist();
			 for(AccountLog al:accountlogs){
	    	  System.out.println(al);
	            }
		  ac.close();
}}