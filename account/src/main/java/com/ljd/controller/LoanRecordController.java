package com.ljd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ljd.account.entity.LoanRecord;
import com.ljd.account.service.LoanRecordService;
import com.ljd.account.util.Pager;

@Controller
@RequestMapping("/loan")
public class LoanRecordController {
    @Autowired
    private LoanRecordService loanRecordService;
    @RequestMapping("/selectAll")
    public String selectAll(Model model){
    	List<LoanRecord> list=loanRecordService.selectAll();
    	   	 Pager<LoanRecord> p = new Pager<LoanRecord>(list);
    	   	model.addAttribute("currentPage",p.getCurrentPage());
    	   	model.addAttribute("totalRecord",p.getTotalRecord());
    	   	model.addAttribute("totalPage",p.getTotalPage());
    	   	model.addAttribute("list", p.getDatalist());
    	return "showloan";
    }
    @RequestMapping("/select")
    public String select(int accountId,Model model){
    	List<LoanRecord> list=loanRecordService.selectByAccountId(accountId);;
   	   	 Pager<LoanRecord> p = new Pager<LoanRecord>(list);
   	   	model.addAttribute("currentPage",p.getCurrentPage());
   	   	model.addAttribute("totalRecord",p.getTotalRecord());
   	   	model.addAttribute("totalPage",p.getTotalPage());
   	   	model.addAttribute("list", p.getDatalist());
    	return "showloan";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("int id") int id,Model model){
    	loanRecordService.deleteById(id);
    	List<LoanRecord> list=loanRecordService.selectAll();
   	   	 Pager<LoanRecord> p = new Pager<LoanRecord>(list);
   	   	model.addAttribute("currentPage",p.getCurrentPage());
   	   	model.addAttribute("totalRecord",p.getTotalRecord());
   	   	model.addAttribute("totalPage",p.getTotalPage());
   	   	model.addAttribute("list", p.getDatalist());
    	return "showloan";
    }
    @RequestMapping("/selectpage/{currentPage}")
    public String selectpage(@PathVariable int currentPage,ModelMap mm){
   	 List<LoanRecord> list=new ArrayList<LoanRecord>();
   	 list=loanRecordService.selectAll();
   	 if(currentPage == 0){
   			currentPage=1;
   	 }
   	 Pager<LoanRecord> p = new Pager<LoanRecord>(currentPage,list);
   	 mm.addAttribute("currentPage",p.getCurrentPage());
   	 mm.addAttribute("totalRecord",p.getTotalRecord());
   	 mm.addAttribute("totalPage",p.getTotalPage());
   	 mm.addAttribute("list", p.getDatalist());
     return "showloan"; 
    }
}
