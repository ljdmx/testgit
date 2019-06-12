package com.ljd.account.dao;

import java.util.List;

import com.ljd.account.entity.LoanRecord;

public interface LoanRecordDao {
public void add(LoanRecord loanRecord);
public List<LoanRecord> selectAll();
public List<LoanRecord> selectByAccountId(int accountId);
public void deleteById(int id);
}
