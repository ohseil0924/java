package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


//문제 2 lprod_id값을 2개 입력받아 두 값 중 작은 값부터 큰 값 사이의 자료를 출력하시오
public class JdbcTest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("첫번째 lprod_id값 입력 :");
		int num1 = scan.nextInt();
		
		System.out.println("두번째 lprod_id값 입력 :");
		int num2 = scan.nextInt();
		
		int max,min;
//		if(num1>num2){
//			max = num1;
//			min = num2;
//		}else{
//			max = num2;
//			min = num1;
//		}
		
		//둘중 아무거나 ↑↓
		max = Math.max(num1, num2);
		min = Math.min(num1, num2);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; //select문이 사용될 때만 선언한다.
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 연결 ==> Connection 객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"OSI09", "jaba");
			
			// 3-1. SQL문 작성
			String sql = "select * from lprod where lprod_id >= " 
						+ min + " and lprod_id <=" +max;
						
						 
			
			
			// 3-2. Statement 객체 생성 ==> Connection객체 이용
			//		==> SQL문을 실행하고 결과를 얻어오는 객체 생성
			stmt = conn.createStatement();
			
			// 3-3. SQL문을 DB서버로 보내서 결과를 얻어온다.
			//		(지금은 실행할 SQL문이 seliect문이기 때문에
			//		결과가 ResultSet객체에 저장되어 반환된다.
			
			rs = stmt.executeQuery(sql);

			System.out.println("sql => select * from LPROD where lprod_id between + min + and + max ;");
			// 4. 결과 처리하기 ==> 한 레코드씩 화면에 출력하기 
			System.out.println(" == 검색 결과 ==");
			
			//		ResultSet객체에 저장된 데이터를 차례로 꺼내오려면
			//		반복문과 next()메서드를 이용한다.
			// rs.next() ==> ResultSet객체의 데이털르 가르키는
			// 		포인터를 다음번째의 레코드로 이동 시키고 그 곳에
			//		데이터가 있으면 true를 반환한다.
			
			while(rs.next()){
				// 포인터가 가르키는 곳의 데이터를 가져오는 방향
				// 1) rs.get 자료형 이름("컬럼명")
				// 2) rs.get 자료형 이름(컬럼번호) ==> 컬럼번호는 1번부터 시작
				// 3) rs.get 자료형 이름("컬럼의 Alias명")
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
				System.out.println("---------------------------------------------");
				
				
			}
				System.out.println("출력 끝....");
			
			
			
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
