package com.ljd.account.dao;

import java.util.List;

import com.ljd.account.entity.Grant;

public interface GrantDao {
public List<Grant> selectAll();
public void add(Grant grant);
public void update(int id,int state);
public List<Grant> selectByAccountId(int accountId);
public Grant selectById(int id);
public void delete(int id);
}
