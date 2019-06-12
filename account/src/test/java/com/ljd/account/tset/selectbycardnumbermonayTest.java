package com.ljd.account.tset;

import java.text.ParseException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ljd.account.entity.Account;
import com.ljd.account.service.AccountService;
import com.ljd.account.util.MyConfig;

public class selectbycardnumbermonayTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountService ud=(AccountService)ac.getBean("accountService");
			   Account at=new Account();
	           at.setCertificateNumber("5453");
		int a= ud.selectbynumber(at.getCertificateNumber());
		 System.out.println("用户是否存在:{存在�?1，不存在-1}"+a);
		 ac.close();
}
	}
