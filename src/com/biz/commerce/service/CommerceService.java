package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.CommerceVO;

public class CommerceService {

	List<CommerceVO> inOutList;
	List<CommerceVO> inFormList;

	public CommerceService() {
		inOutList = new ArrayList();
		inFormList = new ArrayList();
	}

	public void InOutRead(String strInoutFile) {
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(strInoutFile);
			buffer = new BufferedReader(fr);

			while (true) {
				String strWord = buffer.readLine();
				if (strWord == null)
					break;

				String[] splWord = strWord.split(":");
				CommerceVO vo = new CommerceVO();
				vo.setStrDate(splWord[0]);
				vo.setStrCode(splWord[1]);
				vo.setStrInout(splWord[2]);
				vo.setIntPrice(Integer.valueOf(splWord[3]));
				vo.setIntquan(Integer.valueOf(splWord[4]));
				
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
	public void InFormRead(String inFormFile) {
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(inFormFile);
			buffer = new BufferedReader(fr);

			while (true) {
				String strWord = buffer.readLine();
				if (strWord == null)
					break;

				String[] splWord = strWord.split(":");
				CommerceVO vo = new CommerceVO();
				vo.setStrCode(splWord[0]);
				vo.setStrName(splWord[1]);
				vo.setIntInprice(Integer.valueOf(splWord[3]));
				vo.setIntOutprice(Integer.valueOf(splWord[4]));
				
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
	
	public void MatchClass() {
		for(CommerceVO vo : inFormList) {
			String strCode = vo.getStrCode();
			for(CommerceVO v : inOutList) {
				if(v.getStrCode().equals(strCode)) {
					
					v.setStrName(vo.getStrName());
					if(Integer.valueOf(v.getStrInout()) == 1) {
						v.setIntInprice(v.getIntPrice() * v.getIntquan());
					}else if(Integer.valueOf(v.getStrInout()) == 2){
						v.setIntOutprice(v.getIntPrice() * v.getIntquan());
					}
					
				}
			}
			
		}
	}
	
	public void view() {
		for(CommerceVO vo : inOutList) {
			System.out.println(vo);
		}
	}
	
	public void Save(String strWriter){
		PrintWriter pw;
		try {
			pw = new PrintWriter(strWriter);
			for(CommerceVO vo : inOutList) {
				pw.print(vo.getStrDate());
				pw.print(":");
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
				
				if((vo.getStrInout().equals("1"))) {
					pw.print(vo.getIntInprice());
					pw.print(":");
					pw.print("0");
					
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
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("저장완료");
	}

}
