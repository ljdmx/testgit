package com.ljd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ljd.account.entity.Account;
import com.ljd.account.entity.Credit;
import com.ljd.account.service.AccountService;
import com.ljd.account.service.CreditService;
import com.ljd.account.util.Pager;


@Controller
@RequestMapping("/admin")
public class AccountController {
   @Autowired
   private CreditService creditService;
   @Autowired(required=true)
   private AccountService accountService;
   public void setAs(AccountService accountService) {
	this.accountService = accountService;
   }
 @RequestMapping("/login")
 public String longin(@RequestParam String userName,@RequestParam String userPassword ,Model model) {
	 Account a=accountService.selectLog(userName, userPassword);
	 if(a!=null) {
	 model.addAttribute(a);
	 return "success";
	 }else{
		 model.addAttribute("success",1);
		 return "index";
	 }
 } 
 @RequestMapping("/register")
 public String register(Account account,HttpServletRequest re,Model model){
	 if(account.getUserName().length() < 1 
			 || account.getCertificateNumber().length() < 1 
			 || account.getAccountNumber().length() < 1 
			 || account.getUserPassword().length() < 1 ){
		 model.addAttribute("register",1);
		 return "index";
	 }
	    Date date=new Date();
	    SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    account.setAccountOpeningDate(fmt.format(date));
	    account.setBalanceMoney(0);
	    if(accountService.selectbynumber(account.getCertificateNumber())!=1 ) {
		   accountService.insert(account);
		   Credit credit = new Credit();
		   Account a=accountService.selectLog(account.getUserName(),account.getUserPassword());
		   credit.setAccountId(a.getId());
		   creditService.add(credit);
	       model.addAttribute("register",0);
	       return "index";
	    }else{
	      model.addAttribute("register",1);
	      return "index";
	    }
 } 
 @RequestMapping("/selectAll")
 public String selectall(ModelMap mm){
	 List<Account> list=new ArrayList<Account>();
	 list=accountService.select();
	 Pager<Account> p = new Pager<Account>(list);
	 mm.addAttribute("currentPage",p.getCurrentPage());
	 mm.addAttribute("totalRecord",p.getTotalRecord());
	 mm.addAttribute("totalPage",p.getTotalPage());
	 mm.addAttribute("list", p.getDatalist());
     return "showaccount"; 
 }
 @RequestMapping("/update")
 public String update(int id,String userPassword,float balanceMoney,ModelMap mm){
	 Account a=new Account();
	 a.setId(id);
	 a.setUserPassword(userPassword);
	 a.setBalanceMoney(balanceMoney);
	 accountService.update(a, id);
	 List<Account> list=accountService.select();
	 Pager<Account> p = new Pager<Account>(list);
	 mm.addAttribute("currentPage",p.getCurrentPage());
	 mm.addAttribute("totalRecord",p.getTotalRecord());
	 mm.addAttribute("totalPage",p.getTotalPage());
	 mm.addAttribute("list", p.getDatalist());
     return "showaccount"; 
 }
 @RequestMapping("/delete/{id}")
 public String delete1(@PathVariable int id,ModelMap mm){
	 accountService.delete(id);
	 List<Account> list=accountService.select();
	 Pager<Account> p = new Pager<Account>(list);
	 mm.addAttribute("currentPage",p.getCurrentPage());
	 mm.addAttribute("totalRecord",p.getTotalRecord());
	 mm.addAttribute("totalPage",p.getTotalPage());
	 mm.addAttribute("list", p.getDatalist());
	 return "showaccount";
	 
 }
 @RequestMapping("/add")
 public String add(Account account,Model model){
	 System.out.println(account.toString());
	 if(account.getUserName().length() < 1 
			 || account.getCertificateNumber().length() < 1 
			 || account.getAccountNumber().length() < 1 
			 || account.getUserPassword().length() < 1 ){
		 List<Account> list=accountService.select();
		 model.addAttribute("list", list); 	 
		 model.addAttribute("register",1);
		 return "showaccount";
	 }
	    Date date=new Date();
	    SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    account.setAccountOpeningDate(fmt.format(date));
	    account.setBalanceMoney(0);
	    if(accountService.selectbynumber(account.getCertificateNumber())!=1 ) {
		   accountService.insert(account); 
		   Credit credit = new Credit();
		   Account a=accountService.selectLog(account.getUserName(),account.getUserPassword());
		   credit.setAccountId(a.getId());
		   creditService.add(credit);
		   model.addAttribute("register",0);
	    }
	    List<Account> list=accountService.select();
	    Pager<Account> p = new Pager<Account>(list);
	    model.addAttribute("currentPage",p.getCurrentPage());
	    model.addAttribute("totalRecord",p.getTotalRecord());
	    model.addAttribute("totalPage",p.getTotalPage());
	    model.addAttribute("list", p.getDatalist());	 
	    return "showaccount";
	
 } 
 @RequestMapping("/selectByUserName")
 public String selectByUserName(@RequestParam String userName , ModelMap mm){
	 if(userName.length()<1){
		 mm.addAttribute("select", 1);
		 return "showaccount";
	 }
	  
	 List<Account> list=accountService.selectByUserName(userName);
	 if(list.size()<1){
		 mm.addAttribute("select", 1);
		 return "showaccount";
	 }
	 Pager<Account> p = new Pager<Account>(list);
	 mm.addAttribute("currentPage",p.getCurrentPage());
	 mm.addAttribute("totalRecord",p.getTotalRecord());
	 mm.addAttribute("totalPage",p.getTotalPage());
	 mm.addAttribute("list", p.getDatalist());
     
     return "showaccount"; 
 }
 @RequestMapping("/selectByAccountNumber")
 public String selectByAccountNumber(@RequestParam String accountNumber  ,ModelMap mm){
	 if(accountNumber.length()<1){
		 mm.addAttribute("select", 1);
		 return "showaccount";
	 }
	 List<Account> list=new ArrayList<Account>();
	 Account a =accountService.selectByAccountNumber(accountNumber);
	 if(a == null){
		 mm.addAttribute("select", 1);
		 return "showaccount";
	 }
	 list.add(a);
	 Pager<Account> p = new Pager<Account>(list);
	 mm.addAttribute("currentPage",p.getCurrentPage());
	 mm.addAttribute("totalRecord",p.getTotalRecord());
	 mm.addAttribute("totalPage",p.getTotalPage());
	 mm.addAttribute("list", p.getDatalist());
     return "showaccount"; 
 }
 @RequestMapping("/updatePwd/{id}")
 public String update(@PathVariable int id,@RequestParam String userPassword,ModelMap mm){
	 accountService.updateByAccountPwd(id, userPassword);
	 Account account = accountService.selectById(id);
	 mm.addAttribute("pwd",0);
	 mm.addAttribute("account", account);
     return "success"; 
 }
 @RequestMapping("/tosuccess/{accountNumber}")
 public String tosuccess(@PathVariable String accountNumber,ModelMap mm){
	 System.out.println(accountNumber);
	 Account account = accountService.selectByAccountNumber(accountNumber);
	 System.out.println(account.toString());
	 mm.addAttribute("account", account);
     return "success"; 
 }
 @RequestMapping("/toreturn/{id}")
 public String toreturn(@PathVariable int id,ModelMap mm){
	 Account account = accountService.selectById(id);
	 mm.addAttribute("account", account);
     return "success"; 
 }
 @RequestMapping("/selectpage/{currentPage}")
 public String selectpage(@PathVariable int currentPage,ModelMap mm){
	 List<Account> list=new ArrayList<Account>();
	 list=accountService.select();
	 if(currentPage == 0){
			currentPage=1;
	 }
	 Pager<Account> p = new Pager<Account>(currentPage,list);
	 mm.addAttribute("currentPage",p.getCurrentPage());
	 mm.addAttribute("totalRecord",p.getTotalRecord());
	 mm.addAttribute("totalPage",p.getTotalPage());
	 mm.addAttribute("list", p.getDatalist());
     return "showaccount"; 
 }
}

