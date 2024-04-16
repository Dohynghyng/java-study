package pkg1;

/*
 퍼블릭 클래스는 1개만 가능하며 소스파일 이름과 일치해야함
 */

public class MyParent {
	private   int prv;  // 같은 클래스
	          int dft;  // 같은 패키지
	protected int prt;  // 같은 패키지 + 자손(다른 패키지)
    public    int pub;  // 접근 제한 없음
    
    public void printMembers() {
    	System.out.println(prv);
    	System.out.println(dft);
    	System.out.println(prt);
    	System.out.println(pub);
    }
}

class Day9 {
	public static void main(String[] args) {
		/* 
		 접근 제어자(아래로 갈 수록 범위가 넓음)
		 private    > 같은 클래스 내에서만 접근
		 (default)  > 같은 패키지
		 protected  > 같은 패키지 + 다른 패키지 자손
		 public     > 접근 제한이 없음
		 
		 클래스 앞에는 public, (default)
		 멤버 변수는 모두 가능
		 */
		MyParent p = new MyParent();
    	// System.out.println(p.prv); > 접근 범위 오류
    	System.out.println(p.dft);
    	System.out.println(p.prt);
    	System.out.println(p.pub);
	}

}
