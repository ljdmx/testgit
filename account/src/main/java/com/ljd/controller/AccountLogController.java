package com.ljd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




import com.ljd.account.entity.AccountLog;
import com.ljd.account.service.AccountLogService;
import com.ljd.account.util.Pager;


@Controller
@RequestMapping("/accountLog")
public class AccountLogController {
	@Autowired(required=true)
	private AccountLogService accountLogService; 
	
	public void setAls(AccountLogService accountLogService) {
		this.accountLogService = accountLogService;
	}
	@RequestMapping("/selectLog")
	public String select(ModelMap mm){
		 List<AccountLog> list=new ArrayList<AccountLog>();
				list=accountLogService.select();
				Pager<AccountLog> p = new Pager<AccountLog>(list);
			    mm.addAttribute("currentPage",p.getCurrentPage());//褰撳墠绗嚑椤垫暟鎹�
			    mm.addAttribute("totalRecord",p.getTotalRecord());//涓�鍏卞灏戣褰�
			    mm.addAttribute("totalPage",p.getTotalPage());//涓�鍏卞灏戦〉
				mm.addAttribute("list", p.getDatalist());
				
		System.out.println(list);
		return "showlog";
	}
	@RequestMapping("/deleteLog")
	public String delete(@RequestParam int id,@RequestParam int id1,ModelMap mm){
		if(id < 1 && id1 < 1){
			mm.addAttribute("notdelete", 1);
			List<AccountLog> list=new ArrayList<AccountLog>();
			list=accountLogService.select();
			Pager<AccountLog> p = new Pager<AccountLog>(list);
			mm.addAttribute("currentPage",p.getCurrentPage());//褰撳墠绗嚑椤垫暟鎹�
		    mm.addAttribute("totalRecord",p.getTotalRecord());//涓�鍏卞灏戣褰�
		    mm.addAttribute("totalPage",p.getTotalPage());//涓�鍏卞灏戦〉
			mm.addAttribute("list", p.getDatalist());
			
			return "showlog";
		}
		accountLogService.delete(id, id1);
		System.out.println(id1);
		 List<AccountLog> list=new ArrayList<AccountLog>();
				list=accountLogService.select();
				Pager<AccountLog> p = new Pager<AccountLog>(list);
				mm.addAttribute("currentPage",p.getCurrentPage());//褰撳墠绗嚑椤垫暟鎹�
			    mm.addAttribute("totalRecord",p.getTotalRecord());//涓�鍏卞灏戣褰�
			    mm.addAttribute("totalPage",p.getTotalPage());//涓�鍏卞灏戦〉
				mm.addAttribute("list", p.getDatalist());
				
		System.out.println(list);
		return "showlog";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,ModelMap mm){
		accountLogService.deleteById(id);
		 List<AccountLog> list=new ArrayList<AccountLog>();
				list=accountLogService.select();
				Pager<AccountLog> p = new Pager<AccountLog>(list);
				mm.addAttribute("currentPage",p.getCurrentPage());//褰撳墠绗嚑椤垫暟鎹�
			    mm.addAttribute("totalRecord",p.getTotalRecord());//涓�鍏卞灏戣褰�
			    mm.addAttribute("totalPage",p.getTotalPage());//涓�鍏卞灏戦〉
				mm.addAttribute("list", p.getDatalist());
				
		System.out.println(list);
		return "showlog";
	}
	@RequestMapping("/selectByAccountId/{accountId}")
	public String selectByAccountNumber(@PathVariable int accountId,ModelMap mm){
		 List<AccountLog> list=new ArrayList<AccountLog>();
				list=accountLogService.selectByAccountId(accountId);
				Pager<AccountLog> p = new Pager<AccountLog>(list);
				mm.addAttribute("currentPage",p.getCurrentPage());//褰撳墠绗嚑椤垫暟鎹�
			    mm.addAttribute("totalRecord",p.getTotalRecord());//涓�鍏卞灏戣褰�
			    mm.addAttribute("totalPage",p.getTotalPage());//涓�鍏卞灏戦〉
				mm.addAttribute("list", p.getDatalist());
				mm.addAttribute("accountId", accountId);	
		return "accountlog";
	}
	@RequestMapping("/select/{currentPage}")
	public String selectCurrentPage(@PathVariable int currentPage, ModelMap mm){
		 List<AccountLog> list=new ArrayList<AccountLog>();
				list=accountLogService.select();
				if(currentPage == 0){
					currentPage=1;
				}
				Pager<AccountLog> p = new Pager<AccountLog>(currentPage,list);
			    mm.addAttribute("currentPage",p.getCurrentPage());//褰撳墠绗嚑椤垫暟鎹�
			    mm.addAttribute("totalRecord",p.getTotalRecord());//涓�鍏卞灏戣褰�
			    mm.addAttribute("totalPage",p.getTotalPage());//涓�鍏卞灏戦〉
				mm.addAttribute("list", p.getDatalist());
		System.out.println(list);
		return "showlog";
	}
	@RequestMapping("/select1/{currentPage}/{accountId}")
	public String selectCurrentPage1(@PathVariable int currentPage,@PathVariable int accountId,ModelMap mm){
		 List<AccountLog> list=new ArrayList<AccountLog>();
				list=accountLogService.selectByAccountId(accountId);
				if(currentPage == 0){
					currentPage=1;
				}
				Pager<AccountLog> p = new Pager<AccountLog>(currentPage,list);
				mm.addAttribute("currentPage",p.getCurrentPage());//褰撳墠绗嚑椤垫暟鎹�
			    mm.addAttribute("totalRecord",p.getTotalRecord());//涓�鍏卞灏戣褰�
			    mm.addAttribute("totalPage",p.getTotalPage());//涓�鍏卞灏戦〉
				mm.addAttribute("list", p.getDatalist());
				mm.addAttribute("accountId", accountId);
				
		return "accountlog";
	}
}
