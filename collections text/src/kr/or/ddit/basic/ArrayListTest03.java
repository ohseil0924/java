package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	문제1) 5명의 별명을 입력 받아 ArrayList에 저장하고
			이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
		(단, 각 별명의 길이는 모두 다르게 입력한다.)
		
		
	문제2) 문제1에서 별명의 길이가 같은 것을 입력할 수 있는 경우를 처리하시오.
*/
public class ArrayListTest03 {

	public static void main(String[] args) {

//		ArrayList<String> alasList = new ArrayList<>();
//		
//		int longalas = 0;
		Scanner s = new Scanner(System.in);
//		for(int i = 1; i<=5; i++){
//			System.out.println(i + "번째 별명을 입력하시오");
//			String alias = s.nextLine();
//			alasList.add(alias);
//			
//		}
//		
//		System.out.println();
//		System.out.println("별명");
//		for(int i=1; i<5; i++){
//			if(alasList.get(i).length()>alasList.get(longalas).length());
//			longalas=i;
//		}
//		System.out.println("입력하신 문자중 가장 긴 글자는" +alasList.get(longalas));
//		
		
		
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aliasList1 = new ArrayList<>();
		System.out.println("서로 다른 길이의 별명을 5개 입력하세요");
		for(int i = 1; i<=5; i++){
			System.out.print(i + "번째 별명을 입력하시오 : ");
			String alias = s.nextLine();
			aliasList1.add(alias);
	}
		
		//제일 긴 별명이 저장될 변수를 선언하고 이 변수에는
		//List의 첫번째 데이터로 초기화한다.
		String maxAlias = aliasList1.get(0);
		
		for(int i=1; i<aliasList1.size();i++){
			if(maxAlias.length()<aliasList1.get(i).length()){
				maxAlias = aliasList1.get(i);
			}
		}
		System.out.println("제일긴 별명 :" + maxAlias);
	
	}
	
}


