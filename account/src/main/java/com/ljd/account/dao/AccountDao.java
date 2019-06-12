package com.ljd.account.dao;

import java.util.List;

import com.ljd.account.entity.Account;

public interface AccountDao {
public void insertAccount(Account at);
public int deleteAccount(int id);
public void updateAccount(Account at ,int id);
public List<Account> selectAccount();
public int selectbynumber(String certificateNumber);
public int lessMoneySelect(String certificateNumber,float money);
public Account selectLog(String userName,String userPassword);
public Account selectbycardnumber(String certificateNumber);
public List<Account> selectByUserName(String userName);
public Account selectByAccountNumber(String accountNumber);
public void updateByAccountPwd(int id,String userPassword);
public Account selectById(int id);
}
