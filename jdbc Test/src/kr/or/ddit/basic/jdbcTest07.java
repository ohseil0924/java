package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
	
	-회원을 관리하는 프로그램을 작성하시오.
	(오라클 DB의 MyMEMBer 테이블 이용)
	
	- 아래 메뉴의 기능을 모두 구현하시오. (CRUD 구현하기 연습)
	메뉴예시)
	-- 작업선택 --
	1. 자료 추가 -id가 중복되는지 안되는지 체크 
	2. 자료 삭제
	3. 자료 수정
	4. 전체 자료 출력
	0. 작업 끝.
	-----------
	작업선택>>
*/

public class jdbcTest07 {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Scanner scan = new Scanner(System.in);
	
	public jdbcTest07() {
		conn = DBUtil.getConnection();
	}
		
	
	public static void main(String[] args) {
		new jdbcTest07().start();
		
	}
	
	public void start(){
		
		System.out.println("----작업 선택-----");
		System.out.println("1.자료 추가");
		System.out.println("2.자료 삭제");
		System.out.println("3.자료 수정");
		System.out.println("4.전체 자료 출력");
		System.out.println("5.자료수정 2");
		System.out.println("0.작업 끝");	
		int input = scan.nextInt();
		
		
		switch(input) {
		case 1:	//입력
			add();
			break;
			
		case 2://삭제
			remove();
			break;
			
		case 3://수정
			readd();
			break;
			
		case 4://전체출력
			displayMember();
			break;
			
		case 5://자료수정 2
			read2();
			break;
			
		case 0:
			System.out.println("종료되었습니다.");
			System.exit(0);
			break;

		}
		
	}
	
	
	public void add(){ //입력
		Scanner scan = new Scanner(System.in);
		
		System.out.println("사용하실 ID 입력해라");
		String userId = scan.nextLine();
		System.out.println("사용하실 이름 입력해라");
		String username = scan.nextLine();
		System.out.println("사용하실 전화번호 입력해라");
		String tel = scan.nextLine();
		System.out.println("살고있는 주소 입력해라");
		String adr = scan.nextLine();
		
		String sql = "INSERT INTO MYMEMBER (MEM_ID,MEM_NAME,MEM_TEL,MEM_ADDR)"
				+ " VALUES(?, ?, ?, ?) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, username);
			pstmt.setString(3, tel);
			pstmt.setString(4, adr);
			
			int result = pstmt.executeUpdate();
			System.out.println("반환값" + result);
			
			if(result ==1){
				System.out.println(userId + "입력완료");
			}else{
				System.out.println(userId + "입력실패");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
		
		
		
		
	}
	
	public void remove(){ //삭제
		
		try {
			System.out.println("삭제할 ID ");
			String userId = scan.next();
			
			String sql ="DELETE FROM MYMEMBER WHERE MEM_ID =?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			int result =pstmt.executeUpdate();
			System.out.println("반환값 " + result);
			
			if(result ==1){
				System.out.println("삭제가 완료 되었습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
		
		
	}
	
	public void readd(){ //수정
		try {
		System.out.println("수정하는거임 ");
		System.out.println("수정할 아이디");
		String userId = scan.next();
		System.out.println("수정할 이름 입력");
		String username = scan.next();
		System.out.println("수정할 번호");
		String tel = scan.next();
		System.out.println("수정할 주소");
		String adr = scan.next();
		
		String sql = "UPDATE MYMEMBER SET "
							+ "MEM_NAME = ?,"
							+ "MEM_TEL = ?,"
							+ "MEM_ADDR = ? "
							+ "where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, tel);
			pstmt.setString(3, adr);
			pstmt.setString(4, userId);

		int result = pstmt.executeUpdate();
		System.out.println("반환값" + result);
		if(result ==1){
			System.out.println("수정이 완료되었습니다");
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
		
	}
	//원하는컬럼 한가지만 수정
	public void read2(){		//수정 2
		System.out.println("수정목록");
		
		System.out.println("아이디 입력");
		String	memid = scan.next();
		
		int num;
		String updateField = null; //수정할 컬럼명이 저장될 변수
		String updateStr = null;  //수정할 컬럼의 한글명 저장될 변수
		
		
		do{
			System.out.println();
			System.out.println("수정할 항목을 선택하세요 ");
			System.out.println("1. 회원이름  2.전화번호 3.회원주소");
			System.out.println("-----------------------------");
			System.out.println("수정항목 입력>>");
			num = scan.nextInt();
			
			switch(num){
			case 1 :
				updateField ="mem_name";
				updateStr ="회원이름";
				break;
				
			case 2 :
				updateField ="mem_tel";
				updateStr ="전화번호";
				break;
				
			case 3 :
				updateField ="mem_addr";
				updateStr ="회원주소";
				break;
				
			default :
				
				System.out.println("수정 항목을 잘못 입력했습니다.");
				System.out.println("다시 선택하세요.");
			}
		}while(num<1 || num>3);
		
		scan.nextLine(); //입력버퍼 비우기 
		System.out.println();
		System.out.println("새로운" + updateStr + " >>");
		String updateData = scan.nextLine();
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "update mymember set "
						+ updateField +" = ? "
						+ "where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, memid);
			
			int result = pstmt.executeUpdate();
			
			System.out.println("반환값" + result);
			if(result ==1){
				System.out.println("수정이 완료되었습니다");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
	
}
	
	
	public void displayMember(){ //전체출력
		
		System.out.println("자료 출력하기");
		System.out.println("-----------------------------------");
		System.out.println(" ID      이름            전화번호       주소");
		System.out.println("-----------------------------------");
		try {
			String sql = "SELECT * FROM MYMEMBER";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()){
				String memid = rs.getString("mem_id");
				String username = rs.getString("mem_name");
				String Tel = rs.getString("mem_tel");
				String addr = rs.getString("mem_addr");
				System.out.println(memid + "\t" + username + "\t" + Tel + "\t" + addr);
			}
			System.out.println("-----------------------------");
			System.out.println("출력끝");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
		
	}
	
	
}
