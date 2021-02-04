package kt.or.ddit.basic;

//쓰레드의 상태값을 출력하는 예제

public class ThreadTest10 {

	public static void main(String[] args) {
		
		StatePrintThread th =
					new StatePrintThread(new TargetThread());
		th.start();
		
		
	}

}

// 쓰레드의 상태의 검사 대상이 되는 쓰레드 
class TargetThread extends Thread{
	@Override
	public void run() {
		for(long i=1L; i<=20_000_000_000L; i++){}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		}
		for(long i =1L; i<=20_000_000_000L; i++){}
	}
}

//검사 대상 쓰레드의 상태값을 출력하는 쓰레드
class StatePrintThread extends Thread{
	// 검사 대상 쓰레드가 저장 될 변수 선언
	private TargetThread target;
	
	public StatePrintThread(TargetThread target){
		this.target = target;
	
}


	@Override
	public void run() {
		while(true){
		//쓰레드 상태값 구하기 
		Thread.State state = target.getState();
		System.out.println("TargetThread의 상태값 :" + state);
		
		// target.stop(); // 사용을 금지하는 되도록이면 쓰지말라 
		
		// 검사 대상 쓰레드가 NEW 상태이면...
		if(state ==Thread.State.NEW){
			target.start(); // 검사 대상 쓰레드를 작동 시킨다.
		}
		// 검사 대상 쓰레드가 종료상태이면... 
		if(state==Thread.State.TERMINATED){
			break;
		}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	  }
	}

