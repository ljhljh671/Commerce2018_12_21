package com.biz.commerce.vo;

public class CommerceVO {
	
	/*
	 * 거래일자 : 상품코드 : 거래구분 : 단가 : 수량 형식의
	 * 데이터를 읽어서
	 * 각 member 변수에 저장
	 * 
	 * 각 member 변수는 정보은닉과 캡슐화를 하기 위해
	 * private으로 선언한다.
	 * 
	 */
	String strDate; //날짜
	String strInout; // 매입, 매출
	String strCode; // 상품코드
	String strName; // 상품 이름
	int intPrice; // 단가
	int intquan; // 수량
	int intInprice; // 매입단가
	int intOutprice; // 매출단가
	
	/*
	 * private 으로 선언된 변수는
	 * 외부에서 직접 접근 할 수 없으므로
	 * getter와 setter 메서드를 생성해서
	 * 변수에 값을 저장하고, 읽을 수 있도록
	 * 통로를 만든다.
	 */
	
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
	
	/*
	 * VO에 데이터를 저장한 후
	 * 데이터를 확인하는 디버깅용 메서드를
	 * 재 정의한다.
	 */
	
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strInout=" + strInout + ", strCode=" + strCode + ", strName="
				+ strName + ", intPrice=" + intPrice + ", intquan=" + intquan + ", intInprice=" + intInprice
				+ ", intOutprice=" + intOutprice + "]";
	}
	
	
	
	

	
	
	
	

}
