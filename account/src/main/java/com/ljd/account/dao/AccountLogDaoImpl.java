package com.ljd.account.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ljd.account.entity.Account;
import com.ljd.account.entity.AccountLog;

@Repository("accountLogDao")
public class AccountLogDaoImpl implements AccountLogDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void add(Account at,String str,float money) {
		String sql="insert into account_log(account_id,operation,money,log_date) values(?,?,?,?)";
	    Date date=new Date();
	    SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		Object obj[]=new Object[]{at.getId(),str,money,fmt.format(date)};
 		jdbcTemplate.update(sql,obj);	
	}
	public List<AccountLog> select() {
		String sql="select id,account_id,operation,money,log_date from account_log";
		RowMapper<AccountLog> rowMapper=new BeanPropertyRowMapper<AccountLog>(AccountLog.class);
		List<AccountLog> accountlogs=jdbcTemplate.query(sql,rowMapper);
		return accountlogs;
	}
	public void delete(int id, int id1) {
		int a=id+id1-1;
		String sql="delete from account_log where id between ? and ?";
 		Object obj[]=new Object[]{id,a};
 		jdbcTemplate.update(sql,obj);
		
	}
	public void deleteById(int id) {
		String sql="delete from account_log where id = ?";
 		jdbcTemplate.update(sql,id);
		
	}
	public List<AccountLog> selectByAccountId(int accountId) {
		String sql="select id,account_id,operation,money,log_date from account_log where account_id = ?";
		Object[] obj ={accountId};
		RowMapper<AccountLog> rowMapper=new BeanPropertyRowMapper<AccountLog>(AccountLog.class);
		List<AccountLog> accountlogs=jdbcTemplate.query(sql,obj,rowMapper);
		return accountlogs;
	}


}
