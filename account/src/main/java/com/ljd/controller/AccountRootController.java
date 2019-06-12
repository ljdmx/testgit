package com.ljd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ljd.account.entity.RootUser;
import com.ljd.account.service.RootUserService;

@Controller
@RequestMapping("/root")
public class AccountRootController {
	
	@Autowired(required=true)
	private RootUserService rootUserService;
	public void setRts(RootUserService rootUserService) {
		this.rootUserService = rootUserService;
	}
	 @RequestMapping("/login")
	 public String longin1(@RequestParam String name,@RequestParam String password,ModelMap model) {
		 RootUser a=rootUserService.select(name, password);
		 if(a!=null){
		 return "show";
		 } 
		 model.addAttribute("success",1);
		 return "index";
	 } 
	 @RequestMapping("/selectroot")
	 public String selectroot(ModelMap mm){
		 List<RootUser> list=new ArrayList<RootUser>();
		 list=rootUserService.selectAll();
	     mm.addAttribute("list", list);
	     return "showroot"; 
	 }
	 @RequestMapping("/add")
	 public String addroot(String name,String password,ModelMap mm){
		 if(name.length()< 1 && password.length() < 1){
			 mm.addAttribute("notadd", 1);
			 List<RootUser> list=new ArrayList<RootUser>();
			 list=rootUserService.selectAll();
		     mm.addAttribute("list", list);
			 return "showroot";
		 }
		 RootUser ru=new RootUser();
		 ru.setName(name);
		 ru.setPassword(password);
		 rootUserService.add(ru);
		 List<RootUser> list=new ArrayList<RootUser>();
		 list=rootUserService.selectAll();
	     mm.addAttribute("list", list);
	     return "showroot"; 
	 }
	 @RequestMapping("/delete/{id}")
	 public String deleterootById(@PathVariable int id,ModelMap mm){
		 List<RootUser> list=new ArrayList<RootUser>();
		 rootUserService.delete(id);
		 list=rootUserService.selectAll();
	     mm.addAttribute("list", list);
	     return "showroot"; 
	 }
	 
	 @RequestMapping("/toshow")
	 public String toshow(){
	     return "show"; 
	 }
}
