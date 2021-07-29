package MAP중요_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Map 인터페이스
 * 1. 키와 값으로 구성된 Map.Entry 객체를 저장
 * 2. 키와 값은 모두 객체
 * 3. 키 : 중복X, 값: 중복O
 * 4. 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대체된다.
 */
public class HasMapExample {

	public static void main(String[] args) {// 책 439p 중여
		// HashMap<Integer, String> map = new HashMap<Integer, String>();
		// <키,값> Map컬랙션 생성
		Map<Integer, String> map = new HashMap<Integer, String>();

		// 객체 추가
		map.put(new Integer(6), "김진일"); // 6(int타입)
		map.put(3, "유신재"); // int -> 자동박싱되서 'new Integer객체로'안적어도된다
		map.put(7, "주종환");

		map.put(6, "노승현"); // 키를 똑같이하고 String을 다르게 하면 김진일을 삭제하고 노승현으로 들어간다

		// map.putAll(map1);
		System.out.println("총 객체수 : " + map.size());
		System.out.println(map);

		// 키로 값을 얻어옴
		System.out.println("6의 이름: " + map.get(6));
		System.out.println("----------------------------------------------");
		System.out.println("** 저장된 전체 객체를 대상으로 키와 값을 얻고 싶을 때 (4가지 방법) **");
		Set<Integer> kSet = map.keySet(); // key : 6, 3, 7이 있다

		System.out.println("방법-1 : keySet() -> 반복자 iterator() 이용!");
		Iterator<Integer> itr1 = kSet.iterator(); // 반복자. 키의반복자(=지팡이역할함)을 통해
		
		//Iterato = 반복자다 . 반복자는 꼭있어야한다 
		
		while (itr1.hasNext()) {// Iterator = while문이랑 세트이다
			// Integer key = itr1.next(); // 하나씩 키를 가져와
			int key = itr1.next();// int도 가능하다
			String value = map.get(key);// 오토박싱이여서 가능하다

			System.out.println(key + "의 이름은 " + value);
			System.out.println("key는 중복 불가 덮어씌기한다 ");
		}

		System.out.println();// 구분위한 빈줄
		System.out.println("방법-2 : keySet() -> 향상된 for문   이용!");
		for (Integer key : kSet) {
			System.out.println(key + "의 이름은" + map.get(key));
		}
		System.out.println();// 구분위한 빈줄

		System.out.println("6번의 삭제된 이름: " + map.remove(6));
		System.out.println("총 객체수 : " + map.size());

		System.out.println();// 구분위한 빈줄

		System.out.println("방법-3 : entrySet() -> 반복자 iterator() 이용!");
		Set<Entry<Integer, String>> eSet = map.entrySet(); // <3,유신재>, <7,주종환>이 있다
		
		Iterator<Entry<Integer, String>> eitr = eSet.iterator();// <키,값>의 반복자를 통해
		while (eitr.hasNext()) {
			Entry<Integer, String> e = eitr.next();// <3,유신재>엔트리 객체임 
//			e.getKey();//키 3의값을 돌려줌
//			e.getValue();//값 유진새를 돌려줌 
			System.out.println(e.getKey()+"번의 이름은"+e.getValue());
		}
		System.out.println();// 구분위한 빈줄
		System.out.println("방법-4 : entrySet() -> 향상된 for문   이용!");
		for(Map.Entry<Integer, String> entry : eSet) {
			System.out.println(entry.getKey()+"번의 이름은"+entry.getValue());
		}
		
		map.clear();//객체 전체 삭제임!!
		System.out.println("총 Entry 객체 수: "+ map.size());
		
		if(map.isEmpty())
			System.out.println("모두 삭제됨");
		else {
			System.out.println("삭제되지 않음");
		}
//
//		HashMap<키=int타입, 값=String> type = new HashMap<키, 값>();
//		중복되면 안된다 그래서 hashcode()ghcnfgotj 
//		
//		해쉬코드 6을 비교하고 eq쓰고 
//		
//		키는 중복 안되고 값은 덮어쓴다
//		
//		HashMap은 언제 많이 쓰냐 String "김진일" int 85점 에서 재시험 쳐서 
//							String "김진일" int 100점이였으면 수정할떄!! 
		
		
	}
}
