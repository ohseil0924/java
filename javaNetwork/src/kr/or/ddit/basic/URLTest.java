package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		//URL 클래스 --> 인터넷에 존재하는 서버들의 자원에 접근할 수있는 주소를 다루는 클래스
		
		//http://ddit.or.kr:80/index.html?ttt=123
		
		URL url = new URL("http", "ddit.or.kr", 80, "index.http?ttt=123");
		
		
		System.out.println("Protocl" + url.getProtocol());
		System.out.println("Host" + url.getHost());
		System.out.println("port" + url.getPort());
		System.out.println("File" + url.getFile());
		System.out.println("Path" + url.getPath());
		System.out.println("Query" + url.getQuery());
		System.out.println();
	}

}
