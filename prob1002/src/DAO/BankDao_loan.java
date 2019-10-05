package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import VO.BankVo;
import VO.LoanVo;
import VO.SavingVo;
import util.JDBCUtil;

public class BankDao_loan implements BankDao{
		
	
	@Override
	public String insert(BankVo vo) { // 회원가입
	
		String sql = "insert into loan(name,period,money,rate,interest,returnMoney,account) values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String account =null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPeriod());
			ps.setInt(3, vo.getMoney());
			ps.setDouble(4, 0.057);
			ps.setInt(5, (int) (vo.getMoney()/vo.getPeriod()*0.057));
			ps.setInt(6, (int) ((vo.getMoney()/vo.getPeriod())+((vo.getMoney()/vo.getPeriod()*0.057))));
			for(int i=1;i<13;i++) {
				if(i==4 || i== 7) {
					 account = account + "-";
				}
				if(account ==null ) {
				 account = Integer.toString((int)(Math.random()*10));
				}else {
					account = account + Integer.toString((int)(Math.random()*10));
					
				}
			};
			ps.setString(7, account);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			insert(vo);
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return account;
	}

@Override
public Map<String, Object> select(String account) { // 회원가입
		
		String sql = "select name, period , money , interest , rate ,  returnMoney, account from loan where account = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LoanVo vo =  new LoanVo();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString(1));
				vo.setPeriod(rs.getInt(2));
				vo.setMoney(rs.getInt(3));
				vo.setInterest(rs.getInt(4));
				vo.setRate(rs.getDouble(5)*100);
				vo.setReturnMoney(rs.getInt(6));
				vo.setAccount(rs.getString(7));
				map.put("vo", vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return map;
	}



}
