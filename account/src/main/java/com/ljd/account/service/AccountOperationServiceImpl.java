package com.ljd.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljd.account.dao.AccountDao;
import com.ljd.account.dao.AccountLogDao;
import com.ljd.account.dao.AccountOperationDao;

import com.ljd.account.util.LessMoneyException;
@Service("accountOperationService")
@Transactional(rollbackFor= {NullPointerException.class,LessMoneyException.class},readOnly=false)
public class AccountOperationServiceImpl implements AccountOperationService{
	@Autowired
	private AccountOperationDao accountOperationDao;
	@Autowired
	private AccountLogDao accountLogDao;
	@Autowired
	private AccountDao accountDao;
	public void save(String certificateNumber, float money) {
		int a=accountDao. selectbynumber(certificateNumber);
		if(a==1) {
		accountOperationDao.save(certificateNumber, money);
		accountLogDao.add(accountDao.selectbycardnumber(certificateNumber),"save",money);
		}else {
			try{
				throw new NullPointerException();
			    }catch(NullPointerException e){
			    	System.out.println("账户不存�?");
			    }
		}
		
	}

	public void get(String certificateNumber, float money) {
		float money1=accountOperationDao.select(certificateNumber);
		if(money1>money) {
			accountOperationDao.get(certificateNumber, money);
			accountLogDao.add(accountDao.selectbycardnumber(certificateNumber),"get",money);
		}else {
			try{
				throw new LessMoneyException();
			    }catch(LessMoneyException e){
			    	e.printStackTrace();
			    }
		}
	}
    
	public void transfer(String certificateNumber1, String certificateNumber2,float money) {
		int a=accountDao.selectbynumber(certificateNumber1);
		int b=accountDao.lessMoneySelect(certificateNumber1, money);
		int a1=accountDao.selectbynumber(certificateNumber2);
		if(a==1&&b==1&&a1==1){
		   accountOperationDao.get(certificateNumber1, money);
		   accountLogDao.add(accountDao.selectbycardnumber(certificateNumber1),"outptmoney",money);
		   accountOperationDao.save(certificateNumber2, money);
		     accountLogDao.add(accountDao.selectbycardnumber(certificateNumber2),"inputmoney",money);
		   }else {
			   if(a==-1||a1==-1) {
					try{
				          throw new NullPointerException();
				       }catch(NullPointerException e){
				          System.out.println("账户不存�?");
				       }
				}
				if(b==-1){
					 try {
					      throw new LessMoneyException();
					      }catch(LessMoneyException e){
					    	  e.printStackTrace();
					      }finally {
					    	  accountLogDao.add(accountDao.selectbycardnumber(certificateNumber2),"get but less money",money);	
						  }
				}
		   }
		
		
	}

	public float select(String certificateNumber) {
		return accountOperationDao.select(certificateNumber);
		
	}

}
