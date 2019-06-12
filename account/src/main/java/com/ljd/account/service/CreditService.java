package com.ljd.account.service;

import java.util.List;

import com.ljd.account.entity.Credit;

public interface CreditService {
	public void add(Credit credit);
	public List<Credit> selectAll();
	public Credit selectByAccountId(int accountId);
	public void update(int accountId);
	public void delete(int id);
}
