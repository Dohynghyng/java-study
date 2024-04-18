package day11;

/*
 예외처리 방법
 try, catch 문 사용
 예외 선언
 
 catch문은 한줄이여도 {}를 생략할 수 없다.
 멀티 catch 블록
 catch (ExceptionA | ExceptionB e)  여기서 AB는 부모자손이면 안됨(그렇게 할 이유가 없음)
 {
 	e.methodA(); // ExceptionA에만 선언된 메서드는 호출 불가 instanceof로 확인 후 사용 가능
 }
 */

public class Day11 {
	public static void main(String[] args) {
		System.out.println(1);
		try {
			System.out.println(0/0); // 런타임에러 발생
			System.out.println(2);
		}
		catch (ArithmeticException ae) {
			ae.printStackTrace();                // 호출 스택 메서드 저오와 예외 메시지 출력
			System.out.println(ae.getMessage()); // 예외 메시지 출력
			System.out.println(3);
		}
		catch (Exception e) { // Exception은 모든 예외의 조상이기 때문에 마지막에 와야함
			System.out.println("Exception");
		}
		finally {
			System.out.println("try, catch 문과 상관없이 실행되는 블록");
		}
		System.out.println(4);
		
		// 예외 발생시키기
		try {
		Exception ex = new Exception("예외 발생"); // 예외 생성
		throw ex; // 예외 발생
		} catch (Exception e) {
			System.out.println("에러메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("정상종료");

	
		/*
		// 연결된 예외
		1.  묶어서 처리
		try {
			//install() 함수 실행
		} catch(SpaceException e) {
			e.printStackTrace();
		} catch(MemoryException e) {
			e.printStackTrace();
		}
		
		// 이러한 예외를 묶어서 처리
		try {
			//install() 함수 실행
		} catch(InstallException e) {
			e.printStackTrace();
		}
		
		2. checked 예외를 unchecked 예외로 변경
		*/
		
		/*
		 hashCode
		 객체의 해시코드를 반환
		 Object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
		 */
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1.equals(str2)); // true
		System.out.println(str1.hashCode()); // 96354
		System.out.println(str2.hashCode()); // 96354
		
		
		System.out.println(System.identityHashCode(str1)); // 3526198
		System.out.println(System.identityHashCode(str2)); // 7699183
		
		// toString
		// 객체를 문자열로 반환
		/*
		public String toString() {
			return getClass().getName()+"@"+Integer.toHexString(hashCode());
		}
		*/
		
		/*
		 Object 클래스
		 protected Object clone()
		 public boolean equals(Object obj)
		 public Class getClass()
		 public int hashCode()
		 public String toString()		 
		 */
		
		
		class Value{
			int value;
			
			Value(int value){
				this.value = value;
			}
		}
		
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		System.out.println(v1.equals(v2)); // false > 주소값이 다름
		// true를 만들기 위해선 Value의 equals를 오버라이딩 해야함
		
		// String 클래스
		// 불변 특성 때문에 잦은 내용 변경은 StringBuffer를 사용
		
		String str_1 = "abc";
		String str_2 = "abc";
		String str_3 = new String("abc");
		String str_4 = new String("abc");
		
		
		// str_1 == str_2 true > 문자열 리터럴은 시작되면 자동 생성
		// str_3 == str_4 false > 주소값 비교
		str_1.equals(str_2);  // > true
		str_3.equals(str_4);  // > true > 내용 비교 
		
		
		
	}
}

// 사용자 정의 예외 만들기
// Exception 혹은 RuntimeException을 상속받음
class MyException extends Exception{
	MyException(String msg){
		super(msg);
	}
}



