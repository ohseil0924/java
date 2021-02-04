package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 문제) 이름, 주소, 전화번호를 맴버로 갖는 Phone클래스를 작성하고, 
 	Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 	
 	-삭제, 검색기능은 '이름'을 입력받아서 처리한다.
 	
 	(Map의 구조는 key값으로 '이름'을 사용하고,
 		value 값으로는 'Phone 클래스의 인스턴스'로 한다.)
 	
 	아래 메뉴의 내용을 프로그램 하시오 .
 	
 	실행예시)
 		--------------------
 		다음 메뉴를 선택하세요.
 		
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 		--------------------
 		번호입력 >> 1 
 		
 		새롭게  등록할 전화번호 정보를 입력하세요.
 		이름 >> 홍길동 
 		전화번호 >> 010-1111-1111
 		주소 >> 대전시 중구 대흥동

		--------------------
 		다음 메뉴를 선택하세요.
 		
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 		--------------------
 		번호입력 >> 1 
 		
 		'홍길동'
 		
 		 '홍길동' 은 이미 등록된 사람입니다.
 		 
 		 --------------------
 		다음 메뉴를 선택하세요.
 		
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 		--------------------
 		번호 입력 >> 5
 		
 		--------------------------------------------
 		번호 		이름 		전화번호 			 주소
 		--------------------------------------------
 		1 		홍길동 	010-1111-1111	대전시 중구 대흥동
 		~~~~
 		~~~~
 		--------------------------------------------
 		출력 완료...
 		
 		--------------------
 		다음 메뉴를 선택하세요.
 		
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 		--------------------
 		
 		번호입력 >> 0 
 		
 		프로그램을 종료합니다.
*/
public class PhoneBookTest {
	Scanner scan = new Scanner(System.in);
	HashMap<String,Phone> phone = new HashMap<>();
	private HashMap<String, Phone> PhoneBookMap;
	private HashMap<String, Phone> phoneBookMap;
	//private Object ;
	public static void main(String[] args) {
		new PhoneBookTest().restart();
	}
	
	public void restart(){
		while(true){
		int choice = Menu();
			switch(choice){
				case 1: //전화번호 등록
					insert();
					break;
				case 2: //전화번호 수정
					update();
					break;
				case 3: //전화번호 삭제
					delete();
					break;
				case 4: //전화번호 검색
					search();
					break;
				case 5: //전화번호 전체 출력
					all();
					break;
				case 0: //종료
					System.out.println("끝");
					System.exit(0);
					return;
				default : 
					System.out.println("번호를 잘못 입력하셨습니다");
					System.out.println("다시 입력하세요.");
			}
		}
	}
	
	private void all() {
		Set<String> keyset = phone.keySet();
		System.out.println("-----------------------");
		System.out.println("번호\t이름\t전화번호\t주소");
		System.out.println("-----------------------");
		//System.out.println(phone.get(name) + phone.get("name") + phone.get("adr") + phone.get("tel") );
		System.out.println("-----------------------");
		int cnt =0;
		for(String key : phone.keySet()){
			cnt++;
			String name = phone.get(key).name;;
			String tel = phone.get(key).gettel();
			String adr = phone.get(key).getAdr();
			System.out.println(cnt+"\t"+name + "\t"+ tel+"\t"+adr);
		}
		
		
	}
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.println("이름>>");
		String name = scan.next();
		
	}
	
	
	
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호를 입력하세요");
		System.out.println("이름 >>");
		String name = scan.next();
	
		phoneBookMap.remove(name);
		System.out.println(name + "씨를 삭제하였습니다.");
		
	}
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >>");
		String name = scan.next();
		
		System.out.print("새로운 전화번호>>");
		String newTel = scan.next();
		
		System.out.print("새로운 주소>>");
		String newAddr = scan.next();
		
		PhoneBookMap.put(name, new Phone(name, newAddr, newTel));
		
		System.out.println(name + "씨 정보를 수정했습니다.");
		
	}
	

	private void insert() {
		System.out.println("----------------------------");
		System.out.println("번호\t이름\t주소\t전화번호");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("이름>");
		String name =scan.nextLine();
		
		//이미등록된사람인지 검사
	
		System.out.println("주소>");
		String adr =scan.nextLine();
		System.out.println("전화번호>");
		String tel =scan.nextLine();

		phone.put(name, new Phone(name, adr, tel));
		//if문
		System.out.println("전화번호 등록이 완료되었습니다.");
	}
	private int Menu(){
		System.out.println("------------------------");
		System.out.println("다음 메뉴를 선택하세요");
		System.out.println();
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("-----------------------");
		System.out.println("번호입력 >");
		int num = Integer.parseInt(scan.nextLine());
		
		return num;
	}
}
class Phone{
	String name;
	String adr;
	String tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public String gettel() {
		return tel;
	}
	public void settel(String tel) {
		this.tel = tel;
	}
	
	public Phone(String name, String adr, String tel) {
		super();
		this.name = name;
		this.adr = adr;
		this.tel = tel;
	}
}
