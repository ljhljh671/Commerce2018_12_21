package com.biz.commerce.exec;

import com.biz.commerce.service.CommerceService;

/*
 * 자바야 지금부터 CommExec01 이라는 클래스를 시작한다
 */
public class CommExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 매입매출정보를 저장하고 있는 파일 이름(경로)를
		 * 문자열 변수에 저장
		 */
		
		String inFormFile = "src/com/biz/commerce/상품정보.txt";
		String strInoutFile = "src/com/biz/commerce/매입매출데이터.txt";
		
		/*
		 * 저장될 파일 이름(경로)를 문자열 변수에 저장
		 */
		String strWriter = "src/com/biz/commerce/매입매출정보.txt";
		
		/*
		 * Service 클래스를 초기화시켜서
		 * 사용할 준비를 한다.
		 */
		CommerceService cs = new CommerceService();
		/*
		 * 매개변수로 파일을 보내 각 파일을 읽는다.
		 */
		cs.InFormRead(inFormFile);
		cs.InOutRead(strInoutFile);
		
		/*
		 * 각 리스트들을 매칭시켜 inoutList에 저장한다.
		 */
		cs.MatchClass();
		/*
		 * 잘 저장되었는지 확인하기 위해 view 해본다.
		 */
		cs.view();
		
		/*
		 * PrintWriter를 이용해서 메모장에 저장한다.
		 */
		cs.Save(strWriter);
		

	}

}
