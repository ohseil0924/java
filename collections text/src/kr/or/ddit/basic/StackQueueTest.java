package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackQueueTest {
	/*
	 
	 - Stack => 나중에들어간놈이 먼저나온다
	 			후입선출(LIFO)의 자료 구조 
	 
	 
	 - Queue => 입구와 출구가 같아서 먼저들어간놈이 먼저나온다
				선입선출(FIFO)의 자료 구조
				AA
	 - Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
	 
	*/
	/*
	- Stack의 명령
	 1. 자료 입력: push(입력값)
	 2. 자료 출력: 
	 	- pop() ==> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
	 	- peek() ==> 삭제 없이 자료를 꺼내온다. (주로 자료 확인용으로 사용) 
	*/
	public static void main(String[] args) {
	
		LinkedList<String> stack = new LinkedList<>();
		
		stack.push("홍길동");

		stack.push("일지매");

		stack.push("강감참");

		stack.push("반학오");

		

		
		System.out.println("현재 stack값 : " + stack);

		

		String data = stack.pop();

		System.out.println("꺼내온 값 : " + data);

		System.out.println("꺼내온 값 : " + stack.pop());

		System.out.println("남은 값 : " + stack);

		

		stack.push("성춘향");

		System.out.println("추가 후 stack값 : " + stack);

		

		System.out.println("꺼내온 값 : " + stack.pop());

		System.out.println("남은 값 : " + stack);

		

		System.out.println();

		System.out.println("삭제없이 꺼내온 값 : " + stack.peek());

		System.out.println("남은 값 : " + stack);
		
		//뒤로가기 앞으로가기로 자주사용함
		System.out.println("-----------------------------------------------------------");

		System.out.println();
		//보내달라하자..
		/*
		 1. 자료 입력 : offer(입력값)
		 2. 자료 출력 : 
		  	-poll() ==> 자료를 꺼내온 후 Queue에서 꺼내온 자료를 삭제한다.
		  	-peek() ==> 삭제없이 자료를 꺼내온다. 
		*/
		
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("강감찬");
		queue.offer("변학도");

		System.out.println("현재 queue값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값: " + temp);
		System.out.println("꺼내온 값: " + queue.poll());
		System.out.println("현재 queue값 : " + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 queue값 : " + queue);
		System.out.println();
		
		System.out.println("꺼내온 값: " + queue.poll());
		System.out.println("현재 queue값 : " + queue);
		System.out.println();
		
		System.out.println("삭제 없이 꺼내온 값 : " + queue.peek());
		System.out.println("현재 queue값 :" + queue);
			
		//프린트같은거 쓸때
		
	}

}
