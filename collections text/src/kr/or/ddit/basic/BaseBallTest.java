package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class BaseBallTest {
/*
*  문제) Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오.
*  	컴퓨터의 숫자는 난수를 이용하여 구한다.
*      (스트라이크는 S, 볼은 B로 나타낸다.)
*
*  예시)
*  컴퓨터의 난수 ==> 9 5 7
*
*  실행예시)
*  숫자입력 => 3 5 6
*  3 5 6 ==> 1S 0B
*  숫자입력 => 7 8 9
*  7 8 9 ==> 0S 2B
*  숫자입력 => 9 7 5
*  9 7 5 ==> 1S 2B
*  숫자입력 => 9 5 7
*  9 5 7 => 3S 0B
*
*  축하합니다.
*  당신은 4번째만에 맞췄군요
*/


public static void main(String[] args) {
	HashSet<Integer> hs = new HashSet<>();
	
	while(hs.size() < 3){
		int num = (int)(Math.random() * 10);
		hs.add(num);
	}
	
	ArrayList<Integer> al = new ArrayList<>(hs);
	
	//Set은 순차적으로 정렬이 되어주기 때문에 한번 섞어 준다.
	Collections.shuffle(al);
	
	System.out.println("정답 : " + al);
	
	int s = 0;
	int b = 0;
	int cnt = 0;
	while(s < 3){
		s = 0;
		b = 0;
		System.out.println("숫자입력 >");
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		String[] eachNum = num.split(" ");
		
		for(int i = 0; i < 3; i++){
			if(Integer.parseInt(eachNum[i]) == al.get(i)){
				s ++;
			}else{
				for(int j = 0; j < 3; j++){
					if(Integer.parseInt(eachNum[i]) == al.get(j)){
						b++;
					}
				}
			}
		}
		System.out.println(Arrays.toString(eachNum)+ " ==> " + s + "S " + b + "B");
		
		cnt++;
	}
	
	System.out.println("축하합니다. 당신은 " + cnt + "번째만에 맞췄군요..");

	

}

}

