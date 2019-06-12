package com.ljd.account.dao;

import java.util.List;

import com.ljd.account.entity.Account;
import com.ljd.account.entity.AccountLog;
public interface AccountLogDao {
	public void add(Account at,String str,float money);
	public List<AccountLog> select();
	public void delete(int id,int id1);
	public void deleteById(int id);
	public List<AccountLog> selectByAccountId(int accountId);
}
