package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest2 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(10, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		System.out.println("정렬 전...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("----------------------------------------");
		
		//정렬하는것 //오름차순
		Collections.sort(memList);
		
		System.out.println("정렬 전...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("----------------------------------------");
		System.out.println();
		
		//회원 번호의 내림 차순으로 정렬하기(외부 정렬기준으로..)
		Collections.sort(memList, new SortNumDesc());
		System.out.println("정렬 전...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("----------------------------------------");
		System.out.println();
	}

}

// Member 클래스의 회원이름의 오름차순 정렬이 되도록하는 내부 정렬 기준 구현하기
// => Comparable 인터페이스를 구현한다.
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	
	//알트 쉽프트 s 자동생성자 
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	@Override
	public int compareTo(Member mem) {
		//회원 이름의 오름차순 정렬 기준 만들기
		return this.name.compareTo(mem.getName());
		
	
		//내림차순일 경우
		// return this.name.compareTo(mem.getName()); *-1 해주면 부등호가 바뀌므로 그렇다 
		
		
	}

}
//회원번호의 내림차순 정렬이 되도록하는 외부 정렬 기준 클래스 작성하기
class SortNumDesc implements Comparator<Member>{
	
	public int compare(Member mem1, Member mem2){
//		if(mem1.getNum() > mem2.getNum()){
//				return -1;
//		}else if(mem1.getNum() < mem2.getNum()){
//				return 1;
//		}else{
//			return 0;
//		}
//		
	//wrapper 클래스를 이용하는 방법1
	//return new Integer(mem1.getNum()).compareTo(mem2.getNum()) *-1;
	
	//wrapper 클래스를 이용하는 방법2
	return Integer.compare(mem1.getNum(), mem2.getNum()) *-1;
	}

 }







