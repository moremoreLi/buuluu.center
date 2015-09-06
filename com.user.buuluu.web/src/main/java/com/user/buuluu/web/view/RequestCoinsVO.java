package com.user.buuluu.web.view;

public class RequestCoinsVO {
	private int credit;
	private float flowCoins;
	private int point;
	private float userFlow;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credit;
		result = prime * result + Float.floatToIntBits(flowCoins);
		result = prime * result + point;
		result = prime * result + Float.floatToIntBits(userFlow);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestCoinsVO other = (RequestCoinsVO) obj;
		if (credit != other.credit)
			return false;
		if (Float.floatToIntBits(flowCoins) != Float
				.floatToIntBits(other.flowCoins))
			return false;
		if (point != other.point)
			return false;
		if (Float.floatToIntBits(userFlow) != Float
				.floatToIntBits(other.userFlow))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RequestCoinsVO [credit=" + credit + ", flowCoins=" + flowCoins
				+ ", point=" + point + ", userFlow=" + userFlow + "]";
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public float getFlowCoins() {
		return flowCoins;
	}
	public void setFlowCoins(float flowCoins) {
		this.flowCoins = flowCoins;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public float getUserFlow() {
		return userFlow;
	}
	public void setUserFlow(float userFlow) {
		this.userFlow = userFlow;
	}


}
