package com.ljd.account.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ljd.account.entity.Credit;
@Repository("creditDao")
public class CreditDaoImpl implements CreditDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void add(Credit credit) {
		String sql="insert into credit_tab(account_id,credit_ratings,arrears,arrears_money) values(?,?,?,?)"; 
 		Object obj[]=new Object[]
 	    {credit.getAccountId(),credit.getCreditRatings(),credit.isArrears(),credit.getArrearsMoney()};
 		jdbcTemplate.update(sql,obj);
	}

	public List<Credit> selectAll() {
		String sql="select * from credit_tab";
		RowMapper<Credit> rowMapper=new BeanPropertyRowMapper<Credit>(Credit.class);
		List<Credit> credits=jdbcTemplate.query(sql,rowMapper);
		return credits;
	}
	public Credit selectByAccountId(int accountId) {
		String sql="select * from credit_tab where account_id=?";
		Object[] obj= {accountId};
		RowMapper<Credit> rowMapper=new BeanPropertyRowMapper<Credit>(Credit.class);
		List<Credit> credits=jdbcTemplate.query(sql,obj,rowMapper);
		if(!credits.isEmpty()) {
			Credit credit=credits.get(0);
			return credit;
		}
		return null;
	}

	public void update(Credit credit) {
		String sql="update credit_tab set credit_ratings=? , arrears=? , arrears_money=? where account_id = ?";
 		Object obj[]=new Object[]
 	     {credit.getCreditRatings(),credit.isArrears(),credit.getArrearsMoney(),credit.getAccountId()};    
 		jdbcTemplate.update(sql,obj);	
	}

	public void delete(int id) {
		String sql="delete from credit_tab where id=?";
		jdbcTemplate.update(sql, id);
	}

	

}
