package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import VO.BankVo;
import VO.LoanVo;
import VO.SavingVo;
import util.JDBCUtil;

public interface BankDao {

	public String insert(BankVo vo);

	public Map<String, Object> select(String account);

}
