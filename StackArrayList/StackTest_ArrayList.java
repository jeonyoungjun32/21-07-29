package StackArrayList;

import java.util.ArrayList;

/*
 *  스택 : 맨 나중에 추가된 데이터를 먼저 꺼내는 (LIFO) 방식
 *  
 */
class MyStack {
	// 멤버변수 = 필드
	ArrayList<String> arrayStack = new ArrayList<String>();

	// 생성자 없으닌깐 기본생성자임

	// 메서드
	void puch(String data) {
		arrayStack.add(data);

	}

	String pop() {
		// 나온다
		int len = arrayStack.size(); // 0 1 2 3(마지막 index) size()(len) == 4 == (마지막 index +1)
		if (len == 0) {
			System.out.println("스택이 비었습니다");
			return null;
		}
		return (arrayStack.remove(len -1));
	}

}

public class StackTest_ArrayList {

	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.puch("a"); // 0index
		stack.puch("b"); // 1index
		stack.puch("c"); // 2index
		stack.puch("d"); // 3index

		System.out.println("index 3을 출력한다 : " + stack.pop());
		System.out.println("index 2을 출력한다 : " + stack.pop());
		System.out.println("index 1을 출력한다 : " + stack.pop());
		System.out.println("index 0을 출력한다 : " + stack.pop());

	}
}
