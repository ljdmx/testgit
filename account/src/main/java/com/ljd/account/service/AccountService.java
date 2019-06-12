package com.ljd.account.service;

import java.util.List;

import com.ljd.account.entity.Account;

public interface AccountService {
public void insert(Account at);
public int delete(int id);
public void update(Account at,int id);
public List<Account> select();
public int selectbynumber(String certificateNumber );
public int lessMoneySelect(String certificateNumber,float money);
public Account selectLog(String userName,String userPasswork);
public Account selectbycardnumber(String certificateNumber);
public List<Account> selectByUserName(String userName);
public Account selectByAccountNumber(String accountNumber);
public void updateByAccountPwd(int id,String userPassword);
public Account selectById(int id);
}
