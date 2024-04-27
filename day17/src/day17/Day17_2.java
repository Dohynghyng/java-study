package day17;


//함수형 인터페이스
@FunctionalInterface
interface MyFunction{
	public abstract int max(int a, int b);
}

@FunctionalInterface
interface MyFunction2{
	public abstract void run();
}

public class Day17_2 {
	static void execute(MyFunction2 f) {
		f.run();
	}
	
	static MyFunction2 getMyFunction() {
		MyFunction2 f = () -> System.out.println("f5.run()");
		return f;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		람다식 > 메서드를 간단한 식으로 표현하는 방법 (익명 함수)		
//		람다식 표현		
		MyFunction2 f3 = () -> System.out.println("f3.run()");
		
//		익명 클래스 표현
		MyFunction2 f4 = new MyFunction2() {
				public void run() {
					System.out.println("f4.run()");
				}
		};
		
		MyFunction2 f5 = getMyFunction();
		
		f3.run();
		f4.run();
		f5.run();
		
		execute(f3);
		execute(()->System.out.println("run()"));
		
		
	}

}
