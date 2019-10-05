package VO;

public class SavingVo extends BankVo{
	int interest;
	double rate;
	int entire;
	int returnMoney;
	String account;
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
	public int getEntire() {
		return entire;
	}
	public void setEntire(int entire) {
		this.entire = entire;
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
	@Override
	public String toString() {
		return "SavingVo [interest=" + interest + ", rate=" + rate + ", entire=" + entire + ", returnMoney="
				+ returnMoney + ", account=" + account + "]";
	}
	
	

	


	
}
