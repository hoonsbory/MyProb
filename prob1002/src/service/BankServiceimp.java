package service;

import java.util.List;
import java.util.Map;

import DAO.BankDao;
import VO.BankVo;
import VO.LoanVo;
import VO.SavingVo;

public class BankServiceimp implements BankService{
	BankDao dao;
	
	public BankServiceimp() {
		
	}

	public BankServiceimp(BankDao dao) {
		super();
		this.dao = dao;
	}
	
	

	public BankDao getDao() {
		return dao;
	}


	public void setDao(BankDao dao) {
		this.dao = dao;
	}
	
	@Override
	public String insertaccount(BankVo vo) {
		return dao.insert(vo);
	}



	@Override
	public Map<String, Object> showaccount(String account) {
		return dao.select(account);
	}

}
