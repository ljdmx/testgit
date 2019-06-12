package com.ljd.account.dao;


public interface AccountOperationDao {
public void save(String certificateNumber ,float money);
public void get(String certificateNumber,float money);
public float select(String certificateNumber);
}
