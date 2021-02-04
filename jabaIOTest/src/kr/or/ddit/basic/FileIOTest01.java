package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {

		//FileInputStream을 이용한 파일내용 읽기
		   try {
		         //읽어올 파일을 인수값으로 지정해서 FileInputStream객체를 생성한다
		         // 방법1)
		         // new FileInputStream("읽어올 파일의 경로 및 파일명");
//		         FileInputStream fin =
//		               new FileInputStream("d:/d_other/Test.txt");
		         //방법2 )
		         // File f = new File("읽어올 파일의 경로 및 파일명)"
		         // new FileInputStream(파일객체변수);
		         File file = new File("D:/D_other/Test.txt");
		         FileInputStream fin = new FileInputStream(file);
		         
		         int c;
		         while( (c=fin.read()) != -1){
		            System.out.print((char)c);
		         }
		         
		         fin.close();//작업 완료 후 스트림 객체 담기
		         
		         
		         
		      } catch (IOException e) {
		         // TODO: handle exception
		      }
		      
		      
		   }
		   
		   
		}