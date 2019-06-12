package com.ljd.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljd.account.dao.CreditDao;
import com.ljd.account.dao.GrantDao;
import com.ljd.account.dao.LoanRecordDao;
import com.ljd.account.entity.Credit;
import com.ljd.account.entity.Grant;
import com.ljd.account.entity.LoanRecord;
@Service("creditService")
@Transactional
public class CreditServiceImpl implements CreditService{
	@Autowired
	private CreditDao creditDao;
	@Autowired
	private GrantDao grantDao;
	@Autowired
	private LoanRecordDao loanRecordDao;
	public void add(Credit credit) {
	 credit.setCreditRatings("A");	
	 credit.setArrears(false);
	 credit.setArrearsMoney(0);
	creditDao.add(credit);
	}

	public List<Credit> selectAll() {
		return creditDao.selectAll();
	}

	public Credit selectByAccountId(int accountId) {
		return creditDao.selectByAccountId(accountId);
	}

	public void update(int accountId) {
		Credit credit=new Credit();
		List<Grant> grants =grantDao.selectByAccountId(accountId);
		List<LoanRecord> loanRecords=loanRecordDao.selectByAccountId(accountId);
	    float arrears;
	    float money=0;
	    float loanMoney=0;
	    for(int i=0; i<grants.size(); i++){
	      if(grants.get(i).getState()==0){
	    	  money=money + grants.get(i).getMoney(); 
	      }
	    }
	    System.out.println("money"+money);
	    for(int i=0; i<loanRecords.size(); i++){
		    loanMoney=loanMoney + loanRecords.get(i).getLoanMoney(); 
		 }
	    arrears=money-loanMoney;
	    System.out.println("loanMoney"+loanMoney);
	    System.out.println("arrears"+arrears);
	    if(arrears > 0)
	    {
	    	credit.setArrears(true);
	    	credit.setArrearsMoney(arrears);
	    	credit.setCreditRatings("B");
	    } else{
	    	credit.setArrears(false);
	    	credit.setArrearsMoney(0);
	    	credit.setCreditRatings("A");
	    } 
	    credit.setAccountId(accountId);
		creditDao.update(credit);
	}

	public void delete(int id) {
		creditDao.delete(id);
		
	}

}
