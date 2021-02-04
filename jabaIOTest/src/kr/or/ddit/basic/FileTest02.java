package kr.or.ddit.basic;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("d:/D_Other/test.txt");
		System.out.println(f1.getName() + "의 크기 : " + f1.length() + "byte");
		System.out.println("f1의 path :" + f1.getPath());
		System.out.println("f1의 절대 경로: " + f1.getAbsolutePath());
		System.out.println();
		File f2 = new File(".");
		// 이클립스에서 'java파일'의 실행 위치는 실행하는 java파일이 
		// 있는 '프로젝트명' 까지를 말한다. 
		System.out.println("f2의 path : " + f2.getPath());
		System.out.println("f2의 절대경로 : " + f2.getAbsolutePath());
		System.out.println();
		
		if(f1.isFile()){
			System.out.println(f2.getName() + "은 파일입니다. ");
		}else if(f2.isDirectory()){
			System.out.println(f2.getName() + "은 디렉토리 입니다.");
		}else{
			System.out.println(f2.getName() + "은 아직 모릅니다.");
	 }
		
		System.out.println();
		File f3 = new File("d:/D_Other/sample.txt");
		if(f3.isFile()){
			System.out.println(f3.getName() + "은 파일입니다. ");
		}else if(f2.isDirectory()){
			System.out.println(f3.getName() + "은 디렉토리 입니다.");
		}else{
			System.out.println(f3.getName() + "은 아직 모릅니다.");
	 }
		System.out.println();
		System.out.println("---------------------------------------");
		//자바프로그램 실행 위치 구하기
		// 방법1) File객체 이용하기
		File f4 = new File("");
		System.out.println("실행위치 :" + f4.getAbsolutePath());
		
		
		// 방법2) System.getProperty("user.dir")명령 이용하기
		String path = System.getProperty("user.dir");
		System.out.println("실행위치 : " + path);
		
		// 방법3) Path객체 이용하기 ==>상대 경로를 구한 후 절대 경로를 구한다. 
		Path path2 = Paths.get("");
		System.out.println("실행위치 :" + path2.toAbsolutePath().toString());
	}
}
