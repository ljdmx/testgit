package com.ljd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljd.account.entity.Credit;
import com.ljd.account.service.CreditService;
import com.ljd.account.util.Pager;

@Controller
@RequestMapping("/credit")
public class CreditController {
   @Autowired
   private CreditService creditService;
   @RequestMapping("/selectAll")
   public String selectAll(Model model){
   	List<Credit> list=creditService.selectAll();
   	Pager<Credit> p = new Pager<Credit>(list);
	model.addAttribute("currentPage",p.getCurrentPage());
	model.addAttribute("totalRecord",p.getTotalRecord());
	model.addAttribute("totalPage",p.getTotalPage());
	model.addAttribute("list", p.getDatalist());
   	return "showcredit";
   }
   @RequestMapping("/delete/{id}")
   public String delete(@PathVariable("id") int id,Model model){
	creditService.delete(id);
	List<Credit> list=creditService.selectAll();
   	Pager<Credit> p = new Pager<Credit>(list);
	model.addAttribute("currentPage",p.getCurrentPage());
	model.addAttribute("totalRecord",p.getTotalRecord());
	model.addAttribute("totalPage",p.getTotalPage());
	model.addAttribute("list", p.getDatalist());
   	return "showcredit";
   }
   @RequestMapping("/select")
   public String select(int accountId,Model model){
	 List<Credit> list = new ArrayList<Credit>();
	 list.add(creditService.selectByAccountId(accountId));
	model.addAttribute("list",list);
   	return "showcredit";
   }
   @RequestMapping("/update")
   public String update(Model model){  
	   List<Credit> list=creditService.selectAll();
	   for(int i=0;i<list.size();i++){
	    creditService.update(list.get(i).getAccountId());
	    }
	    list=creditService.selectAll();
	   	Pager<Credit> p = new Pager<Credit>(list);
		model.addAttribute("currentPage",p.getCurrentPage());
		model.addAttribute("totalRecord",p.getTotalRecord());
		model.addAttribute("totalPage",p.getTotalPage());
		model.addAttribute("list", p.getDatalist());
	   	return "showcredit";
   }
   @RequestMapping("/selectpage/{currentPage}")
   public String selectpage(@PathVariable int currentPage,ModelMap mm){
	 List<Credit> list=creditService.selectAll();
  	 if(currentPage == 0){
  			currentPage=1;
  	 }
  	 Pager<Credit> p = new Pager<Credit>(currentPage,list);
  	 mm.addAttribute("currentPage",p.getCurrentPage());
  	 mm.addAttribute("totalRecord",p.getTotalRecord());
  	 mm.addAttribute("totalPage",p.getTotalPage());
  	 mm.addAttribute("list", p.getDatalist());
       return "showcredit"; 
   }
}
