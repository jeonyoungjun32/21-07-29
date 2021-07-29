/*
 *  컬렉션 프레임워크: 배열의 문제점을 해결하고 널리 알려진 자료구조를 바탕으로  
 *  			  '객체들을 효율적으로 추가, 삭제, 검색' 할수 있도록
 *  			    java.util패키지에 컬렉션과 관련된 인터페이스와 클래스들을 포함시켜 놓고
 *  			     이들을 총칭해서  '프레임워크'라고 부름
 *  				(반드시 객체만 처리)
 *  				 'Collection' 인터페이스
 *  						   |
 *  		    |----------------------------|
 *  	   list 인터페이스					Set 인터페이스					Map인터페이스
 *  		  	|							 |   						|
 *  	배열과 유사하여 index로 관리		    index로 관리X					key와 값의 쌍으로 저장
 *  	->순서를 유지하고 저장			    ->순서를 유지하지않고 저장			key:중복x, 값: 중복 허용
 *  	중복 저장 가능						중복 저장 안됨
 *  			|							 |							|
 *  		ArrayList					  HashSet					 HashMap
 *  		LinkedList					  treeSet						 TreeMap
 *  		Vector
 *  
 *  ---------------------------------------------------------------------------------------------------------------
 *  list 인터페이스를 구현한 클래스  
 *  <공통점> 
 *  		1. 배열과 유사하여 index로 관리 ->순서를 유지하고 저장
 *    		 => 'for문 사용가능'
 *  		2. 중복 저장 가능
 *  
 *  1. ArrayList  : 앞에서부터 차례대로 추가나 검색 할 때 효율적
 *  			        중간에 추가나 삭제가 빈번히 일어나는 곳에서는 비효율적
 *  			        싱글쓰레드
 *  
 *  2. Vector     : ArrayList와 특징이같다. 단, 멀티 쓰레드에 사용
 *  
 *  3. LinkedList : 앞에서 부터 검색할 떄 비 효율적
 *  				중간에 추가나 삭제가 빈번히 일어나는 곳에서는 효율적
 */
package list_ArraysList씀;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		/*
		 * 부모인터페이스=자식객체가 부모타입으로 자동형변환되어 대입
		 * 컴파일러 입장 : 모든 자식객체들을 부모타입인 List로 인식하여
		 * List에 선언된 추상메서드만 호출할 수 있다.
		 * 
		 * 그런데 자식 클래스들은 클래스의 특징에 맞게 추상메서드를 재정의하였으므로
		 * 재정의된 메서드가 호출됨
		 */
		//ArrayList<String> list=new ArrayList<String>();//E타입은 ArrayList객체를 생성할 때 타입이 결정됨
		LinkedList<String> list=new LinkedList<String>();
		//Vector<String> list=new Vector<String>();
		for(String str:list) {
			System.out.println(str);
		}
		
		System.out.println("-------------추가 후 갑을 얻기-------------");
		list.add("여러분~");//0
		list.add("힘내세요~");//1
		list.add("^^~");//2
		
		/*
		 * addFirst, addLast = LinkedList클레스 안에만 추가한 메서드들이다!!!
		 */
		list.addFirst("★★");//연결리스트의 맨 앞에 추가
		list.addLast("♥o♥");
		
		list.add(1, "모두");
		list.add("여러분~");//중복 허용
		
		System.out.println("총 객체수 :"+list.size());
		System.out.println();//구분을 위한
		
		
		 if(list.contains("모두")) {//주어진 객체가 저장되어 있으면 true, 없으면 false
			 System.out.println("\"모두\"가 존재한다.");
		 }else System.out.println("'모두'가 존재 하지 않는다.");
		
		System.out.println("2"+list.get(2));
		//get(index):해당 index의 값 얻기
		
		int i;
		for(i=0;i<list.size();i++) {
			System.out.println(i+":"+list.get(i));
		}
		System.out.println("--항상된 for문으로 출력--");
		for(String str:list) {
			System.out.println(str);
		}
		System.out.println("----삭제-1(인덱스)-----"); //=> Set게통에는 없음(index가 업승므로)
		System.out.println("index 4에 저장된 삭제한 문자열:"+list.remove(4));
		
		for(i=0;i<list.size();i++) {
			System.out.println(i+":"+list.get(i));
		}
		
		System.out.println("-----삭제-2(객체)----"); //=> set게통에는 있음O
		if (list.remove("정말~")) System.out.println("찾아서 있으면 삭제 후 true -> 삭제됨");
		else System.out.println("찾아서 없으면 false -> 삭제안됨");
		
		System.out.println("---모두 삭제---");
		if(list.removeAll(list)) //전체삭제, boolean타입이여서 
		System.out.println("모두삭제 되엇나?");
		else System.out.println("모두 삭제안됨");
			
		list.clear();//삭제하면 void이므로 삭제됬는지 확인해야함
		System.out.println("총 객체수 :"+list.size());
		
		if(list.isEmpty())System.out.println("참조하는객체 없음");
		else System.out.println("참조하는 객체 있음");
	} 

}
