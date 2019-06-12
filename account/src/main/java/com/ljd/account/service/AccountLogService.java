package com.ljd.account.service;

import java.util.List;

import com.ljd.account.entity.AccountLog;

public interface AccountLogService {
public List<AccountLog> select();
public void delete(int id,int id1);
public void deleteById(int id);
public List<AccountLog> selectByAccountId(int accountId);
}
