package com.ljd.account.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ljd.account.entity.Account;
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void insertAccount(Account at) {
		String sql="insert into account(account_number,user_name,user_password,certificate_number,account_opening_date,balance_money) values(?,?,?,?,?,?)";
		  
 		Object obj[]=new Object[]
 	{at.getAccountNumber(),at.getUserName(),at.getUserPassword(),at.getCertificateNumber(),at.getAccountOpeningDate(),at.getBalanceMoney()};
        
 		jdbcTemplate.update(sql,obj);
		
	}

	public int deleteAccount(int id) {
		String sql="delete from account where id=?";
		int a=jdbcTemplate.update(sql, id);
		return a;
	}

	public void updateAccount(Account at ,int id) {
		String sql="update account set user_password=?,balance_money=? where id=?";
 		Object obj[]=new Object[]
 	{at.getUserPassword(),at.getBalanceMoney(),id};
        
 		jdbcTemplate.update(sql,obj);		
	}

	public List<Account> selectAccount() {
		String sql="select * from account";
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,rowMapper);
		return accounts;
	}

	public int selectbynumber(String certificateNumber) {
		String sql="select * from account where certificate_number=?";
		Object[] obj= {certificateNumber};
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,obj,rowMapper);
		if(accounts.isEmpty()){
			return -1;
		}else {
			return 1;
		}
	}

	public int lessMoneySelect(String certificateNumber, float money) {
		String sql="select * from account where certificate_number=? and balance_money>=?";
		Object[] obj= {certificateNumber,money};
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,obj,rowMapper);
		if(accounts.isEmpty()){
			return -1;
		}else {
			return 1;
		}
	}

	public Account selectLog(String userName, String userPassword) {
		String sql="select * from account where user_name=? and user_password=?";
		Object[] obj= {userName,userPassword};
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,obj,rowMapper);
		if(!accounts.isEmpty()) {
			Account a=accounts.get(0);
			return a;
		}
		
		return null;
	}

	public Account selectbycardnumber(String certificateNumber) {
		
		String sql="select * from account where certificate_number=?";
		Object[] obj= {certificateNumber};
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,obj,rowMapper);
		if(!accounts.isEmpty()) {
			Account a=accounts.get(0);
			return a;
		}
		
		return null;
	}

	public List<Account> selectByUserName(String userName) {
		String sql="select * from account where user_name like '%"+userName+"%'";
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,rowMapper);
		return accounts;
	}

	public Account selectByAccountNumber(String accountNumber) {
		String sql="select * from account where account_number=?";
		Object[] obj= {accountNumber};
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,obj,rowMapper);
		if(!accounts.isEmpty()) {
			Account a=accounts.get(0);
			return a;
		}
		return null;
	}

	public void updateByAccountPwd(int id, String userPassword) {
		String sql="update account set user_password=? where id=?";
 		Object obj[]=new Object[]
 	     {userPassword,id};    
 		jdbcTemplate.update(sql,obj);	
		
	}

	public Account selectById(int id) {
		String sql="select * from account where id=?";
		Object[] obj= {id};
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,obj,rowMapper);
		if(!accounts.isEmpty()) {
			Account a=accounts.get(0);
			return a;
		}
		return null;
	}
	

}
