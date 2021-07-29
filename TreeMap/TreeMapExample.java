package MAP중요_1.TreeMap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		// hash가 더 빠르다
		// 검색은 Tree 정렬도 좋다
		// Map : 엔트리Entry(쌍<키,값>)아!!
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		tmap.put(new Integer(89), "이순신");// 89(int)타입 -> 자동 boxing되어 89(Integer)
		// 야들은 객체가 아니여서 가능하다

		tmap.put(new Integer(100), new String("String타입"));
		tmap.put(95, "홍길동");
		tmap.put(78, "김유신");
		tmap.put(80, "전용준");
		tmap.put(83, "김건우");
		tmap.put(98, "유관순");

		tmap.put(78, "강감찬");

		System.out.println("저장된 Entry객체 수: " + tmap.size());
		System.out.println(tmap);

		System.out.println("------------검색 할떄 는것----------------------------------------------");
		System.out.println(
				"가장 낮은 객체 리턴(=가장 낮은 점수):" + tmap.firstEntry().getKey() + "," + tmap.firstEntry().getValue() + "\n"); // Entry안에
																														// 2개
																														// 있다

		Entry<Integer, String> entry = tmap.lastEntry();
		System.out.println("가장 높은 객체 리턴(=가장 높은 점수):" + entry.getKey() + "," + entry.getValue());
		System.out.println("가장 높은 객체 리턴(=가장 높은점수):" + tmap.lastEntry() + "\n");

		entry = tmap.lowerEntry(new Integer(95));
		System.out.println("주오진 객체 95보다 바로 아래 객체를 리턴(=95점 바로 아래 점수)" + entry.getKey() + "," + entry.getValue());
		System.out.println("주어진 객체 95보다 바로 아래 객체를 리턴:" + tmap.lowerEntry(95) + "\n");

		System.out.println("주어진 객체 95보다 바로 위 객체를 리턴" + tmap.higherEntry(95) + "\n");

		entry = tmap.floorEntry(96);
		System.out.println(
				"주어진 객체 96과 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 아래 객체를 리턴" + entry.getKey() + "," + entry.getValue());
		System.out.println("주어진 객체 96과 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 아래 객체를 리턴" + tmap.floorEntry(96) + "\n");// 이게 더
																												// 편한거
																												// 아닌가???

		System.out.println("주어진 객체 94과 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 위 객체를 리턴 " + tmap.ceilingEntry(94));
		System.out.println("주어진 객체 94과 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 위 객체를 리턴 하고 점수만 보여줘라" + tmap.ceilingKey(94));

		System.out.println("---------------범위 검색과 관련된 메서드-------------");

		/*
		 * SortedMap<K,V> subMap(E fromK , toElement) 시작 ~ 끝 이전까지의 부분집합 반환
		 * 
		 * NavbleMap<K,V> 시작 (포함여부 선택가능) ~ 곧 (포함여부 선택 가능)
		 */
		SortedMap<Integer, String> tmapSubl = tmap.subMap(78, 95);
		System.out.println("78<= 찾는 점수 < 95 : ");
		Set<Entry<Integer, String>> tmapSet = tmapSubl.entrySet();

		Iterator<Entry<Integer, String>> tmapSetItr = tmapSet.iterator(); // 반복자 만들었다
		while (tmapSetItr.hasNext()) {
			// Entry<Integer, String> entry = tmapSetItr.next();
			entry = tmapSetItr.next();// <78,김유신>을 가지고온다
			System.out.println(entry.getKey() + "," + entry.getValue());
		}

		System.out.println();// 줄바꿈

		// 78 <= 찾는 점수 <= 95
		// NavigableSet<Integer> streesub2 = tmap.subMap(78, true, 95, true);
		NavigableMap<Integer, String> tmapSub2 = tmap.subMap(78, true, 95, true);
		System.out.println("78 <= 찾는 점수 <= 95 :");
		Set<Entry<Integer, String>> tmapSet2 = tmapSub2.entrySet();
		Iterator<Entry<Integer, String>> tmapSetItr2 = tmapSet2.iterator();// 반복자 사용해서 막대기로쓰겠다
		// subMap
		while (tmapSetItr2.hasNext()) {
			entry = tmapSetItr2.next();
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
		System.out.println();

		System.out.println("------Set에만 반복자 있지 Map에는 없다 ---------------------");
		System.out.println(" ** 오름차순으로 정렬된 NavigableSet을 리턴 **");
		// K,V 한 이유가 Set만들라고
		// 지금하는건 키만 하고싶다
		NavigableSet<Integer> dKey = tmap.descendingKeySet();// KeySet사용, 내림차순
		// Iterator<Integer> itr = dKey.iterator(); //Set이닌깐 반복자 만듬 ,내림차순됌
		Iterator<Integer> itr = dKey.descendingIterator();// 내림차순을 내림차순했으니 오름차순됌ㅋㅋㅋㅋㅋㅋ
		while (itr.hasNext()) {
			Integer key = itr.next();
			// System.out.println(tmap.get(key));
			String value = tmap.get(key);
			System.out.println(key + "," + value);
		}

		System.out.println();// 구분위한 빈줄

		System.out.println("** 내림차순으로 정렬된 NavigableMap을 리턴 **");
		NavigableMap<Integer, String> dMap = tmap.descendingMap();// 내림차순으로 정렬된 NavigableMap<k,v>이다!!!
		Set<Entry<Integer, String>> eSet = dMap.entrySet();// entrySet = Set만들어줄라고
		// KeySet과 entrySet이 있다

		// eSet.iterator();반복자이다

		for (Entry<Integer, String> entey2 : eSet) {
			System.out.println(entey2.getKey() + "," + entey2.getValue());
		}

		System.out.println();// 구분을위한 빈줄

		System.out.println("** 다시 한번더 내림차순으로 정렬된 NavigableMap을 리턴 **");// 오름차순이 됬네?
		NavigableMap<Integer, String> aMap = dMap.descendingMap();// 내림차순으로 정렬된 NavigableMap<k,v>이다!!!
		Set<Entry<Integer, String>> eSet2 = dMap.entrySet();// entrySet = Set만들어줄라고
		// KeySet과 entrySet이 있다

		// eSet.iterator();반복자이다

		for (Entry<Integer, String> entey3 : eSet2) {
			System.out.println(entey3.getKey() + "," + entey3.getValue());
		}

		System.out.println();// 구분을위한 빈줄
		System.out.println("제일 낮은 객체부터 꺼내오고 제거한 순서 :");
		while (!tmap.isEmpty()) {// 비어있지 않으면 계속 반복
//			System.out.println(tmap.pollFirstEntry()); //낮은거 부터 
			System.out.println(tmap.pollFirstEntry() + ""); // 낮은거 부터
			// System.out.println(tmap.pollLastEntry());//높은거 부터
		}
		System.out.println("------------------범위 검색---------------------------");
		TreeMap<String, Integer> tmap2 = new TreeMap<String, Integer>();

		tmap2.put(new String("가나"), new Integer(25));
		tmap2.put("banana", 1);
		tmap2.put("cherry", 3);
		tmap2.put("apple", 5);
		tmap2.put("black", 10);
		tmap2.put("school", 8);
		tmap2.put("door", 6);
		tmap2.put("elememt", 4);

		System.out.println(" ** B~E 사이의 단어 검색 **");
		// 시작 객체 "B" <= 찾는 객체 < 끝객체"E" (★★주의 단, 끝객체 제외)
//		tmap2.subMap("b", true, "e", true);
		NavigableMap<String, Integer> map = tmap2.subMap("b", true, "e", true);
		// MAP은 SEt을 만드는게 목적이다
//		map.entrySet(); //이걸로 set객체 만들겠다
		Set<Entry<String, Integer>> sMap = map.entrySet(); // 이걸로 set객체 만들겠다
		
		for(Entry<String, Integer> entry4 : sMap) {
			//System.out.println(entry4);
			
			System.out.println(entry4.getKey()+","+entry4.getValue());
		}

	}
}
