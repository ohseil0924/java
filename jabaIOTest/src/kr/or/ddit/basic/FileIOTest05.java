package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest05 {

	public static void main(String[] args) {

		try {
//			FileReader fr = 
//					new FileReader("d:/d_other/test_ansi.txt");
			
//			FileReader fr = 
//					new FileReader("d:/d_other/text_ansi.txt");
			FileInputStream isr =
					new FileInputStream("d:/d_other/text_ansi.txt");
			
			//인코딩 방식을 지정해서 읽어오기
			//인코딩 방식 예시
			// - MS949 ==> 윈도우의 기본 한글 인코딩 방식(ANSI 방식과 같다.)
			// - UTF-8 ==> 유니코드 UTF-8 인코딩 방식
			// - US-ASCII ==> 영문전용 인코딩 방식
			
//			InputStreamReader isr = 
//					new InputStreamReader(fis, "US-Ascii");
			
			
			
			int c;
			while((c=isr.read())!=-1){
				System.out.print((char)c);
			}
			
			//보조 스트림을 닫으면 보조스트림에서 
			// 사용한 기반이 되는 스트림도 자동으로 닫힌다.
			isr.close();
			
			
		} catch (IOException e) {
			
		}
		
		
	}

}
