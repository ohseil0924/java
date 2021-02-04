package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {

	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		try {
			
//			System.in.read();
//			new Scanner(System.in);
			
			// 바이트 기반의 입력용 스트림을 문자기반의 입력용 스트림으로
			// 변환해주는 보조 스트림
			InputStreamReader isr =
					new InputStreamReader(System.in);
			
			// 문자기반의 파일 출력용 스트림 객체 생성 
			FileWriter fw = new FileWriter("d:/d_other/testchar.txt");
			
			System.out.println("아무 내용이나 입력하세요....");
			System.out.println("(입력의 끝은'ctrl+z입니다)");
			
			int c;
			//콘솔에서 입력할 때 입력의 끝은 'Ctrl + Z' 키를 누르면 된다.
			while( (c=isr.read())!=-1 ){
				fw.write(c);
			}
			isr.close();
			fw.close();
			
		} catch (IOException e) {

		}
		
		
	}

}
