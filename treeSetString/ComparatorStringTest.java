package set.treeSetString;

import java.util.Comparator;
import java.util.TreeSet;

class ComparatorString implements Comparator<String> {

	@Override // 유니코드로 비교하여 ComparaTo() 재정의도이어ㅣㅅ음
	public int compare(String o1, String o2) {
		// TODO String으로 오름차,내림차순 만들어보자
		// return o1.compareTo(o2);
		return (o1.compareTo(o2) * -1);
	}

}

public class ComparatorStringTest {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		set.add("bbb");
		set.add("ccc");
		set.add("aaa");
		System.out.println(set);
		
		System.out.println("---------------------------------------");
		
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		set = new TreeSet<String>(new ComparatorString());
		set.add("bbb");
		set.add("ccc");
		set.add("aaa");
		System.out.println(set);
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//		
//		TreeSet<String> set1 = new TreeSet<String>();
//		set1.add("bbbb");
//		set1.add("ccc");
//		set1.add("aaa");
//		System.out.println(set1);
		//ComparatorString set12 = new TreeSet<String>();
		

		
	}
}
