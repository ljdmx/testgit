package com.ljd.rootuser.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ljd.account.entity.RootUser;
import com.ljd.account.service.RootUserService;
import com.ljd.account.util.MyConfig;

public class RootUserSelectAll {
	@Test
	   public void t1() throws ParseException {
		   Logger log=LoggerFactory.getLogger(RootUserAdd.class);
			log.info("success");
			log.debug("debug");
			AnnotationConfigApplicationContext ac;
			   ac=new AnnotationConfigApplicationContext(MyConfig.class);
			   RootUserService ud=(RootUserService)ac.getBean("rootUserService");
		  List<RootUser> rus=new ArrayList<RootUser>();
		 rus=ud.selectAll();
		 System.out.println(rus);
		  ac.close();
	   }
}
