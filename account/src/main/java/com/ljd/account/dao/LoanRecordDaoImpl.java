package com.ljd.account.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ljd.account.entity.LoanRecord;
@Repository("loanRecordDao")
public class LoanRecordDaoImpl implements LoanRecordDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void add(LoanRecord loanRecord) {
		String sql="insert into loan_record(repayment_time,loan_money,account_id) values(?,?,?)"; 
 		Object obj[]=new Object[]
 	    {loanRecord.getRepaymentTime(),loanRecord.getLoanMoney(),loanRecord.getAccountId()};
 		jdbcTemplate.update(sql,obj);
		
	}
	public List<LoanRecord> selectAll() {
		String sql="select * from  loan_record";
		RowMapper<LoanRecord> rowMapper=new BeanPropertyRowMapper<LoanRecord>(LoanRecord.class);
		List<LoanRecord> loanRecords=jdbcTemplate.query(sql,rowMapper);
		return  loanRecords;
	}

	public List<LoanRecord> selectByAccountId(int accountId) {
		String sql="select * from  loan_record where account_id=?";
		Object[] obj= {accountId};
		RowMapper<LoanRecord> rowMapper=new BeanPropertyRowMapper<LoanRecord>(LoanRecord.class);
		List<LoanRecord> loanRecords=jdbcTemplate.query(sql,obj,rowMapper);
		return  loanRecords;
	}

	public void deleteById(int id) {
		String sql="delete from loan_record where id=?";
		jdbcTemplate.update(sql, id);
	}
}
