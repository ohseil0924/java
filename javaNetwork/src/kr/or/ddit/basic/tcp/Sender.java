package kr.or.ddit.basic.tcp;
//이클래스는 소켓을 통해서 메세지를 보내는 역할을 담당하는 클래스이다.

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream dos;
	private Scanner scan;
	private String name; // 접속한 사람의 이름이 저장될 변수 
	

	//생성자
	public Sender(Socket socket){
		this.socket = socket;
		scan =  new Scanner(System.in);
		
		System.out.println("이름입력>>");
		name = scan.nextLine();
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
		}
	}
	@Override
	public void run() {
		while(dos!=null){
			try {
				//키보드로 입력한 메세지를 상대방에게 보낸다
				dos.writeUTF(name+":" + scan.nextLine());
			} catch (Exception e) {
			}
		}
		super.run();
	}
}













