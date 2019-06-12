package com.ljd.accout.operation.test;


import java.text.ParseException;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ljd.account.service.AccountOperationService;
import com.ljd.account.tset.InsertTest;
import com.ljd.account.util.MyConfig;

public class TransferTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountOperationService ud=(AccountOperationService)ac.getBean("accountOperationService");
			   System.out.println("转账前A:"+ud.select("5453"));
			   System.out.println("转账前B:"+ud.select("sdhafj"));
			   ud.transfer("5453","sdhafj�?",300);
		       System.out.println("转账后A:"+ud.select("5453"));
		      System.out.println("转账后B�:"+ud.select("sdhafj"));
		 ac.close();
}
}
