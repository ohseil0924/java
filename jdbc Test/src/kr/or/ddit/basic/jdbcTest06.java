package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil2;

/*
  	LPROD테이블에 새로운 데이터를 추가하시오.
  	
  	조건) lprod_gu와 lprod_nm은 직접 입력 받아서 처리하고,
  		lprod_id는 현재의 lprod_id중 제일 큰 값보다 1 증가된 값으로 한다.
  		그리고, 입력받은 lprod_gu가 이미 등록되어 있으면
  		 다시 입력 받아서 처리한다. 
  
*/

public class jdbcTest06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			
			/*conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"OSI09", "jaba"
						
					);*/
			
			conn = DBUtil2.getConnection();
			String sql_1 = "SELECT MAX(lprod_id) as LPROD_ID FROM lprod";
	         //레코드가 하나 밖에 안나올때 
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql_1);
	         
	         System.out.println("== 쿼리문 처리 결과 ==");
	         int lprod_id = 0;
	         
	         if(rs.next()) lprod_id = rs.getInt("LPROD_ID");
	         
	         System.out.println("lprod_id == "+ lprod_id);
	         lprod_id =lprod_id +1;
	         

	         
	         
	         
	         int count = 0;
	         String LPROD_GU;
	         
	         do{
	            
	            System.out.println("LPROD_GU 입력하세요 ");
	            LPROD_GU = scan.next();
	            String sql_2 = "select count(*) cnt from lprod  where lprod_gu=?";
	            pstmt = conn.prepareStatement(sql_2);
	            pstmt.setString(1, LPROD_GU);
	            
	            rs = pstmt.executeQuery();
	            
	            if(rs.next()) count = rs.getInt("cnt");
	            if(count == 1 ){
	               System.out.println("입력한 상품 분류 코드" + LPROD_GU +"는 이미 등록된 코드입니다.");
	               System.out.println("LPROD_GU를 다시 입력하세요 ");
	                LPROD_GU = scan.nextLine();
	            
	            }
	            
	            }
	         while(count == 1);
	         System.out.println("상품분류명 lprod_nm 입력하세요 : ");
	         String lprod_nm = scan.next();
	      
	         //Statement객체를 이용하기
	         String sql_3 = "insert into lprod(LPROD_ID,LPROD_GU,LPROD_NM)  VALUES(?,?,?)";
	      
	         
	         System.out.println(sql_3);
	         pstmt =conn.prepareStatement(sql_3);
	         
	         
	         pstmt.setInt(1, lprod_id);
	         pstmt.setString(2, LPROD_GU);
	         pstmt.setString(3, lprod_nm);
	         
	         //==> 물음표 번호는 처음붙 순서대로 들어간다.
	         //형식 ) pstmt.set자료형이름 (물음표번호, 데이터);
	         //      ==> 물음표번호는 1번부터 시작한다.
	         
	         int rseult =pstmt.executeUpdate();
	         System.out.println("반환값"+rseult);
	         
	         
	         //sql문이 select문일 때의 실행은 executeUpdate사용하고
	         //sql문 insert,update, delete등과 같이 select문이 아닐경우에는 
	         //executeUpdate
	         
	      
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally{
	         //닫을때는 반대로한다
	            if ( pstmt != null )try{pstmt.close(); } catch(Exception e){}    
	            if ( stmt != null )try{stmt.close(); } catch(Exception e){}    
	            if ( conn != null )try{conn.close(); } catch(Exception e){}    
	         
	      }
	      
	   }
	   
	   
	}