import java.util.Scanner;

public class A {
	
	public static boolean realbig (long num, long s) {
		String str = num + "";
		String[] digs = str.split("");
		int sum = 0;
		for(String dig : digs) {
			sum+= Integer.parseInt(dig);
		}
		if(num-sum < s) {
			return false;
		} else {
			return true;
		}
	}

		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long s = sc.nextLong();
		sc.close();
		long count = 0;
		long i = s;
		for(; i < s+200 && i <= n; i++) {
			if(realbig(i,s)) {
				count++;
			}
		}
		if(i <= n) {
			count+=n-i+1;
		}
		System.out.println(count);
	}
}
