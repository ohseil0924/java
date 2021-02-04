package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIoTest02 {

	public static void main(String[] args) {

	//문자 기반의 Buffer 스트림 사용하기
		try {
			
			
			FileReader fr = 
					new FileReader("./src/kr/or/ddit/basic/FileTest01.java");
			
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			
			for(int i=1; (temp=br.readLine())!=null; i++){
				System.out.printf("%4d : %s\n", i, temp);
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
