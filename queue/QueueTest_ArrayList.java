package queue;

import java.util.ArrayList;

/*
 * Queue = '선착순'
 * 			줄을 선 대기열처럼 먼저 추가된 데이터부터 꺼내서 사용하는 방식(FIFO)
 */
class MyQueue {
	private ArrayList<String> arrayQueue = new ArrayList<String>();

	void offer(String data) {// 메서드 만들고
		arrayQueue.add(data);

	}

	public String poll() {
		int len = arrayQueue.size();//0index넣고,1넣고,2넣고,3넣고 -> 0 1 2 -> 0 1 -> 0 순이다 

		if (len == 0) {
			System.out.println("큐가 비었습니다 ");
			return null;
		}
		return (arrayQueue.remove(0)); //0을 제거 하므로 앞으로 이동한다 0 1 이렇게 
	}

}

public class QueueTest_ArrayList {

	public static void main(String[] args) {
		MyQueue Queue = new MyQueue();
		
		Queue.offer("f"); //0
		Queue.offer("a"); //0
		Queue.offer("b"); //0
		Queue.offer("c"); //0
		Queue.offer("d"); //0
		
		System.out.println("순서대로 뽑는다");
		System.out.println(Queue.poll());
		System.out.println(Queue.poll());
		System.out.println(Queue.poll());
		System.out.println(Queue.poll());
	}
}
