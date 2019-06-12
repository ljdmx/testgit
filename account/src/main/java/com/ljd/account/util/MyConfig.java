package com.ljd.account.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.ljd.account.dao","com.ljd.account.service"})
@ImportResource("classpath:spring.xml")
public class MyConfig {

}
