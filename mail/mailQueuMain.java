package queue.mail;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mailQueuMain {

	public static void main(String[] args) {
		/*
		 * public interface Queue<E> extends Collection<E>
		 * 
		 * // Queue = 인터페이스임
		 * 
		 * // 인터페이스는 추상메서드가 되어야하낟
		 * 
		 * // 지금 링크, 메일,전부를 인터페이스로 만들수 있다
		 * 
		 */

		// 부모 인터페이스
		Queue<Mail> mail = new LinkedList<Mail>();

		// 메일 큐에 순서대로 저장되게 해라
		mail.offer(new Mail("정성훈", "안부인사"));
		mail.offer(new Mail("엄민정", "여행계획"));
		mail.offer(new Mail("이정은", "골프계모임"));
		mail.size();

		System.out.println("총 객체수 : " + mail.size() + "개입니다.");
		// System.out.println(mail);

		System.out.println(mail.peek());// 객체 하나를 꺼내서 큐에서 제거하지 않는다.

		System.out.println();// 구분을 위한 빈줄

		while (!mail.isEmpty()) { // ! 개 중ㅇ하네 시발
			Mail echemai = mail.poll(); // 객체 하나를 꺼내서 큐에서 제거한다.

			switch (echemai.toSome) { // echemai.mailTitle.substring(0, 1)
			case "정성훈":
				System.out.println(echemai);
				break;
			case "엄민정":
				System.out.println(echemai);
				break;
			case "이정은":
				System.out.println(echemai);
				break;

			}
			System.out.println(mail.size());
		}

	}
}
