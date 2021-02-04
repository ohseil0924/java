package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test1 {

	/*
	 1.드라이브 로딩 => 라이브 러리를 사용할수 있게 메모리에 읽어 들이는 작업 
	 	Class.forName("oracle.jdbc.driver.OracleDriver");
	 
	 2.DB에 접속하기 ==> 접속이 완료되면 Connetion 객체가 반환된다.
	 DriverManager.getConnection()메서드를 이용한다.
	 
	 3.질의=> sql문을 작성해서 db서버로 보내고 그 결과를 얻어온다
	 	Statement 객체나 PreparedStatement객체를 이용하여 작업한다.
	 	
	 4. 결과처리 => 질의 결과를 받아서 원하는 작업을 수행한다.
	 1) sql문이 select 문일 경우에는 select한 결과가 resultset객체에 저장되어 반환
	 2) sql문이 select 문이 아닐경우
	 	-insert,update,delete,create등)에는 정수값 반환된다.
	 	(이정수값은 보통 해당 명령의 실행에 성공한 레코드 수가 된다.)
	 5. 사용한 자원 반납하기 --> close()메서드 이용
	
	*/
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; //select문이 사용될 때만 선언한다
		
		try {
			//1. 드라이버 로딩 
			//라이브러리를 사용할수 있게 메모리를 읽어들이는 작업
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB 연결 ==> Connection 객체 생성
			//DriverManager.getConnection()메서드를 이용한다
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"OSI09",
					"jaba");
			
			//3-1 SQL문 작성
			String sql = "select *from lprod";
			
			//3-2 statement 객체 생성==> Connection객체 이용
			// 		==>SQL문을 실행하고 결과를 얻어오는 객체 생성
			stmt = conn.createStatement();
			
			//3-3 sql문을 db서버로 보내서 결과를 얻어온다.
			//		(지금은 실행항 sql문이 seliect문이기 때문에
			//		결과가 ResultSet객체에 저장되어 반환된다.
			
			rs = stmt.executeQuery(sql);
			
			//4. 결과 처리하기 -> 한 레코드씩 화면에 출력하기
			
			System.out.println("=쿼리문 실행결과=");
			//ResultSet객체에 저장된 데이터를 차례로 꺼내오면
			//반복문과 next()메서드를 이용한다.
			//rs.next()==>ResultSet객체의 데이터를 가르키는
			//포인터를 다음번째의 레코드로 이동시키고 그곳에
			//데이터가 있으면 true를 반환한다
			
			while(rs.next()){
				//포인터가 가르키는 곳의 데이터를 가져오는 방향
				// 1)rs.get 자료형 이름("컬럼명")
				// 2)rs.get 자료형 이름(컬럼번호)==> 컬럼번호는 1번부터 시작
				// 3)rs.get 자료형 이름("컬럼의 Alias명")
			System.out.println("Lprod_id :" + rs.getInt("lprod_id"));
			System.out.println("Lprod_gu :" + rs.getString(2));
			System.out.println("Lprod_nm :" + rs.getString("LPROD_NM"));
			System.out.println("------------------------------------------");
			
			}
			System.out.println("출력 끝....");
			
			
		} catch (SQLException e) {
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
