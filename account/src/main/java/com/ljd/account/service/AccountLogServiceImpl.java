package com.ljd.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljd.account.dao.AccountLogDao;
import com.ljd.account.entity.AccountLog;
@Service("accountLogService")
@Transactional
public class AccountLogServiceImpl implements AccountLogService {
	@Autowired
    private AccountLogDao accountLogDao;
	public List<AccountLog> select() {
		return accountLogDao.select();
	}
	public void delete(int id, int id1) {
		accountLogDao.delete(id, id1);
	}
	public void deleteById(int id) {
		accountLogDao.deleteById(id);
		
	}
	public List<AccountLog> selectByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return accountLogDao.selectByAccountId(accountId);
	}

}
