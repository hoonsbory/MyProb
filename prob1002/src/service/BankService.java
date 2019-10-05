package service;

import java.util.List;
import java.util.Map;

import VO.BankVo;
import VO.LoanVo;
import VO.SavingVo;

public interface BankService {
	public String insertaccount(BankVo vo);
	public Map<String, Object> showaccount(String account);
}
