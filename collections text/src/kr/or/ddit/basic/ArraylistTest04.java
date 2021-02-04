package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

//문제2) 문제1에서 별명의 길이가 같은 것을 입력할 수 있는 경우를 처리하시오.
//		5명의 별명을 입력 받아 ArrayList에 저장하고
//		이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
//		(단, 각 별명의 길이가 같게 입력할수있다.)

public class ArraylistTest04 {

	public static void main(String[] args) {

		
		
		Scanner s = new Scanner(System.in);
		
		ArrayList<String> aliasList1 = new ArrayList<>();
		System.out.println("서로 다른 길이의 별명을 5개 입력하세요");
		for(int i = 1; i<=5; i++){
			System.out.print(i + "번째 별명을 입력하시오 : ");
			String alias = s.nextLine();
			aliasList1.add(alias);
		
	}

		/*제일 긴 별명의 길이가 저장될 변수를 선언하고
		이 변수는 List 의 첫번째 데이터의 길이로 초기화 한다.*/
		
		
		//int maxLength = aliasList1.get(0).length();
		
		
		int maxIndex = 0;
		// 제일 긴 별명이 저장된 index값이 저장될 변수를 선언하고 
		// 0으로 초기화 한다.
		
		for(int i=1; i<aliasList1.size(); i++){
//			if(maxLength < aliasList1.get(i).length()){
//				maxLength = aliasList1.get(i).length();
//			}
		}
		System.out.println("제일 긴 별명들....");
		for(int i =0; i<aliasList1.size(); i++){
//			if(aliasList1.get(i).length() == maxLength){
//				System.out.println(aliasList1.get(i));
//			}
			if(aliasList1.get(maxIndex).length() <
					aliasList1.get(i).length() ) {
				maxIndex =i;
			}
//			System.out.println("제일 긴 별명 : " + maxAlias);
			System.out.println("제일 긴 별명 : " + aliasList1.get(i));
		}
		
		
	}
}
