package com.biz.commerce.service;

/*
 * 매입매출 관련 처리릘 위해
 * 클래스를 선언
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.CommerceVO;

public class CommerceService {
	
	/*
	 * 각 데이터를 관리할 List변수들 선언
	 */

	List<CommerceVO> inOutList;
	List<CommerceVO> inFormList;

	public CommerceService() {
		inOutList = new ArrayList();
		inFormList = new ArrayList();
	}
	
	/*
	 * 매입매출데이터.txt 파일에서 문자열을 읽어서
	 * iolist에 저장하는 메서드 선언
	 */

	public void InOutRead(String strInoutFile) {
		
		/*
		 * Text 파일을 읽기 위한 FileReader 객체 선언
		 */
		FileReader fr;
		
		/*
		 * FileReader로 읽은 내용에서 문자열을 쉽게
		 * 추출할 수 있도록 연결되는 Buffer 객체 선언
		 */
		BufferedReader buffer;
		


		try {
			
			/*
			 * 생성자에서 값이 할당된 ioFile의 내용을 참조하여
			 * 파일을 읽기 위하여 open하는 코드
			 * 
			 * 이 코드는 작동되는 과정에서 불가항력적인
			 * 문제가 발생할 소지가 있으므로
			 * 반드시 try..catch 문으로 감싸 주어야 한다.
			 */
			
			fr = new FileReader(strInoutFile);
			
			/*
			 * FileReader로 open된 파일 정보를
			 * Buffer에 연결하여 준다.
			 * 이 코드가 실행되면
			 * BufferedReader는 일단 파일을 읽어서
			 * 메모리의 Buffer 영역에 저장해 둔다.
			 */
			
			buffer = new BufferedReader(fr);
			
			/*
			 * 무한반복문을 이용해서
			 * Buffer에 저장된 파일내용에서
			 * 한줄씩 (문자열로)읽어서 처리한다.
			 */
			

			while (true) {
				
				/*
				 * buffer에서 한줄을 읽어서
				 * reader 변수에 저장
				 */
				String strWord = buffer.readLine();
				
				/*
				 * 만약 reader에 저장된 값이 null이면
				 * 모든 문자열을 다 읽었다는 것이므로
				 * 반복문을 종료한다.
				 */
				if (strWord == null)
					break;
				
				/*
				 * 반복문이 종료되지 않았으므로
				 * reader 변수에 문자열이 담겨 있다는 것
				 * reader 문자열을 콜론(:)으로 분리해서
				 * iolistVO에 담고
				 * iolist에 추가하는 부분
				 */
				
				

				String[] splWord = strWord.split(":");
				
				/*
				 * 새로운 vo의 생성(선언과 초기화)
				 */
				CommerceVO vo = new CommerceVO();
				/*
				 * vo의 각 member변수에 값을 저장(할당)
				 */
				vo.setStrDate(splWord[0]);
				vo.setStrCode(splWord[1]);
				vo.setStrInout(splWord[2]);
				/*
				 * vo.io_price는 int형 변수 이므로
				 * 문자열을 int로 변환한다.
				 */
				vo.setIntPrice(Integer.valueOf(splWord[3]));
				vo.setIntquan(Integer.valueOf(splWord[4]));
				
				/*
				 * 파일을 모두 사용(읽기)했으므로
				 * 안전하게 닫아 준다 
				 */
				inOutList.add(vo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 상품정보 파일을 읽고 inFormList에 저장하는 메서드 생성
	 * 파일을 매개변수로 받아 메서드를 수행한다.
	 */
	public void InFormRead(String inFormFile) {
		/*
		 * 파일을 open하기 위해 FileReader 객체 선언
		 */
		FileReader fr;
		/*
		 * 파일을 읽기 위해 BufferedReader 객체 선언
		 */
		BufferedReader buffer;

		try {
			/*
			 * FileReader는 실행할 때 불가항력적인
			 * 오류가 발생할 수 있으므로
			 * 항상 try catch로 묶는다
			 */
			fr = new FileReader(inFormFile);
			
			/*
			 * FileReader로 열린 파일을
			 * buffer로 연결해준다.
			 */
			buffer = new BufferedReader(fr);
			
			
			/*
			 * buffer는 한줄씩 읽는 것이기 때문에
			 * 다 읽을때까지 while문을 이용해 계속해서 반복한다.	
			 */

			while (true) {
				/*
				 * buffer로 한줄씩 읽고
				 */
				String strWord = buffer.readLine();
				/*
				 * 한줄씩 읽다가 다 읽고 마침내 null값이 나오면
				 * 멈춘다.
				 */
				if (strWord == null)
					break;
				
				/*
				 * buffer로 한줄씩 읽은 값을
				 * ":" 문자열을 기준으로 자른다
				 * 자른 문자열을  vo에 있는 변수에 각각 넣는다.
				 */

				String[] splWord = strWord.split(":");
				CommerceVO vo = new CommerceVO();
				vo.setStrCode(splWord[0]);
				vo.setStrName(splWord[1]);
				
				/*
				 * buffer로 읽은것은 문자열이고
				 * intinPrice, intOutPrice는 int형이기때문에
				 * int형으로 변환시켜준다
				 * 
				 */
				vo.setIntInprice(Integer.valueOf(splWord[3]));
				vo.setIntOutprice(Integer.valueOf(splWord[4]));
				
				/*
				 * vo 변수에  넣은 값을 List에 저장하기위해
				 * CommerceVO 형태의 inFormList에 저장한다.
				 */
				inFormList.add(vo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * inFormList에 저장된 vo들과
	 * inOutList에 저장된 vo들을
	 * 서로 매칭시킨다
	 * 이 때 상품코드가 같은 것에
	 * 각 vo를 매칭시킨다
	 * 여기에서는 inFormList의 수보다 inoutList의 수가 더 적기때문에
	 * inFormList를 밖에서 for을 돌리고
	 * 그 안에서 inOutList를 돌려 inOutList의 수만큼 vo에 저장되도록 한다.
	 */
	public void MatchClass() {
		for(CommerceVO vo : inFormList) {
			/*
			 * informList에 저장된 strCode를 꺼내서
			 * String형 strCode에 넣고
			 */
			String strCode = vo.getStrCode();
			for(CommerceVO v : inOutList) {
				/*
				 * 위에서 저장한 String형 strCode와 inoutList 에서의 strcode를 비교하여
				 * 서로 일치하면
				 * inoutList의 v에 inFormList의 vo 값을 넣어준다. 
				 */
				if(v.getStrCode().equals(strCode)) {
				
					v.setStrName(vo.getStrName());
					
					/*
					 * strInOut이 1이면(매입이면)
					 * 단가 * 수량을 intinprice에 저장한다.
					 */
					if(Integer.valueOf(v.getStrInout()) == 1) {
						v.setIntInprice(v.getIntPrice() * v.getIntquan());
						/*
						 * strInOut이 2이면(매출이면)
						 * 단가 * 수량을 intOutprice에 저장한다.
						 */
						
					}else if(Integer.valueOf(v.getStrInout()) == 2){
						v.setIntOutprice(v.getIntPrice() * v.getIntquan());
					}
					
				}
			}
			
		}
	}
	
	/*
	 * 검증하기 위해 inoutList의 vo 들을 콘솔에 나타내 본다.
	 */
	
	public void view() {
		for(CommerceVO vo : inOutList) {
			System.out.println(vo);
		}
	}
	
	/*
	 * 메모장에 저장하기 위한 메서드
	 * 저장할 파일 주소를 매개변수로 받는다.
	 */
	public void Save(String strWriter){
		/*
		 * 메모장에 쓰기 위해 PrintWriter라는 클래스로
		 * pw를 선언하고
		 */
		PrintWriter pw;
		try {
			/*
			 * 오류가 생길것을 방지하기 위해 항상 printWriter를 쓸땐
			 * 초기화 시킬 때
			 * try catch로 묶는다
			 */
			pw = new PrintWriter(strWriter);
			/*
			 * MatchClass에서 inoutList에 모든 vo를
			 * 저장해놨기 때문에
			 * inoutList에서 데이터를 get한다.
			 */
			for(CommerceVO vo : inOutList) {
				
				pw.print(vo.getStrDate());
				pw.print(":");
				/*
				 * strInout이 1일 땐 "매입"을 저장하고
				 * 2일 땐 "매출"을 저장한다.
				 */
				if(vo.getStrInout().equals("1")) {
					pw.print("매입");
				}else if(vo.getStrInout().equals("2")) {
					pw.print("매출");
				}
				
				pw.print(":");
				pw.print(vo.getStrCode());
				pw.print(":");
				pw.print(vo.getStrName());
				pw.print(":");
				pw.print(vo.getIntPrice());
				pw.print(":");
				pw.print(vo.getIntquan());
				pw.print(":");
				
				/*
				 * strinout이 1이면(매입이면)
				 * 매입가격을 저장하고
				 * 매출가격은 0으로 저장한다.
				 */
				if((vo.getStrInout().equals("1"))) {
					pw.print(vo.getIntInprice());
					pw.print(":");
					pw.print("0");
					/*
					 * strinout이 2이면(매출이면)
					 * 매출가격을 저장하고
					 * 매입가격은 0으로 저장한다.
					 */	
			
					
				}else if((vo.getStrInout().equals("2"))) {
					pw.print("0");
					pw.print(":");
					pw.print(vo.getIntOutprice());
				}else {
					pw.print("0");
					pw.print(":");
					pw.print("0");
				}
				pw.println();
				
				
			}
			/*
			 * PrintWriter는 꼭 close를 해주어야 실행이 되기 때문에
			 * 꼭 close를 해준다.
			 */
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * 저장이 다 되면 콘솔에 "저장완료"를 출력한다.
		 */
		System.out.println("저장완료");
	}

}
