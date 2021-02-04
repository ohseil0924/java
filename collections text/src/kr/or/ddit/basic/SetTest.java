package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		/*
		  --- List와 Set의 차이점 ----
		  
		1. Listㄴ
		  - List의 순서(index)가 있다.
		  - 중복되는 데이터를 저장 할 수있다.
		   
		2. Set
		  - 데이터의 순서(index)가 없다
		  - 중복되는 데이터를 저장 할 수 없다.
		*/
		
		HashSet hsl = new HashSet();
		
		// Set에 데이터를 추가할 때도 add()메서드를 사용한다.
		// add()메서드는 데이터 추가에 성공하면 true,
		// 그렇지 않으면 false를 반환한다.
		hsl.add("DD");
		hsl.add("AA");
		hsl.add(2);
		hsl.add("CC");
		hsl.add("BB");
		hsl.add(1);
		hsl.add(3);
		
		
		
		System.out.println("Set의 개수: " + hsl.size());
		System.out.println("Set의 데이터 " + hsl);
		//순서가 차례대로 들어가지않음 
		//list는 인덱스가 있기때문에 0번째 1번째 차례대로 들어가서 출력할때도 순서대로 나오지만
		//set는 그런 순서가 없다. set는 데이터를 큰 주머니에다가 집어 넣는 느낌 
		
		//Set에 데이터를 추가할 때 중복되면 false를 반환하고 
		//데이터 추가에 실패한다.
		Boolean isAdd = hsl.add("FF");
		System.out.println("중복되지 않을 때"+ isAdd);
		System.out.println("Set데이터 : " + hsl);
		
		isAdd = hsl.add("CC");
		System.out.println("중복되는 경우 : " + isAdd);
		System.out.println("Set데이터 : " + hsl);
		System.out.println();
		
		// Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 
		// 해당 자료를 삭제한 후 추가해 주어야 한다.
		
		// 자료삭제 : remove(삭제할 데이터) 
		// ==> 반환값 : 삭제성공 (true), 삭제실패(false)
		
		// clear() ==> 전체 자료 삭제
		
		// "FF" 데이터를 "EE"로 변경하기 
		// SET는 이걸 변경하는게 없어서 우선 지워야함 remove로 
		
		hsl.remove("FF");
		System.out.println("삭제후 : " + hsl);
		System.out.println();
		hsl.add("EE");
		System.out.println("Set데이터 : " + hsl);
		System.out.println();
		
//		hsl.clear();
//		System.out.println("clear 후 데이터" + hsl); //전체삭제
		
		/*
			Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를
			하나씩 불러올 수 없다.
			
			그럼 어떡하냐?
			
			그래서 데이터를 하나씩 얻기 위해서 Iterator형 객체로 변환을 해야한다. 
			
			- Set 형의 데이터를 Iterator형 객체로 변환하는 메서드 
				=> iterator()
			
		*/
		
		// set데이터를 Iterator로 변환하기
		System.out.println("----------------------------------------------");
		Iterator it = hsl.iterator(); 
		
		// Iterator의 hasNext() 메서드
		// 		=> Iterator의 포인터가 가리키는 곳 다음 번째 위치에 
		// 			데이터가 있으면 true, 없으면 false를 반환한다.
		
		while(it.hasNext()){
			// Iterator의 next() 메서드
//					==> Iterator의 포인터를 다음번째 위치로 이동한 후 
			//		그 곳의 데이터를 반환한다.
			System.out.println(it.next());
		}
		System.out.println("----------------------------------------------");
		System.out.println();

		// 중복되는 데이터를 찾아내는 역할에 자주쓰임 
		// 우리반의 학생들 중 번호를 이용하여 추첨하는 프로그램 작성하기.
		// 번호는 1번부터 25번까지 있고, 추첨할 인원은 3명이다.
		// 당첨 번호를 출력하시오.
		
		// (int)Math.random() *(최대값 - 최소값 + 1) +최소값 )
		
		HashSet<Integer> testSet = new HashSet<>();
		
		while(testSet.size()<3){
		int rnd = (int)(Math.random()* (25-1+1)+1);
		testSet.add(rnd);
		System.out.println(rnd);
		}
		System.out.println("당첨자 번호" + testSet);
		
		// Set유형의 데이터를 List형으로 변환하기 
		ArrayList<Integer> testList =
				new ArrayList<>(testSet);
		
		System.out.println("List데이터 출력하기..");
		for(int i=0; i<testList.size(); i++){
			System.out.println(testList.get(i));
		}
		System.out.println();
		
		// Set데이터를 향상된 for문을 사용하여 꺼내서 사용할 수 있다.
		//testset에있는걸 향상된 for문을 쓰면 이렇게된다.
		for(int test : testSet){
			System.out.println(test);
		}
		
	}

}
