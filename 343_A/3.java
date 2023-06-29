import java.util.Scanner;

public class A {
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
	
	
	public void run() {
		sc = new Scanner(System.in);		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long nr = 0;
		if (a < b) {
			long aux = a;
			a = b;
			b = aux;
		}
		while (a != 0 && b != 0) {
			nr += a / b;
			long c = a % b;
			a = b;
			b = c;
		}
		
		pln(nr);
		return;
		
	}
	public static void main(String[] args) {
		A t = new A();
		t.run();
	}
}