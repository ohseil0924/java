package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제1) 사용자로부터 Lprod_id값을 입력 받아 입력한 값보다 
// 		lprod_id가 큰 자료들을 출력하시오.
		

public class JdbcTest02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print
		("lprod_id값 입력 :");
		int num = scan.nextInt();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 연결 ==> Connection 객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"OSI09",
					"jaba");
			
			// 3-1. SQL문 작성
			
			String sql = "select * from lprod where lprod_id > " + num ;//+ 
						 
			
			
			// 3-2. Statement 객체 생성 ==> Connection객체 이용
			//		==> SQL문을 실행하고 결과를 얻어오는 객체 생성
			stmt = conn.createStatement();
			
			// 3-3. SQL문을 DB서버로 보내서 결과를 얻어온다.
			//		(지금은 실행할 SQL문이 seliect문이기 때문에
			//		결과가 ResultSet객체에 저장되어 반환된다.
			
			rs = stmt.executeQuery(sql);
			
			// 4. 결과 처리하기 ==> 한 레코드씩 화면에 출력하기 
			System.out.println("실행한 SQL문 :" + sql);
			System.out.println();
			
			
			System.out.println(" == 결과 출력 ==");
			while(rs.next()){
				System.out.println("lprod_id :" + rs.getInt("lprod_id"));
				System.out.println("lprod_gu :" + rs.getString("lprod_gu"));
				System.out.println("lprod_nm :" + rs.getString("lprod_nm"));
				System.out.println("=======================================");
			}
			System.out.println("출력 끝...");
				
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 5. 자원 반납하기
			if(rs!=null) try{ rs.close();}catch(SQLException e){}
			if(rs!=null) try{ stmt.close();}catch(SQLException e){}
			if(rs!=null) try{ conn.close();}catch(SQLException e){}
		}
		
		
		
		
	}

}