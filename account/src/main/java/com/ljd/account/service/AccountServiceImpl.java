package com.ljd.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljd.account.dao.AccountDao;
import com.ljd.account.entity.Account;
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	public void insert(Account at) {
		accountDao.insertAccount(at);
	}

	public int delete(int id) {
		return accountDao.deleteAccount(id);
	}

	public void update(Account at ,int id) {
		accountDao.updateAccount(at , id);
		
	}

	public List<Account> select() {
		return accountDao.selectAccount(); 
	}

	public int selectbynumber(String certificateNumber) {
		return accountDao.selectbynumber(certificateNumber);
	}

	public int lessMoneySelect(String certificateNumber, float money) {
		// TODO Auto-generated method stub
		return accountDao.lessMoneySelect(certificateNumber, money);
	}

	public Account selectLog(String userName, String userPasswork) {
		// TODO Auto-generated method stub
		return accountDao.selectLog(userName, userPasswork);
	}
	public Account selectbycardnumber(String certificateNumber) {
		return accountDao.selectbycardnumber(certificateNumber);
	}

	public List<Account> selectByUserName(String userName) {
		
		return accountDao.selectByUserName(userName);
	}

	public Account selectByAccountNumber(String accountNumber) {
		
		return accountDao.selectByAccountNumber(accountNumber);
	}

	public void updateByAccountPwd(int id, String userPassword) {
		// TODO Auto-generated method stub
		accountDao.updateByAccountPwd(id, userPassword);
		
	}

	public Account selectById(int id) {
		// TODO Auto-generated method stub
		return accountDao.selectById(id);
	}
}
