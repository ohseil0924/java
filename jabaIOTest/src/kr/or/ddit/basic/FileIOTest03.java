package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		try {
			//문자 기반의 스트림을 이용하여 파일 내용 읽어와 출력하기
			FileInputStream fr = new FileInputStream("d:/d_other/text.txt");
			int c;
			while((c=fr.read())!=-1){
				System.out.println((char)c);
			}
			
			fr.close();
			
		} catch (IOException e) {
			
		}
		
	}

}
