package com.ljd.account.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ljd.account.entity.Grant;
@Repository("grantDao")
public class GrantDaoImpl implements GrantDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public List<Grant> selectAll() {
		String sql="select * from grant_tab";
		RowMapper<Grant> rowMapper=new BeanPropertyRowMapper<Grant>(Grant.class);
		List<Grant> grants=jdbcTemplate.query(sql,rowMapper);
		return  grants;
	}

	public void add(Grant grant) {
		String sql="insert into grant_tab(account_id,money,identity_card,loan_time,repayment_time,telephone_number,family_telephone_number,state) values(?,?,?,?,?,?,?,?)"; 
 		Object obj[]=new Object[]
 	    {grant.getAccountId(),grant.getMoney(),grant.getIdentityCard(),grant.getLoanTime(),grant.getRepaymentTime(),grant.getTelephoneNumber(),grant.getFamilyTelephoneNumber(),grant.getState()};
 		jdbcTemplate.update(sql,obj);
	}

	public void update(int id,int state) {
		String sql="update grant_tab set state=? where id=?";
 		Object obj[]=new Object[]
 	     {state,id};    
 		jdbcTemplate.update(sql,obj);	
	}
	public List<Grant> selectByAccountId(int accountId) {
		String sql="select * from grant_tab where account_id=?";
		Object[] obj= {accountId};
		RowMapper<Grant> rowMapper=new BeanPropertyRowMapper<Grant>(Grant.class);
		List<Grant> grants=jdbcTemplate.query(sql,obj,rowMapper);
		return grants;
	}

	public void delete(int id) {
		String sql="delete from grant_tab where id=?";
		jdbcTemplate.update(sql, id);
	}

	public Grant selectById(int id) {
		String sql="select * from grant_tab where id=?";
		Object[] obj= {id};
		RowMapper<Grant> rowMapper=new BeanPropertyRowMapper<Grant>(Grant.class);
		List<Grant> grants=jdbcTemplate.query(sql,obj,rowMapper);
		if(!grants.isEmpty()){
			return grants.get(0);
		}
		return null;
	}

	

}
