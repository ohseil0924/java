package kr.or.ddit.basic;

class NonGenericClass{
	private Object value;
	private int kor;
	
	public void setKor(int kor){
		if(kor <0 || kor >100){
			this.kor= 0;
		}else{
			this.kor =kor;
		}
	}
	
	
	
	public void setValue(Object value){
		this.value = value;
	}
	
	public Object getValue(){
		return value;
	}
	
	
}

/*
	제네릭 클래스를 만드는 방법
형식)
	class 클래스명<제네릭타입글자>{
		제네릭타입글자 변수명; //변수 선언에 제네릭을 사용할 경우
			...
		
		제네릭타입글자 메서드명(){ //메서드의 반환값에 제네릭을 사용할 경우
			...
			return 값;
		}
		void 메서드명(제네릭타입글자 변수명){ //메서드의 매개변수에 제네릭을 사용할 경우 
			...
	}
 -- 제네릭 타입 글자로 많이 사용되는 것 -- 
 	T --> Type
 	K --> Key
 	V --> Value
 	E --> Element(자료구조에 들어가는 것들을 주로 나타낸다.)
*/

class MyGenerric<T>{
	private T value;
	
	public void setValue(T value){
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
	
}



public class GenericTest {

	
	public static void main(String[] args) {
		NonGenericClass ng1 =new NonGenericClass();
		ng1.setValue("가나다라");
		
		NonGenericClass ng2 =new NonGenericClass();
		ng2.setValue(100);
		
		String rtnNg1 =(String)ng1.getValue();
		System.out.println("문자열 반환값 : " + rtnNg1);
		int rtnNg2 = (int)ng2.getValue();
		System.out.println("정수 반환값" + rtnNg2 );
		System.out.println();
		
		//String rtnNg3 = (String)ng2.getValue();
		//System.out.println("rtnNG3 =" + rtnNg3);
		
		System.out.println("-------------------------------");
		System.out.println();
		
		MyGenerric<String> mg1 =new MyGenerric<>();
		MyGenerric<Integer> mg2 =new MyGenerric<>();
		
		mg1.setValue("우리나라");
		mg2.setValue(500);
		
		String rtnMg1 = mg1.getValue();
		int rtnMg2 = mg2.getValue();
		
//		mg1.setValue(200);	
//		mg1.setValue("가나다");	
		//제네릭을 사용하면 컴파일단계에서 오류를 찾을수있다 제네릭이 없을때는 컴파일에는 뜨지않아서 찾기가 힘들다 
		
		System.out.println("문자열 반환값 : " + rtnMg1);
		System.out.println("정수 반환값 : " + rtnMg2);
		
		
				
	}

}
