package com.ljd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ljd.account.entity.Account;
import com.ljd.account.service.AccountOperationService;
import com.ljd.account.service.AccountService;
@Controller
@RequestMapping("/accountOperation")
public class AccountOperationController {
	@Autowired(required=true)
	private  AccountOperationService accountOperationService;
	
	public void setAs(AccountOperationService accountOperationService) {
		this.accountOperationService = accountOperationService;
	}
	

	@Autowired(required=true)
	private AccountService a;
	public void setA(AccountService a) {
		this.a = a;
	}
	@RequestMapping("/transfer/{certificateNumber}")
	public String transfer(@PathVariable String certificateNumber,@RequestParam String certificateNumber1,@RequestParam float balanceMoney ,ModelMap mm) {    
		Account d=a.selectbycardnumber(certificateNumber1);
		if(d==null){
			Account c=a.selectbycardnumber(certificateNumber);
			mm.addAttribute("certificateNumber", 1);
			mm.addAttribute("account",c);
			return "success";
		}
		float a1=accountOperationService.select(certificateNumber);
		float a2=accountOperationService.select(certificateNumber1);
		accountOperationService.transfer(certificateNumber, certificateNumber1, balanceMoney);
		float b1=accountOperationService.select(certificateNumber);
		float b2=accountOperationService.select(certificateNumber1);
		if(b2==a2+balanceMoney&&b1==a1-balanceMoney){
			 mm.addAttribute("success", 0);
		 }else{
			 mm.addAttribute("success", 1);
		 }
		Account c=a.selectbycardnumber(certificateNumber);
		mm.addAttribute("account",c);
		return "success";
	}
	@RequestMapping("/save/{certificateNumber}")
	public String save(@PathVariable String certificateNumber,@RequestParam float balanceMoney ,ModelMap mm) {
		 float b=accountOperationService.select(certificateNumber);
		 accountOperationService.save(certificateNumber, balanceMoney);
		 float b1=accountOperationService.select(certificateNumber);
		 if(b1==b+balanceMoney){
			 mm.addAttribute("success", 0);
		 }else{
			 mm.addAttribute("success1", 1);
		 }
		 Account c=a.selectbycardnumber(certificateNumber);
		 mm.addAttribute("account", c);
		 return "success";
	}
	
	@RequestMapping("/get/{certificateNumber}")
	public String get(@PathVariable String certificateNumber,@RequestParam float balanceMoney ,ModelMap mm) {
		float b=accountOperationService.select(certificateNumber);
		accountOperationService.get(certificateNumber, balanceMoney);
		float b1=accountOperationService.select(certificateNumber);
		if(b1==b-balanceMoney){
			 mm.addAttribute("success", 0);
		 }else{
			 mm.addAttribute("success", 1);
		 }
		Account c=a.selectbycardnumber(certificateNumber);
		mm.addAttribute("account", c);
		return "success";
		}

	@RequestMapping("/select/{certificateNumber}")
	public String select(@PathVariable String certificateNumber,ModelMap mm) {
		Account c=a.selectbycardnumber(certificateNumber);
		mm.addAttribute("account", c);
        float b=accountOperationService.select(certificateNumber);
        mm.addAttribute("Number", 0);
        mm.addAttribute("money", b);
        return "success";
        }
	}

