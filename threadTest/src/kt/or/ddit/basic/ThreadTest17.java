package kt.or.ddit.basic;

//은행 입출금을 쓰레드로 처리하는 예제
//(synchronized를 이용한 동기화 처리 예제)

public class ThreadTest17 {
	private int balance; //잔액이 저장될 변수
	
	public int getBalance(){
		return balance;
	}
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	//입금하는 메서드
	public void deposit(int money){
		balance += money;
	}
	
	//출금하는 메서드 (출금 성공 : true, 출금실패 : false 반환)
	public synchronized boolean withdraw(int money){
		if(balance >= money){
			for(int i=1; i<=10000000; i++){} //시간 지연용
			
			balance -= money;
			System.out.println("메서드 안에서 balance = " + balance);
			return true; 
		}else{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		//공통 객체 생성
	      //익명 구현체에서 사용할 지역변수는 final이여야 한다.
	      final ThreadTest17 acount = new ThreadTest17();
	      acount.setBalance(10000);  //잔액을 10000원으로 설정 
	      
	      //익명 구현체로 쓰레드 구현 
	      Runnable test = new Runnable() {
	         public void run() {
	            boolean result = acount.withdraw(6000);
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
 
