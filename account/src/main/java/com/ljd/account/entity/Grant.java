package com.ljd.account.entity;
/**
 * 璐锋鐢宠瀹炰綋绫�
 * @author li123
 *
 */
public class Grant {
	private int id;
	private int accountId;
	private float money;
	private String identityCard;
	private String loanTime;
	private String repaymentTime;
	private String telephoneNumber;
	private String familyTelephoneNumber;
	private int state;
	public int getId() {
		return id;
	}
	
	public String getLoanTime() {
		return loanTime;
	}

	public void setLoanTime(String loanTime) {
		this.loanTime = loanTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getRepaymentTime() {
		return repaymentTime;
	}
	public void setRepaymentTime(String repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getFamilyTelephoneNumber() {
		return familyTelephoneNumber;
	}
	public void setFamilyTelephoneNumber(String familyTelephoneNumber) {
		this.familyTelephoneNumber = familyTelephoneNumber;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Grant [id=" + id + ", accountId=" + accountId + ", money="
				+ money + ", identityCard=" + identityCard + ", loanTime="
				+ loanTime + ", repaymentTime=" + repaymentTime
				+ ", telephoneNumber=" + telephoneNumber
				+ ", familyTelephoneNumber=" + familyTelephoneNumber
				+ ", state=" + state + "]";
	}
	
}
