package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// 객체 생성
		Vector v1 = new Vector();
		
		System.out.println("처음 크기 :" + v1.size());
		
		//데이터 추가 :add(추가될 데이터)
		//반환값 : 추가성공(true), 실패(false)
		v1.add("aaaa");
		v1.add(new Integer(111));
		v1.add(123); //기본형을 바꿔주는것을 래퍼클래스라고한다 
		//	 ==> 오토박싱(기본자료형 ==> 랩퍼클래스형으로 자동변환) 
		// 	 ==> 오토언박싱( 랩퍼클래스형 ==> 기본자료형으로 자동 변환)
		
		v1.add('a'); //이건 숫자로 인식이 아닌 소문자 a의 코드값으로 취급당한다
		v1.add(true);
		boolean chk = v1.add(3.14);
		
		System.out.println("현재크기 :" + v1.size());
		System.out.println("반환값:"+ chk);
		
		//데이터 추가 : addElement(추가할데이터) 
		// ==> 이전 버전의 프로그램에서도 사용가능 하도록 하기 위해 남아 있는 메서드
		v1.addElement("CCC");
		
		System.out.println("v1 ==> " + v1.toString()); //toString 생략가능
		System.out.println("v1 ==> " + v1);
		
		//데이터 추가 : add(index, 추가할 데이터)
		// ==> index번째에 '추가할데이터'를 끼워 넣는다. (index는 0부터 시작)
		// ==> 반환값은 없다.
		v1.add(1,"kkk");
		System.out.println("v1 ==> " +v1);
		System.out.println("=================================");
		// 데이터 수정: set(index, 새로운데이터)
		// ==> index번째의 데이터를 '새로운데이터'로 덮어쓴다.
		// ==> 반환값 : 원래의 데이터를 출력해줌 
		
		String temp = (String)v1.set(1,"zzz");
		
		System.out.println("v1 ==> " + v1);
		System.out.println("반환값 : " + temp);
		
		System.out.println("=================================");
		//데이터 꺼내오기 : get(index)
		// ==> index번재의 데이터를 반환한다.
		int data = (Integer)v1.get(2);
		System.out.println("2번째 자료:" + data);
		System.out.println("=======================================");
		//데이터 삭제 : remove(index)
		// ==> index번째의 데이터를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("v1 ==> " + v1);
		
		temp = (String)v1.remove(0);
		System.out.println("v1 = " +v1);
		System.out.println("삭제된 데이터 : " +  temp);
		
		// 데이터 삭제 : remove(삭제할 데이터) 
		// ==> '삭제할 데이터' 를 찾아서 삭제한다.
		// ==> '삭제할 데이터' 가 여러개이면 앞에서부터 삭제된다
		// ==> 반환값: 삭제성공(true,false)
		// ==> 삭제할 데이터가 '정수형' 이거나 'char형'일 경우에는 반드시 객체로 변환해서 
		
		
		v1.remove("CCC");
		System.out.println("삭제후 v1 = " + v1);
		
//		v1.remove(123);
//		System.out.println("삭제후 v1 = " + v1); // 실행상은 문제가 업지만 123은 데이터로 인식하지않고 index로 인식해서 그렇다.
		// 즉 123번째의 자료를 지워라 라고 인식해버린거 
		
		v1.remove(new Integer(123)); //==> 데이터 123을 삭제하는 것이 아니라 123번째 자료를 삭제하는 것으로 해석된다.
		System.out.println("삭제후 v1 = " + v1);
		//new Integer()를 붙여줘야함 
		
		//v1.remove('a'); 코드값 97로 취급당함 그러므로 Character 써야함 
		v1.remove(new Character('a'));
		System.out.println("삭제후 v1 = " + v1);
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제후 v1 = " + v1);
		
		System.out.println("==================================================");
		//==============================================================================================
		
		
		/*
		 -제네릭 타입 (Generic Type) ==> 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 말한다.
		 	==> 객체를 선언할 때 괄호(<>)안에 그 클래스 내부에서 사용할 데이터의 타입을 정해주는 것을 말한다.
		 	==> 이런식으로 선언하게 되면 그 데이터 타입 이외의 다른 데이터를 저장할 수 없게 된다.
		 	==> 이 때 제네릭으로 선언될 수 있는 데이터 타입은 '클래스형' 이어야 한다.
		 	 	즉, int 는 Integer, boolean은 Boolean, char는 Character 등으로 대체해서 사용해야 한다.
		 	==> 제네릭 타입으로 선언하게 되면 데이터를 꺼내 올 때 형변환이 필요없다,
		 */
		
		System.out.println("=============================================");
		Vector<String> v2 = new Vector<>();   //생략해서 사용가능하다
		Vector<String> v22 = new Vector<String>();
		
		Vector<Integer> v3 = new Vector<>();
//		Vector<int> v33 = new Vector<>(); // 제네릭 타입은 반드시 '클래스형'으로 지정해야한다.
		Vector<Integer> v333 = new Vector<Integer>();
		
		v22.add("안녕하세요");
//		v22.add(123); //오류 ; 다른 종류의 데이터를 저장할 수 없다.
		
		String temp2 = v22.get(0); //형번환이 필요가 없다.
		System.out.println("temp2 = " + temp2);
		
		Vector<Vector> vv = new Vector<>(); //백터안에 백터를 저장할수있다 // 2차원 배열
		Vector<Vector<Vector>> vvv= new Vector<>(); //3차원배열 
		System.out.println("=============================================");
		
		
		System.out.println("--------------------------------------------------------");
		System.out.println();
		
		// 전체 데이터 삭제하기 : clear();
		v1.clear();
		
		System.out.println("============================================-=");
		System.out.println("v1의 개수" + v1.size());
		System.out.println("clear 후v1 = " + v1);
		System.out.println();
		
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("v2 = " + v2);
		System.out.println("v4 = " + v4);
		
		// 데이터 삭제 : removeAll(Collection객체)  
		// ==> 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		// ==> 반환값: 삭제 성공(true), 삭제 실패(false)
		
		v2.removeAll(v4);
		//v2에서 v4랑 똑같은걸 모두 다 지워라
		System.out.println("v2 = " + v2);
		
		v2.clear();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println();
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		// Vector에 저장된 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다.
		// (보통 for 문을 많이 사용한다.)
		 
		for(int i = 0; i<v2.size();i++){
			System.out.println(i+ "번째 자료:" + v2.get(i));
		}
		System.out.println("-----------------------------------------------------------");
		
		// 향상된 for문
		/*
		// 형식) for(자료형명 변수명 : 배열이나 List 또는 Set형 객체 변수){
					처리할 내용들 ;
					...
				}
		
		*/
		for(String str : v2){
			System.out.println(str);
		}
		
		
		
		
	}

}
