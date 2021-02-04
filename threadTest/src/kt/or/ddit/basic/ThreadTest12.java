package kt.or.ddit.basic;

import java.util.Arrays;

/*
	문제) 10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
	
	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데,
	이 클래스는 말 이름 (String), 등수(int), 현재위치값(int)을
	맴버변수로 갖는다. 그리고 , 이 클래스에는 등수를 오름차순으로 
	처리할 수 있는 내부 정렬 기준이 있다.(Comparable 인터페이스 구현)
	경기 구간은 1~50 구간으로 되어 있다.
	
	경기가 진행되는 중간 중간에 각각의 말들의 위치를 아래와 같이 나타내시오.
	예시)
	01번말 : --->---------------------- (3구간)
	02번말 : ----->-------------------- 
	03번말 : -->----------------------- 	
	04번말 : ------->------------------ 
	...
	10번말 : --->---------------------- 
	
	경기가 끝나면 등수 순으로 출력한다.
	
*/
public class ThreadTest12 {

	public static void main(String[] args) {
		Horse[] horses = new Horse[]{
				new Horse("01번말"),
				new Horse("02번말"),
				new Horse("03번말"),
				new Horse("04번말"),
				new Horse("05번말"),
				new Horse("06번말"),
				new Horse("07번말"), 
				new Horse("08번말"),
				new Horse("09번말"),
				new Horse("10번말")
		};
		Gamegs gs = new Gamegs(horses);
		
		for(Horse h : horses){
				h.start();
				
		}
		gs.start();
		
		
		for(Horse h : horses){
			try {
				h.join();
			} catch (InterruptedException e) {
			}
		}
	 try {
		    gs.join();
	} catch (InterruptedException e) {
	}
	 
	 System.out.println();
	 System.out.println("경기 끝....");
	 System.out.println();
	 
	 
	 //경기 종료 후 등수순으로 정렬하기
	 Arrays.sort(horses);
	 
	 System.out.println("경기 결과");
	 for(Horse h : horses){
		 System.out.println(h);
	}
}
}
class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;
	
	private String horseName;   // 말이름
	private int rank;  			// 등수
	private int location; 		// 현재위치
	
//생성자
	public Horse(String horseName) {
			this.horseName = horseName;
	}

	public static int getCurrentRank() {
		return currentRank;
	}

	public static void setCurrentRank(int currentRank) {
		Horse.currentRank = currentRank;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "경주마" + horseName + "는" + rank + "등입니다.";
	}
	
	@Override public int compareTo(Horse h) {
		return Integer.compare(rank, h.getRank());
	}

	@Override
	public void run() {
			for(int i = 1; i<=50; i++){
				location = i;
				try {
					Thread.sleep((int)(Math.random()*400));
				} catch (InterruptedException e) {
				}
			}
			rank = ++Horse.currentRank;
	}
	
}


//경기 중의 현재 상황을 출력하는 쓰레드

class Gamegs extends Thread{
	private Horse[] horses;
	
	//생성자
	public Gamegs(Horse[] horses) {
		this.horses =horses;
		
	}
	@Override
	public void run() {
		while(true){
			if(Horse.currentRank == horses.length){ //경기가종료되면
				break;
			}
			
			for(int i=1; i<10; i++)
			System.out.println();
			
			for(int i =1; i<=10; i++){
				
				System.out.println();
			}
			
			for(int i=0; i<horses.length; i++){
				System.out.print(horses[i].getHorseName() + " : ");
				for(int j=1; j<=50; j++){
					if(horses[i].getLocation()==j){ // 현재위치 표시
						System.out.print(">");
			}else{
					System.out.print("-");
			}
			
		}
		System.out.println();
	}
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
	}
}
}
}