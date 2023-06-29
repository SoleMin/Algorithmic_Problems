import java.util.Scanner;

public class Test {
	
	private static long sum(long value) {
		long ans = 0;
		while (value > 0) {
			ans += value % 10;
			value /= 10;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		long n , s , ans = 0;
		n = scan.nextLong();
		s = scan.nextLong();
		long current = s;
		while (current <= n && current <= s + 20 * 9) {
			// current - sum(current) >= s
			long temp = sum(current);
			if (current - temp >= s) {
				ans ++;
			}
			current ++;
		}
		if (current <= n) {
			ans += (n - current + 1);
		}
		System.out.println(ans);
		
	}
	
		
}
	
	
	
	
	







