package com.ljd.account.service;

import java.util.List;

import com.ljd.account.entity.LoanRecord;

public interface LoanRecordService {
	public List<LoanRecord> selectAll();
	public List<LoanRecord> selectByAccountId(int accountId);
	public void deleteById(int id);
	public void add(LoanRecord loanRecord);
}
