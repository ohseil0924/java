package kt.or.ddit.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest18 {
	
	private int balance; //잔액이 저장될 변수
	
	// 동기화 처리를 해주는 Lock객체 생성하기 
	private Lock lock = new ReentrantLock();
	
	
	
	public int getBalance(){
		return balance;
	}
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	//입금하는 메서드
	public void deposit(int money){
		// lock()메서드를 try ~ catch블럭에서 사용하게 되면 
		// unlock()메서드는 finally 영역에서 호출하도록 한다.
		try {
			lock.lock();
			balance += money;
			// lock.unlock(); //이 부분에 사용하는 것은 위험하다.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	//출금하는 메서드 (출금 성공 : true, 출금실패 : false 반환)
	public boolean withdraw(int money){
		//Lock 객체는 lock()메서드로 락을 설정하고
		// 반드시 unlock() 메서드로 락을 해제해 주어야 한다.
		
		lock.lock(); //락설정 시작 .
		boolean chk = false;
		
		if(balance >= money){
			for(int i=1; i<=10000000; i++){} //시간 지연용
			
			balance -= money;
			System.out.println("메서드 안에서 balance = " + balance);
			chk = true; 
		}else{
			chk = false;
		}
		lock.unlock(); //락을해제한다.
		return chk;
	}
	
	
	
	public static void main(String[] args) {
		 final ThreadTest18 acount = new ThreadTest18();
	      acount.setBalance(10000);  //잔액을 10000원으로 설정 
	      
	      //익명 구현체로 쓰레드 구현 
	      Runnable test = new Runnable() {
	    	  //출금하기
	         public void run() {
	            boolean result = acount.withdraw(7000);
	            System.out.println("쓰레드 안에서 result =  "+
	                        result + ",balance = " + acount.getBalance());
	            
	         }
	      };
	      
	      //---------------------------------------------------------------------
	      Thread th1 = new Thread(test);
	      Thread th2 = new Thread(test);
	      
	      th1.start();
	      th2.start();
			}
		
		
	}


