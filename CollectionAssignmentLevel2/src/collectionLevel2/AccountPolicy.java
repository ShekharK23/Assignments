package problem1;

import java.util.Objects;

public class AccountPolicy {
	
	private int policyNumber;
	private String policyName;
	private int premiumAmount;
	private int sumAssuredAmount;
	
	public AccountPolicy() {
		super();
	}

	public AccountPolicy(int policyNumber, String policyName, int premiumAmount, int sumAssuredAmount) {
		super();
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.premiumAmount = premiumAmount;
		this.sumAssuredAmount = sumAssuredAmount;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public int getSumAssuredAmount() {
		return sumAssuredAmount;
	}

	public void setSumAssuredAmount(int sumAssuredAmount) {
		this.sumAssuredAmount = sumAssuredAmount;
	}

	@Override
	public int hashCode() {
		return (int)(Math.random()*1000);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AccountPolicy) {
			AccountPolicy p = (AccountPolicy) obj;
			boolean b1 = this.policyNumber == p.policyNumber;
			boolean b2 = this.policyName.equals(p.policyName);
			boolean b3 = this.premiumAmount == p.premiumAmount;
			boolean b4 = this.sumAssuredAmount == p.sumAssuredAmount;
			return b1 && b2 && b3 && b4;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
}
