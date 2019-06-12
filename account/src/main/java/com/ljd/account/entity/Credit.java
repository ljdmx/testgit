package com.ljd.account.entity;
/**
 * 淇＄敤瀹炰綋绫�
 * @author li123
 *
 */
public class Credit {
	private int id;
	private int accountId;
	private String creditRatings;
	private boolean arrears;
	private float arrearsMoney;
	public int getId() {
		return id;
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
	public String getCreditRatings() {
		return creditRatings;
	}
	public void setCreditRatings(String creditRatings) {
		this.creditRatings = creditRatings;
	}
	public boolean isArrears() {
		return arrears;
	}
	public void setArrears(boolean arrears) {
		this.arrears = arrears;
	}
	public float getArrearsMoney() {
		return arrearsMoney;
	}
	public void setArrearsMoney(float arrearsMoney) {
		this.arrearsMoney = arrearsMoney;
	}
	@Override
	public String toString() {
		return "Credit [id=" + id + ", accountId=" + accountId
				+ ", creditRatings=" + creditRatings + ", arrears=" + arrears
				+ ", arrearsMoney=" + arrearsMoney + "]";
	}
	
}
