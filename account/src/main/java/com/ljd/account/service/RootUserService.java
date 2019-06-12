package com.ljd.account.service;

import java.util.List;

import com.ljd.account.entity.RootUser;

public interface RootUserService {
public void add(RootUser ru);
public List<RootUser> selectAll();
public RootUser select(String name,String password);
public void delete(int id);
}
