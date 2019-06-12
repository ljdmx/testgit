package com.ljd.accountLog.test;

import java.text.ParseException;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ljd.account.service.AccountLogService;
import com.ljd.account.util.MyConfig;

public class deleteTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(deleteTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountLogService ud=(AccountLogService)ac.getBean("accountLogService");
	            ud.delete(35,5);
		  ac.close();
}
}