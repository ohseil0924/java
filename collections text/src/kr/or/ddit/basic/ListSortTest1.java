package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
	- 정렬과 관련된 interface Comparable, Comparator 이렇게 두 가지 가 있다.
	
	- Comparable은 Collection에서 추가되는 데이터 자체에 정렬기준을 
		넣고 싶을때(내부 정렬 기준)구현하는 interface이고, 
		
	- Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때
		(외부 정렬 기준) 구현하는 interface이다.
		
  	- Comparable에서는 CompareTo() 메서드를 재정의 하고 
  	  Comparator에서는 compare() 메서드를 재정의 해야 한다.
  	  
    - String클래스 , Wrapper 클래스, Date 클래스, file 클래스에는
    	내부 정렬 기준이 구현되어 있다.
    	(내부 정렬 기준은 보통 오름차순으로 처리되도록 구현되어 있다.)
    	
    	
  	
*/

public class ListSortTest1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		//이걸 순차대로 하면 ㄱㄴㄷㄹㅁㅂㅅ 아스키코드로 정렬됨
		
		System.out.println("정렬 전 : " + list);
		
		// collection의 정렬은 Collectrions.sort() 메서드를 이용한다.
		// 형식1) Collections.sort(리스트);
		// 		==> 내부 정렬 기준이 구현되어 있는 데이터 일 경우에 사용가능
		// 형식2) Collections.sort(리스트, 외부정렬기준 객체의인스턴스)
		// 		==> 외부 정렬 기준에 맞게 정렬한다.
		Collections.sort(list);
		System.out.println("정렬 후 : " + list);
		
		Collections.shuffle(list); // 데이터를 섞기
		System.out.println("자료 섞기 후 : " + list);
		
		//외부 정렬 기준을 지정해서 정렬하기
		
//		Desc dd = new Desc();
//		Collections.sort(list,dd); 이것도 됨
		
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후 :" + list);
		
		
	}

}

// 정렬 방식을 외부에서 정해주는 class 작성하기
// 즉, 외부 정렬 기준 클래스 작성하기 ==> Comparator 인터페이스를 구현해야한다.
	class Desc implements Comparator<String>{
		
		// compare()메서드를 이용해서 정렬 기준을 정해 준다.
		
		// compare()메서드의 반환값의 역할이 중요함 (int)
		// 반환값이 0이면 두 값이 같다. (String str1, String str2)
		// 반환값이 양수이면 앞, 뒤의 순서를 바꾼다.
		// 반환값이 음수이면 앞, 뒤의 순서를 바꾸지 않는다.
		
		// 예) 오름차순일 경우 ==> 앞의 값이 크면 양수, 같으면 0 
		// 					     앞의 값이 작으면 음수를 반환하도록 구현하면 된다.

		
//컨트롤스페이스바
		@Override
		public int compare(String str1, String str2) {
		// 내림차순으로 정렬되도록 구현하기
			if(str1.compareTo(str2)>0){
				return -1;
			
			}else if(str1.compareTo(str2)<0){
				return 1;
			}else{
				return 0;
			}
		}
	}



