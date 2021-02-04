package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

public class testtest1 {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Scanner scan = new Scanner(System.in);

	public testtest1() {
		conn = DBUtil2.getConnection();
	}
	
	public static void main(String[] args) {
		new testtest1().start();
	
	}
	public void start(){
		
		System.out.println(" 작업선택");
		System.out.println("1.자료 추가");
		System.out.println("2.자료 삭제");
		System.out.println("3.자료 수정");
		System.out.println("4.전체 자료 출력");
		System.out.println("5. 자료수정 2");
		System.out.println("0. 작업끝");
		int input = scan.nextInt();
		
		switch(input){
		case 1: //입력
			add();
			break;
		case 2: //삭제
			remove(); 
			break;
		case 3: //수정
			readd();
			break;
		case 4: //전체출력
			all();
			break;
		case 5: //자료수정2
			readd2();
			break;
		case 0: //끝
			System.out.println("종료");
			System.exit(0);
			break;
			
		}
		
		
	}
		
	private void readd2(){ //수정2
		try {
		System.out.println("두번째 수정");
		
		System.out.println(" 수정할 아이디 입력 ");
		String memId = scan.nextLine();
		
		int num;
		String updateField = null;
		String updateStr = null;
		
		do{
			System.out.println();
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1.회원 이름 2. 전화번호 3. 회원주소");
			System.out.println("--------------------------------");
			System.out.println("수정 항목 입력>>");
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
				System.out.println(" 수정항목을 잘못 입력했습니다");
				System.out.println(" 다시선택하세요 ");
			}
		}while(num<1 || num>3);
		
		
		scan.nextLine(); //입력버퍼 비우기
		System.out.println();
		System.out.println("새로운" + updateStr + ">>");
		String updateData = scan.nextLine();
		
			conn = DBUtil2.getConnection();
			
			String sql = "update mymember set "
							+ updateField +" = ? "
							+ "where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, memId);
			
			int result = pstmt.executeUpdate();
			
			if(result ==1){
				System.out.println(" 수정완료");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
			
	
		
	}

	private void all() { //전체줄력		
		
		System.out.println("자료 출력하기");
		System.out.println("------------------------------------------");
		System.out.println(" 아이디              이름             전화번호            주소 ");
		System.out.println("------------------------------------------");
		
		try{
			String sql = "SELECT * FROM MYMEMBER";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "\t" + memName + "\t"
								+ memTel +"\t"+ memAddr);
			}
			System.out.println("------------------------------------------");
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
		
		

	private void readd() { //수정
		try {
		System.out.println("수정게시판이다");
		System.out.println("수정할 아이디 입력");
		String memId = scan.next();
		System.out.println("수정할 이름을 입력하시오");
		String memName = scan.next();
		System.out.println("수정할 번호");
		String memTel = scan.next();
		System.out.println("수정할 주소");
		String memAddr = scan.next();
		
		String sql = "UPDATE MYMEMBER SET "
						+ "MEM_NAME = ?,"
						+ "MEM_TEL = ?,"
						+ "MEM_ADDR = ? "
						+ "where mem_id = ?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);
			
			int result = pstmt.executeUpdate();
			if(result ==1){
				System.out.println("수정이 완료되었습니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
		
		
	}

	public void remove() { //삭제
		System.out.println("삭제 하실 아이디 ");
		String memId = scan.next();
		
		String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int result = pstmt.executeUpdate();
			
			if(result==1){
				System.out.println("삭제 완료");
			}else{
				System.out.println("삭제 실패 ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();}catch(SQLException e){}
			if(pstmt!=null) try{ pstmt.close();}catch(SQLException e){}
			if(conn!=null) try{ conn.close();}catch(SQLException e){}
		}
		
		
		
	}

	public void add(){ //입력
		
	System.out.println("사용하실 Id를 입력해주세요");
	String memId = scan.next();
	System.out.println("사용하실 이름을 입력해주세요");
	String memName = scan.next();
	System.out.println("사용하실 전화번호 입력해주세요");
	String memTel = scan.next();
	System.out.println("살고있는 주소를 입력해주세요");	
	String memAdd = scan.next();
	
	String sql = "INSERT INTO MEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR)"
				+ "VALUES(?, ?, ?, ?)";
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, memId);
		pstmt.setString(2, memName);
		pstmt.setString(3, memTel);
		pstmt.setString(4, memAdd);
		
		int result = pstmt.executeUpdate();

		if(result ==1){
			System.out.println(memId + "입력완료");
		}else{
			System.out.println(memId + "입력실패");
		}
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







