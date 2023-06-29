import java.util.Scanner;

public class Main {
	
	static Scanner cin = new Scanner(System.in);
	static int n, x, y;
	static long c;
	
	private static long f(int mid) {
		long block = 1 + 4 * (long)(mid + 1) * mid / 2;
		int l = y - mid;
		int r = y + mid;
		int u = x - mid;
		int d = x + mid;
		if(l <= 0)
			block -= (long)(1 - l) * (1 - l);
		if(r > n)
			block -= (long)(r - n) * (r - n);
		if(u <= 0)
			block -= (long)(1 - u) * (1 - u);
		if(d > n)
			block -= (long)(d - n) * (d - n);
		if(u <= 0 && 1 - u > n - y + 1) {
			int t = (1 - u) - (n - y + 1);
			block += (long)t * (1 + t) / 2;
		}
		if(u <= 0 && (1 - u) > y) {
			int t = (1 - u) - y;
			block += (long)t * (1 + t) / 2;
		}
		if(d > n && d - n > n - y + 1) {
			int t = (d - n) - (n - y + 1);
			block += (long)t * (1 + t) / 2;
		}
		if(d > n && d - n > y) {
			int t = (d - n) - y;
			block += (long)t * (1 + t) / 2;
		}
//		System.out.println(block);
		return block;
	}
	
	public static void main(String args[]) {
		
		n = cin.nextInt();
		x = cin.nextInt();
		y = cin.nextInt();
		c = cin.nextLong();
		
		int low = 0, high = 1000000000;
		int ans = -1;
		while(low <= high) { 
			int mid = (low + high) / 2;
//			System.out.println(mid + " " + f(mid));
			if(f(mid) >= c) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
