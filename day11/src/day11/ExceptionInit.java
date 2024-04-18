package day11;

// throws를 통해여 예외를 떠넘김

public class ExceptionInit {
	public static void main(String[] args) throws Exception{
		method1();
	}
	static void method1() throws Exception{
		method2();
	}
	static void method2() throws Exception{
		throw new Exception();
	}

}
