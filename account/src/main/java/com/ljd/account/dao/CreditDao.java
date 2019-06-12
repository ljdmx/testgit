package com.ljd.account.dao;

import java.util.List;

import com.ljd.account.entity.Credit;

public interface CreditDao {
public void add(Credit credit);
public List<Credit> selectAll();
public Credit selectByAccountId(int accountId);
public void update(Credit credit);
public void delete(int id);
}
