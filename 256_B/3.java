import java.util.Scanner;


public class B {
	public static final boolean DEBUG = false;
	Scanner sc;
	
	public void debug(Object o) {
		if (DEBUG) {
			int ln = Thread.currentThread().getStackTrace()[2].getLineNumber();
			String fn = Thread.currentThread().getStackTrace()[2].getFileName();
			System.out.println("(" + fn + ":" + ln+ "): " + o);
		}
	}
	
	public void pln(Object o) {
		System.out.println(o);
	}
	
	long getNumber(int x, int y, int n, int m) {
		int n1 = Math.max(0, x + m - n);
		int n2 = Math.max(0, y + m - n);
		int n3 = Math.max(0, 1 - (x - m));
		int n4 = Math.max(0, 1 - (y - m));
		
		int n12 = Math.max(0, n1 + n2 - m - 1);
		int n23 = Math.max(0, n2 + n3 - m - 1);
		int n34 = Math.max(0, n3 + n4 - m - 1);
		int n41 = Math.max(0, n4 + n1 - m - 1);
		
//		debug(n1 + " " + n2 + " " + n3 + " " + n4);
//		debug(n12 + " " + n23 + " " + n34 + " " + n41);
		
		int m1 = m+1;
		long nr = 1 + ((long)m1)*m1*2 - m1*2;
		nr -= ((long)n1)*n1 + ((long)n2)*n2 + ((long)n3)*n3 + ((long)n4)*n4;
		nr += ((long)n12)*(n12+1)/2 + ((long)n23)*(n23+1)/2 + ((long)n34)*(n34+1)/2 + ((long)n41)*(n41+1)/2;
		
		return nr;
	}
	public void run() {
//		pln(getNumber(1, 1, 10000, 10000000));
//		pln(getNumber(1000, 1000, 1000, 1000000));
//		if (true) return;

		sc = new Scanner(System.in);		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int c = sc.nextInt();
		
		if (c <= 1) {
			pln(0);
			return;
		}
		
		int ll = 0;
		int rr = 2*n+20;
		
		while(true) {
			int m = (ll+rr) / 2;
			if (getNumber(x, y, n, m) >= c) {
				rr = m;
			}
			else {
				ll = m;
			}
//			debug(ll + " " + rr);
			
			if (rr - ll < 3) {
				for (int m2=ll; m2<=rr; m2++) {
					if (getNumber(x, y, n, m2) >= c) {
						pln(m2);
						return;
					}
				}
			}
		}
		
	}
	public static void main(String[] args) {
		B t = new B();
		t.run();
	}
}
