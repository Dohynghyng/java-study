package pkg2;

import pkg1.*;

class MyChild extends MyParent{
    public void printMembers() {
    	// System.out.println(prv); > 접근 범위 오류
    	// System.out.println(dft); > 접근 범위 오류
    	System.out.println(prt);
    	System.out.println(pub);
    }
}

public class Day9_sub {
	public static void main(String[] args) {
		MyParent p = new MyParent();
    	// System.out.println(p.prv); > 접근 범위 오류
		// System.out.println(p.dft); > 접근 범위 오류
		// System.out.println(p.prt); > 접근 범위 오류
    	System.out.println(p.pub);
	    }
}

