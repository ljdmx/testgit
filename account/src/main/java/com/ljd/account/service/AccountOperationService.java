package com.ljd.account.service;

public interface AccountOperationService {
	public void save(String certificateNumber,float money);
	public void get(String certificateNumber,float money);
	public float select(String certificateNumber);
	public void transfer(String certificateNumber,String certificateNumber1,float money);
}
