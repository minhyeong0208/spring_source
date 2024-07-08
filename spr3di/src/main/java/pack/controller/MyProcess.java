package pack.controller;

import java.util.Scanner;

import pack.model.MoneyInter;

public class MyProcess implements MyInter {
	private MoneyInter inter;
	private int re[];
	
	public MyProcess(MoneyInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void inputMoney() {
		// 금액 입력 후, MoneyInter type 클래스를 이용해 금액 단위별 개수 결과 얻기
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("금액 입력 : ");
			int mymoney = scanner.nextInt();
			re = inter.calcMoney(mymoney);  // 일차원 배열 re 반환
		} catch (Exception e) {
			System.out.println("inputMoney err : " + e.getMessage());
		}
	}

	@Override
	public void showResult() {
		
//		StringBuffer sb = new StringBuffer();  // 문자열 더하기 대신 사용
//		sb.append("만원 : " + re[0] + "\n");
//		sb.append("천원 : " + re[1] + "\n");
//		sb.append("백원 : " + re[2] + "\n");
//		sb.append("십원 : " + re[3] + "\n");
//		sb.append("일원 : " + re[4] + "\n");
//		
//		System.out.println(sb.toString());
		
		StringBuilder sb = new StringBuilder();
		String[] units = {"만원", "천원", "백원", "십원", "일원"};
		for(int i = 0; i < re.length; i++) {
			sb.append(units[i] + " : " + re[i] + "\n");
		}
		System.out.println(sb.toString());
	}

}
