package kr.or.ddit.basic;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 작성하고,
 * 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * 		
 * 		- 삭제, 검색기능은 '이름'을 입력 받아서 처리한다.
 * 
 * 		(Map의 구조는 key값으로 '이름'을 사용하고,
 * 		value값으로는 'Phone클래스의 인스턴스'로 한다.)
 * 		
 * 		아래 메뉴의 내용을 프로그램하시오.
 * 
 * 실행예시 )
 * --------------------
 * 다음 메뉴를 선택하시오.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ----------------------
 * 번호입력 >> 1
 * 
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름 >> 홍길동
 * 전화번호 >> 010-1111-1111
 * 주소 >> 대전시 중구 대흥동
 * 
 * '홍길동' 전화번호 등록 완료!!
 
 * --------------------
 * 다음 메뉴를 선택하시오.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ----------------------
 * 번호입력 >> 1 
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름 >> 홍길동
 * '홍길동'은 이미 등록된 사람입니다.
 * 
   --------------------
 * 다음 메뉴를 선택하시오.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ----------------------
 * 번호입력 >> 5
 * 
 *  ---------------------------------------------
 *  번호	이름		전화번호		주소
 *  ---------------------------------------------
 *   1		홍길동		010-1111-1111	대전시 중구 대흥동
 *  ...
 *  ...
 *  ---------------------------------------------
 *  출력완료...
 *  
 *	 --------------------
 * 다음 메뉴를 선택하시오.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ----------------------
 * 번호입력 >> 0
 * 
 *  프로그램을 종료합니다.
 */
public class test1 {
	Map<String, Phone> phoneBookMap = new HashMap<>();
	Scanner s = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		new test1().start();
		
	}
	public void start(){
		while(true){
			int choice = show();
			switch(choice){
			case 1 : insert(); break;
			case 2 : update(); break;
			case 3 : delete(); break;
			case 4 : select(); break;
			case 5 : selectList(); break;
			case 0 : System.exit(0); 
			}
		}
	}
	public int show(){
		System.out.println();
		System.out.println("다음 메뉴를 선택하시오.");
		System.out.println();
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 전화번호 종료");
		System.out.println("--------------------------");
		System.out.print("번호입력 >> ");
		int choice = Integer.parseInt(s.nextLine());
		return choice;
	}
	public void insert(){
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = s.nextLine();
		System.out.print("전화번호 >> ");
		String phone_num = s.nextLine();
		System.out.print("주소 >> ");
		String address = s.nextLine();
		System.out.println();
		if(!phoneBookMap.containsKey(name)){
			phoneBookMap.put(name, new Phone(name, phone_num, address));
			System.out.println("'"+name+"' 전화번호 등록 완료!!");
		}else{
			System.out.println("'"+name+"'은 이미 등록된 사람입니다.");
		}
	}
	public void update(){
		System.out.println("수정할 이름 >>");
		String name = s.nextLine();
		System.out.println("변경할 전화번호를 입력해 주세요 >>");
		String phone_num = s.nextLine();
		System.out.println("변경할 주소를 입력해 주세요 >>");
		String address = s.nextLine();
		System.out.println();
		if(phoneBookMap.containsKey(name)){
			phoneBookMap.put(name, new Phone(name, phone_num, address));
			System.out.println("'"+name+"' 전화번호 수정 완료!!");
		}else{
			System.out.println("'"+name+"'은 존재하지 않는 사람입니다. 새로 등록해주세요.");
		}
	}
	public void delete(){
		System.out.println("수정할 이름 >>");
		String name = s.nextLine();
		if(phoneBookMap.containsKey(name)){
			System.out.println("정말 삭제하시겠습니까?(Y/N) >> ");
			String y = s.nextLine();
			if(y.equals("y")||y.equals("Y")){
				phoneBookMap.remove(name);
			}
		}else{
			System.out.println("'"+name+"'은 존재하지 않는 사람입니다. 새로 등록해주세요.");
		}
	}
	public void select(){
		System.out.println("검색할 이름 >>");
		String name = s.nextLine();
		if(phoneBookMap.containsKey(name)){
			System.out.println("-------------------------------------------------------");
			System.out.println("이름 : " + phoneBookMap.get(name).getName());
			System.out.println("전화번호 : " + phoneBookMap.get(name).getPhoneNum());
			System.out.println("주소 : " + phoneBookMap.get(name).getAddr());
			System.out.println("-------------------------------------------------------");
		}else{
			System.out.println("'"+name+"'은 존재하지 않는 사람입니다. 새로 등록해주세요.");
		}
	}
	public void selectList(){
//		  ---------------------------------------------
//		  *  번호	이름		전화번호		주소
//		  *  ---------------------------------------------
//		  *   1		홍길동		010-1111-1111	대전시 중구 대흥동
//		  *  ...
//		  *  ...
//		  *  ---------------------------------------------
//		  *  출력완료...
//		  *  
//		  *	 --------------------

		System.out.println("-------------------------------------------------------");
		System.out.println("번호\t이름\t\t전화번호\t\t주소");
		System.out.println("-------------------------------------------------------");
		int cnt=0;
		for(String key : phoneBookMap.keySet()){
			cnt++;
			System.out.println("  "+cnt+"\t"+phoneBookMap.get(key).name+"\t\t"+phoneBookMap.get(key).phoneNum+"\t\t"+phoneBookMap.get(key).addr);
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("출력완료...");
		System.out.println("-------------------------------------------------------");
		
	}
}

class Phone{
	String name;
	String addr;
	String phoneNum;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Phone(String name,  String phoneNum, String addr) {
		super();
		this.name = name;
		this.addr = addr;
		this.phoneNum = phoneNum;
	}
}