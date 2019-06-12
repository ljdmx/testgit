package com.ljd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljd.account.entity.Account;
import com.ljd.account.entity.Credit;
import com.ljd.account.entity.Grant;
import com.ljd.account.entity.LoanRecord;
import com.ljd.account.service.AccountService;
import com.ljd.account.service.CreditService;
import com.ljd.account.service.GrantService;
import com.ljd.account.service.LoanRecordService;
import com.ljd.account.util.Pager;

@Controller
@RequestMapping("/grant")
public class GrantController {
    @Autowired
    private GrantService grantService;
    @Autowired
    private CreditService creditService;
    @Autowired
    private LoanRecordService loanRecordService;
    @Autowired
    private AccountService accountService;
    @RequestMapping("/add/{accountId}")
    public String add(@PathVariable("accountId")int accountId,Grant grant,Model model){
    	grant.setAccountId(accountId);
    	grantService.add(grant);
    	List<Grant> list=grantService.selectByAccountId(grant.getAccountId());
    	model.addAttribute("list",list);
    	Credit credit=creditService.selectByAccountId(grant.getAccountId());
    	model.addAttribute("account", accountService.selectById(grant.getAccountId()));
    	model.addAttribute("list1", loanRecordService.selectByAccountId(grant.getAccountId()));
    	model.addAttribute("credit",credit);
    	return "grant";
    }
    @RequestMapping("/selectById/{accountId}")
    public String selectByAccountId(@PathVariable("accountId") int accountId,Model model){
    	List<Grant> list=grantService.selectByAccountId(accountId);
    	model.addAttribute("list",list);
    	Credit credit=creditService.selectByAccountId(accountId);
    	model.addAttribute("account", accountService.selectById(accountId));
    	model.addAttribute("list1", loanRecordService.selectByAccountId(accountId));
    	model.addAttribute("credit",credit);
    	return "grant";
    }
    @RequestMapping("/repayment/{accountId}")
    public String repayment(@PathVariable("accountId") int accountId,float loanMoney,Model model){
    	LoanRecord loanRecord = new LoanRecord();
    	loanRecord.setAccountId(accountId);
    	loanRecord.setLoanMoney(loanMoney);
    	Account a =accountService.selectById(accountId);
    	Credit c=creditService.selectByAccountId(accountId);
    	if(c.getArrearsMoney() > 0 && loanMoney <= c.getArrearsMoney()){
	    	if(a.getBalanceMoney()>loanMoney){
	    	loanRecordService.add(loanRecord);
	    	}else{
	    		model.addAttribute("notsuccess",1);
	    	}
    	}else{
    		if(loanMoney > c.getArrearsMoney()){
    			model.addAttribute("notsuccess",2);
    		}
    		if(c.getArrearsMoney()== 0){
    			model.addAttribute("notsuccess",3);
    		}
    	}
    	List<Grant> list=grantService.selectByAccountId(accountId);
    	model.addAttribute("list",list);
    	Credit credit=creditService.selectByAccountId(accountId);
    	model.addAttribute("account", accountService.selectById(accountId));
    	model.addAttribute("list1", loanRecordService.selectByAccountId(accountId));
    	model.addAttribute("credit",credit);
    	return "grant";
    }
    @RequestMapping("/update/{accountId}")
    public String update(@PathVariable("accountId") int accountId,Model model){
 	    creditService.update(accountId);
 	   List<Grant> list=grantService.selectByAccountId(accountId);
   	   model.addAttribute("list",list);
   	   Credit credit=creditService.selectByAccountId(accountId);
   	   model.addAttribute("account", accountService.selectById(accountId));
   	   model.addAttribute("list1", loanRecordService.selectByAccountId(accountId));
   	   model.addAttribute("credit",credit);
 	   	return "grant";
    }
    /////
    @RequestMapping("/selectAll")
    public String selectAll(Model model){
    	List<Grant> list=grantService.selectAll();
    	Pager<Grant> p = new Pager<Grant>(list);
    	model.addAttribute("currentPage",p.getCurrentPage());
    	model.addAttribute("totalRecord",p.getTotalRecord());
    	model.addAttribute("totalPage",p.getTotalPage());
    	model.addAttribute("list", p.getDatalist());
    	return "showgrant";
    }
    @RequestMapping("/selectByAccountId")
    public String selectById(int accountId,Model model){
    	List<Grant> list=grantService.selectByAccountId(accountId);
    	Pager<Grant> p = new Pager<Grant>(list);
    	model.addAttribute("currentPage",p.getCurrentPage());
    	model.addAttribute("totalRecord",p.getTotalRecord());
    	model.addAttribute("totalPage",p.getTotalPage());
    	model.addAttribute("list", p.getDatalist());
    	return "showgrant";
    }
    @RequestMapping("/update/{id}/{state}")
    public String update(@PathVariable("id") int id,@PathVariable("state") int state,Model model){
    	grantService.update(id, state);
    	List<Grant> list=grantService.selectAll();
    	Pager<Grant> p = new Pager<Grant>(list);
    	model.addAttribute("currentPage",p.getCurrentPage());
    	model.addAttribute("totalRecord",p.getTotalRecord());
    	model.addAttribute("totalPage",p.getTotalPage());
    	model.addAttribute("list", p.getDatalist());
    	return "showgrant";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,Model model){
    	grantService.delete(id);
    	List<Grant> list=grantService.selectAll();
    	Pager<Grant> p = new Pager<Grant>(list);
    	model.addAttribute("currentPage",p.getCurrentPage());
    	model.addAttribute("totalRecord",p.getTotalRecord());
    	model.addAttribute("totalPage",p.getTotalPage());
    	model.addAttribute("list", p.getDatalist());
    	return "showgrant";
    }

    @RequestMapping("/selectpage/{currentPage}")
    public String selectpage(@PathVariable int currentPage,ModelMap mm){
   	 List<Grant> list=new ArrayList<Grant>();
   	 list=grantService.selectAll();
   	 if(currentPage == 0){
   			currentPage=1;
   	 }
   	 Pager<Grant> p = new Pager<Grant>(currentPage,list);
   	 mm.addAttribute("currentPage",p.getCurrentPage());
   	 mm.addAttribute("totalRecord",p.getTotalRecord());
   	 mm.addAttribute("totalPage",p.getTotalPage());
   	 mm.addAttribute("list", p.getDatalist());
        return "showgrant"; 
    }
}
