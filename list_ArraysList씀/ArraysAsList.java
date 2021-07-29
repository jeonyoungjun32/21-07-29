package list_ArraysList씀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		String[] s = {"윤호섭","이수광"};//배열 선언과 동시 초기화
		
		/* 
		 * ArrayList : 배열처럼 선언과 동시에 초기화 불가능하다. (기본값인 null로채워짐)
		 * 			      그러나 추가나 삭제 등은 메서드를 통해 쉽게 사용 가능
		 * 
		 * Arrays : 배열을 조작하기 위한 클래스
		 * 			배열처럼 선언과 동시에 초기화 가능
		 * 			그러나 추가나 삭제가 불가능
		 * 
		 * 그래서 ' 배열처럼 선언과 동시에 초기화'가되고 
		 * ArrayList'처럼 추가나 삭제 등을 메서드를 사용' 할 수 있는 방법
		 * 아래 소스에서 방법을 참조~
		 * 
		 * ArrayList 선언과 동시에 초기화하는 방법
		 */
		
		/*
		 * 1. Arrays.asList() 이용하여 순차적으로 입력된 값(초기값)으로 고정된 List객체 생성
		 * (아직 추가나 삭제 메서드 사용 불가. 이유? List는 인터페이스이므로 미완성된 추상 메서드로 사용불가)
		 */
		List<String> list1=Arrays.asList("유신재","김경탄","김명강");
		
		/*
		 * 항상된 for문: index로 값을 접근하지 않으므로 값을 참조할 떄만 사용
		 * 			     값을 변경할 때는 사용 불가(이유? 값을 변경하려면 index가 필요함)
		 */
		//list1.remove(0);//삭제 ->예외 -> 프로그램강제 종료
		//list1.add("조지영");//추가 -> 예외 -> 프로그램 강제종료
		
		System.out.println("총 객체수 "+list1.size());
		System.out.println(list1.get(1));
		
		System.out.println("------------항상된 for문으로 출력--------------");
		for(String name:list1) { 
			System.out.println(name);
		}
		
		System.out.println("-------------------------------");
		/*
		 * 2. 이렇게 만들어진 List객체로 ArrayList 객체 생성하여 
		 *    추가나 삭제 등을 메서드를 사용 할 수 있다.
		 */
		 list1=new ArrayList<String>(list1);//초기화 + 추가나 삭제 메서드 사용 가능 
		 list1.add("조지영");//추가
		 System.out.println("index 0에 저장된 문자열 삭제"+list1.remove(0));//삭제
		 
		 System.out.println("------------항상된 for문으로 출력--------------");
		 for(String name:list1) { 
				System.out.println(name);
			}
		 System.out.println("=================================================");
		 
		 /*
		  * 375p-	Wrapper클래스 : 기본 자료형을 위한 클래스
		  * (int-	Integer, double - Double....등등)
		  * 
		  */
		 List<Integer> list2=Arrays.asList(1,2,3);//기본타입(int)을 -> '자동 boxing'하여 Intrger타입으로 변환
		 List<Integer> list3=Arrays.asList(new Integer(1),new Integer(2),new Integer(3));
		 
		 //Integer객체 -> 자동 unboxing하여 -> 기본타입 (int)로 변환
		 for(int value :list3) {
			 System.out.println(value);
			 
		 }
		list3= new ArrayList<Integer>(list3);
		list3.add(4);//기본타입(int)을 -> '자동 boxing'하여 Intrger타입으로 변환
		list3.add(new Integer(5));
		System.out.println("index 0에 저장된 문자열 삭제"+list3.remove(0));//삭제
		
		for(int value :list3) {
			 System.out.println(value);
		}
		
		System.out.println("==================375p-Wrapper클래스 참조 =======================");
		 /*
		  * 375p-	Wrapper클래스 : 기본 자료형을 위한 클래스
		  * 					-자동 boxing 또는 unboxing됨
		  * 부모 : Number클래스 (수와 관련된 클래스) 
		  * (int-	Integer, double - Double....등등)
		  * 
		  * 부모: Object클래스
		  * (char -Character, boolean -Boolean)
		  * 
		  * Character만  parseCharacter(문자열)매서드가 없다.
		  * (이유? "abc"(문자가 여러개)-> char 'c'(문자1개)로 변환할 수 없으므로
		  * 그래서 String클래스의 charAt(int index)메서드로 문자열의 특정 문자 1개를 추출함
		  * 
		  */
		
		
		
		System.out.println("---- unboxing-------");
		Integer ivalue =new Integer(123);//부모 Number클래스임
		int myvalue = ivalue.intValue();//unboxing
		
		Integer ivalue2 =new Integer(123);
		int num2 =200;
		num2 =ivalue2 + num2;//integer인 ivalue2가 자동으로 unboxing되어 int(123)로 변환
		System.out.println(num2);
		
		System.out.println("---- boxing-------");
		Integer ivalue3=num2;//int 323->자동 boxing되어 -> Integer 타입으로 변환
		Integer ivalue4=new Integer(num2);//수동 boxing=>권장하지않음		
		
		System.out.println("--문자열()을 -> 기본타입으로 변환--");
		int svalue=Integer.parseInt("123");
		double dvalue=Double.parseDouble("123.4");
		
		//int svalue2=Integer.parseInt("abc");
		
		//Character는 Object의 자식클래스
		Character ch = 'a';//char->자동으로 Character변환되어 저장됨
		char ch2 = ch;//
		
		Boolean b1= true;//자동 boxing
		boolean b2= b1;//자동 unboxing
		
		//Character.parseCharacter();//메서드 자체가 없음
		char ch3="abc".charAt(0);
		System.out.println(ch3);
		
		boolean b3=Boolean.parseBoolean("true");
		System.out.println(b3);
		
	}

}
