package com.ljd.account.service;

import java.util.List;

import com.ljd.account.entity.Grant;

public interface GrantService {
	public List<Grant> selectAll();
	public void add(Grant grant);
	public void update(int id,int state);
	public List<Grant> selectByAccountId(int accountId);
	public void delete(int id);
}
