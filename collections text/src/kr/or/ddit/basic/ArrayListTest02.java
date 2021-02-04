package kr.or.ddit.basic;
import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제) 5명의 사람 이름을 입력 받아서 AraayList에 저장한 후에 이들중 '김'씨 성을 가진 사람을 모두 출력하시오.
 		(입력은 Scanner 객체를 이용한다.)
 */
public class ArrayListTest02 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);	
		ArrayList<String> nameList = new ArrayList<>();
		
		for(int i =1; i<=5; i++){
			System.out.println(i + "번째 사람의 이름을 입력하시오");
			String name = s.nextLine();
			nameList.add(name);
			
			}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들....");
		
		for(int i=0; i<nameList.size(); i++){
//			if(nameList.get(i).charAt(0) == '김'){
//				System.out.println(nameList.get(i));
//			}
			
			if(nameList.get(i).substring(0,1).equals("김")){
				System.out.println(nameList.get(i));
//			}
//		if(nameList.get(i).indexOf("김") == '김'){
//			System.out.println(nameList.get(i));
		}
		
	}
		
	}
}
		
	


