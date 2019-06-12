package com.ljd.account.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ljd.account.entity.Account;
@Repository("accountOperationDao")
public class AccountOperationDaoImpl implements AccountOperationDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void save(String certificateNumber, float money) {
		String sql="update account set balance_money=balance_money+? where certificate_number=?";
 		Object obj[]=new Object[]
 	{money,certificateNumber};
 		jdbcTemplate.update(sql,obj);
		
	}

	public void get(String certificateNumber, float money) {
		String sql="update account set balance_money=balance_money-? where certificate_number=?";
 		Object obj[]=new Object[]{money,certificateNumber};
 		jdbcTemplate.update(sql,obj);
	}

	public float select(String certificateNumber) {
		String sql="select balance_money from account  where certificate_number=?";
 		Object obj[]=new Object[]{certificateNumber};
 		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		List<Account> accounts=jdbcTemplate.query(sql,obj,rowMapper);
		if(!accounts.isEmpty()) {
			Account a=accounts.get(0);
			return a.getBalanceMoney();
		}
		return 0;
	
	}

}
