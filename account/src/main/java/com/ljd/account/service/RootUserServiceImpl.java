package com.ljd.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ljd.account.dao.RootUserDao;
import com.ljd.account.entity.RootUser;
@Service("rootUserService")
@Transactional
public class RootUserServiceImpl implements RootUserService {
	@Autowired
	private RootUserDao rootUserDao;
	public void add(RootUser ru) {
		rootUserDao.add(ru);
	}

	public List<RootUser> selectAll() {
		
		return rootUserDao.selectAll();
	}

	public RootUser select(String name, String password) {
		return rootUserDao.select(name, password);
	}

	public void delete(int id) {
		rootUserDao.delete(id);
	}

}
