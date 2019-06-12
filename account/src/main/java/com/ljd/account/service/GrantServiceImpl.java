package com.ljd.account.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ljd.account.dao.AccountDao;
import com.ljd.account.dao.AccountOperationDao;
import com.ljd.account.dao.GrantDao;
import com.ljd.account.entity.Account;
import com.ljd.account.entity.Grant;
@Service("grantService")
@Transactional
public class GrantServiceImpl implements GrantService{
	@Autowired
	private GrantDao grantDao;
	@Autowired
	private AccountOperationDao accountOperationDao;
	@Autowired
	private AccountDao accountDao;
	public List<Grant> selectAll() {
		return grantDao.selectAll();
	}

	public void add(Grant grant) {
		grant.setState(1);
		Date date=new Date();
		SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		grant.setLoanTime(fmt.format(date));
		grantDao.add(grant);
	}
	public void update(int id, int state) {
		Grant g=grantDao.selectById(id);
		if(g.getState()==1){
			grantDao.update(id, state);
			if(state==0){	
				Account a=accountDao.selectById(g.getAccountId());
				accountOperationDao.save(a.getCertificateNumber(), g.getMoney());
			}
		}
		
	}

	public List<Grant> selectByAccountId(int accountId) {
		return grantDao.selectByAccountId(accountId);
	}

	public void delete(int id) {
		grantDao.delete(id);
		
	}

}
