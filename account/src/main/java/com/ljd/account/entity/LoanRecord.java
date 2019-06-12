package com.ljd.account.entity;
/**
 * 杩樻璁板綍瀹炰綋绫�
 * @author li123
 *
 */
public class LoanRecord {
	private int id;
	private String repaymentTime;
	private float loanMoney;
	private int accountId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRepaymentTime() {
		return repaymentTime;
	}
	public void setRepaymentTime(String repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	public float getLoanMoney() {
		return loanMoney;
	}
	public void setLoanMoney(float loanMoney) {
		this.loanMoney = loanMoney;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "LoanRecord [id=" + id + ", repaymentTime=" + repaymentTime
				+ ", loanMoney=" + loanMoney + ", accountId=" + accountId + "]";
	}
	
}
