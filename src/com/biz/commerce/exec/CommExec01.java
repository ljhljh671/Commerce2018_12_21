package com.biz.commerce.exec;

import com.biz.commerce.service.CommerceService;

public class CommExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inFormFile = "src/com/biz/commerce/상품정보.txt";
		String strInoutFile = "src/com/biz/commerce/매입매출데이터.txt";
		String strWriter = "src/com/biz/commerce/매입매출정보.txt";
		
		CommerceService cs = new CommerceService();
		cs.InFormRead(inFormFile);
		cs.InOutRead(strInoutFile);
		cs.MatchClass();
		cs.Save(strWriter);

	}

}
