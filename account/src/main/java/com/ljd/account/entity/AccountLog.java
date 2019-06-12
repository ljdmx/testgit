package com.ljd.account.entity;
import org.springframework.stereotype.Component;
@Component
/**
 * 操作记录实体类
 * @author li123
 *
 */
public class AccountLog {
	private int id;
	private int accountId;
	private String operation;
	private float money;
	private String logDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "AccountLog [id=" + id + ", accountId=" + accountId
				+ ", operation=" + operation + ", money=" + money
				+ ", logDate=" + logDate + "]";
	}

}
