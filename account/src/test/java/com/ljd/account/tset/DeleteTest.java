package com.ljd.account.tset;

import java.text.ParseException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ljd.account.service.AccountService;
import com.ljd.account.util.MyConfig;

public class DeleteTest {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(InsertTest.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   AccountService ud=(AccountService)ac.getBean("accountService");
		 int id=2;
		 int sa;
		  sa=ud.delete(id);
		  if(sa==1) {
		    System.out.println("删除成功");
		  }else {
			  System.out.println("删除失败");
		  }
		  ac.close();
	   }
}
