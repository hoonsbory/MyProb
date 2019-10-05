package VO;

public class LoanVo extends BankVo{
	int interest;
	double rate;
	int returnMoney;
	String account;
	@Override
	public String toString() {
		return "LoanVo [interest=" + interest + ", rate=" + rate + ", returnMoney=" + returnMoney + ", account="
				+ account + "]";
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getReturnMoney() {
		return returnMoney;
	}
	public void setReturnMoney(int returnMoney) {
		this.returnMoney = returnMoney;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
}
