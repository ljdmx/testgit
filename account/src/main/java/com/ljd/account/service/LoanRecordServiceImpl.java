package com.ljd.account.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljd.account.dao.AccountDao;
import com.ljd.account.dao.AccountOperationDao;
import com.ljd.account.dao.LoanRecordDao;
import com.ljd.account.entity.Account;
import com.ljd.account.entity.LoanRecord;
@Service("loanRecordService")
@Transactional
public class LoanRecordServiceImpl implements LoanRecordService{
	@Autowired
	private LoanRecordDao loanRecordDao;
	@Autowired
	private AccountOperationDao accountOperationDao;
	@Autowired
	private AccountDao accountDao;
	public List<LoanRecord> selectAll() {
		return loanRecordDao.selectAll();
	}

	public List<LoanRecord> selectByAccountId(int accountId) {
		return loanRecordDao.selectByAccountId(accountId);
	}

	public void deleteById(int id) {
		loanRecordDao.deleteById(id);	
	}
	public void add(LoanRecord loanRecord) {
		Date date=new Date();
		SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		loanRecord.setRepaymentTime(fmt.format(date));
		loanRecordDao.add(loanRecord);
		Account a=accountDao.selectById(loanRecord.getAccountId());
		accountOperationDao.get(a.getCertificateNumber(), loanRecord.getLoanMoney());
		
	}
	

}
