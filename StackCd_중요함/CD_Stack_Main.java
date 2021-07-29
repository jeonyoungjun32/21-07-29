package StackCd_중요함;

import java.util.Stack;

public class CD_Stack_Main {

	public static void main(String[] args) {
		Stack<CD> cdBox = new Stack<CD>();
		

		cdBox.push(new CD("BTS "));
		cdBox.push(new CD("블랙핑크"));
		cdBox.push(new CD("레드벨벳"));

		CD cd = cdBox.peek(); // 스텍의 맨 위 객체를 가져오고 객체를 스택에서 제거 하지 않는다
		System.out.println(cd);
		int count = 0;
		
		while (!cdBox.isEmpty()) {
			// CD cd = cdBox.peek();// 스택의 맨 위 객체를 가져오고 객체를 스택에서 제거하지 않는다.
			cd = cdBox.pop();// 스택의 맨 위 객체를 가져오고 객체를 스택에서 제거하지 않는다.
			System.out.println(++count + "-CD: " + cd.getCdTitle());
		}

		// 에러 뜬 이유 시발!!!!~!!!! 빈 상태에서 index로 접근하여 값을 얻어오려고 하면 ㅡㅡ
		if (!cdBox.isEmpty()) {
			cd = cdBox.get(0); // 에러뜨고 예외객체생성 후 -> 프로그램 강제 종료
			System.out.println(cd);
		}
		
		System.out.println(cdBox.size());
		

	}
}
