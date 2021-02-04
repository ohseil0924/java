package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("일지매");
		p2.setId(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		 
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		System.out.println("-----------------------------------");
		//비교를 하면 참조값으로 비교를 한다 
		//새로운 객체 new를 만들때마다 새로워지므로 처음 대조하면 false가 만들어진다
		//모든객체에는 equals가 있다. equals로 비교하면 p1==p2로 비교한거랑 같아진다. 
		// ㅡㅡ 
		Set<Person> testSet = new HashSet<>();
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("set의 크기" + testSet.size());
		
		System.out.println("p1의 hashcode : " + p1.hashCode());
		System.out.println("p2의 hashcode : " + p2.hashCode());
		System.out.println("p3의 hashcode : " + p3.hashCode());
		
		/*
			- equals()메서드 ==> 두 객체의 내용이 같은지 검사하는 메서드
			- hashCode()메서드 ==> 두 객체의 동일성을 검사하는 메서드
			
			- HashSet, Hashtable, hashMap과 같은 Hash로 시작하는
			컬렉션 객체들은 객체의 의미상의 동일성을 비교하기 위해서 hashCode()
			메서드를 호출해서 비교한다. 그러므로 객체가 같은지 여부를 결정하려면 
			hashCode를 재정의해야 한다.
			
			- hashCode() 메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 
				객체들에 대하여 같은 hashcode값이 나타날 수 있다.
				
		*/
	} 

}


class Person{
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	//컨트롤 스페이스바 이퀄스 
	/*@Override
	public boolean equals(Object obj) {
		if(obj ==null) return false;
		
		//같은 유형의 클래스인지 검사 
		if(this.getClass() != obj.getClass()){
			return false;
		}
		if(this==obj){ // 참조값이 같은지 검사
			return true;
		}
		// 매개변수의 값을 현재 객체 유형으로 형변환  한다.
		Person that = (Person)obj;
		
		if(this.name==null && that.name!=null){
			return false;
		}
		if(this.id==that.id && this.name==that.name){
			return true;
		}
		if(this.id==that.id && this.name.equals(that.name)){
			return true;
	}
		return false;*/
		
//}
	
	
	
}