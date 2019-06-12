package com.ljd.account.tset;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ljd.account.entity.Account;
import com.ljd.account.service.AccountService;
import com.ljd.account.util.MyConfig;
public class selectAllTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountService ud=(AccountService)ac.getBean("accountService");
	            List<Account> accounts=new ArrayList<Account>();
	            accounts=ud.select();
	            for(Account al:accounts){
	  	    	  System.out.println(al);
	  	            }
		  ac.close();
}
	}
