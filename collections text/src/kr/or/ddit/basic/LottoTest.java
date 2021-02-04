package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class LottoTest {
	static Scanner sc = new Scanner(System.in);
	static int money;
	/*
	 * 사용자는 로또를 구매할 때 구매할 금액을 입력하고
 입력한 금액에 맞게 로또번호를 출력한다.
 (단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
      거스름돈도 계산하여 출력한다.)

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	 2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 2500  <-- 입력
			
	행운의 로또번호는 아래와 같습니다.
	로또번호1 : 2,3,4,5,6,7
	로또번호2 : 20,21,22,23,24,25
			
	받은 금액은 2500원이고 거스름돈은 500원입니다.

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	 2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 900  <-- 입력
	
	입력 금액이 너무 적습니다. 로또번호 구입 실패!!!

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	 2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 101000  <-- 입력
	
	입력 금액이 너무 많습니다. 로또번호 구입 실패!!!
			
   	 ==========================
         Lotto 프로그램
	--------------------------
	  1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 2  <-- 입력
		
	감사합니다
	 */

	public static void main(String[] args) {
		start();
	}

	private static void start() {
	
		
		System.out.println("==========================");
		System.out.println("       Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println("       1. Lotto 구입");
		System.out.println("       2. 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴선택 : ");
		int input = Integer.parseInt(sc.nextLine());
		
		switch(input){
			case 1 : buy(); break;
			case 2 : 
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
		}
		
		
	}
	
	public static void buy() {
		System.out.println();
		System.out.println("=======◆Lotto 구입◆=======");
		System.out.println();
		System.out.println(" (1000원에 로또번호 하나입니다.)");
		System.out.println("금액입력 : ");
		int input = Integer.parseInt(sc.nextLine());
		if(input < 1000){
			System.out.println("입력금액이 너무 적습니다. 로또번호 구입 실패!!");
			start();
		}else if(input > 100000){
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
			start();
		}else{
			money = input;
			lottoNum();
			
		}
		
	}
	
	public static void lottoNum(){
		
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int j = 0; j < (money/1000); j++){
			HashSet hs = new HashSet();
			while(hs.size() < 6){
				int num = (int)((Math.random() * 45) +1);
				hs.add(num);
			}
			ArrayList<Integer> al = new ArrayList<>(hs);
			Collections.shuffle(al);
			System.out.print("로또번호" + (j + 1) + " : ");
			for(int x : al){
				System.out.print(x + ", ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("받은 금액은" + money + "원이고 거스름돈은 " + (money%1000) + "원입니다.");
		start();
		
	}

}