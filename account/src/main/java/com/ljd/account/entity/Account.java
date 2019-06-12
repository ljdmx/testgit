package com.ljd.account.entity;

import org.springframework.stereotype.Component;
/**
 * 账户实体类
 * @author li123
 *
 */
@Component
public class Account {
	private int id;
	private String accountNumber;
	private String userName;
	private String userPassword;
	private String certificateNumber;
	private String accountOpeningDate;
	private float balanceMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public void setAccountOpeningDate(String accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	public float getBalanceMoney() {
		return balanceMoney;
	}
	public void setBalanceMoney(float balanceMoney) {
		this.balanceMoney = balanceMoney;
	}
	public String toString() {
		return "["+this.getId()+","+this.getAccountNumber()
		       +","+this.getUserName()+","+this.getUserPassword()
		       +","+this.getCertificateNumber()+","+this.getAccountOpeningDate()
		       +","+this.getBalanceMoney()+"]";
	}

}
