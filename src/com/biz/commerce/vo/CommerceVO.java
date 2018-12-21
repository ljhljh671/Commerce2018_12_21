package com.biz.commerce.vo;

public class CommerceVO {
	
	String strDate;
	String strInout;
	String strCode;
	String strName;
	int intPrice;
	int intquan;
	int intInprice;
	int intOutprice;
	
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}

	
	public int getIntquan() {
		return intquan;
	}
	public void setIntquan(int intquan) {
		this.intquan = intquan;
	}

	
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrInout() {
		return strInout;
	}
	public void setStrInout(String strInout) {
		this.strInout = strInout;
	}
	public String getStrCode() {
		return strCode;
	}
	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}

	public int getIntInprice() {
		return intInprice;
	}
	public void setIntInprice(int intInprice) {
		this.intInprice = intInprice;
	}
	public int getIntOutprice() {
		return intOutprice;
	}
	public void setIntOutprice(int intOutprice) {
		this.intOutprice = intOutprice;
	}
	
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strInout=" + strInout + ", strCode=" + strCode + ", strName="
				+ strName + ", intPrice=" + intPrice + ", intquan=" + intquan + ", intInprice=" + intInprice
				+ ", intOutprice=" + intOutprice + "]";
	}
	
	
	
	

	
	
	
	

}
