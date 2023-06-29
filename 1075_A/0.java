import java.util.Scanner;

public class _0360TheKingsRace {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();
		long x=sc.nextLong();
		long y=sc.nextLong();
		long white=(Math.abs(1-x)+Math.abs(x-y));
		long black=(Math.abs(n-y)+Math.abs(x-y));
		if(white<=black) {
			System.out.println("White");
		}
		else {
			System.out.println("Black");

		}
	}

}
