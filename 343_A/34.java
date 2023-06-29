
import java.util.Scanner;

public class C {
	static long n = 0;
		static void R (long a,long b){
			n += a/b;
			a = a%b;
			if(a==0) return;
			R(b,a);
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		R(a,b);
		System.out.println(n);
	}
}