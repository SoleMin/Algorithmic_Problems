import java.util.*;

public class cf256b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long x = in.nextLong()-1;
		long y = in.nextLong()-1;
		long c = in.nextLong();
		
		long lo = 0, hi = 2*n+10;
		while(hi - lo > 2) {
			long mid = (hi+lo)/2;
			if(calc(n,x,y,mid) >= c)
				hi = mid;
			else
				lo = mid;
		}
		while(calc(n,x,y,lo) < c) lo++;
		System.out.println(lo);
	}
	static long calc(long n, long x, long y, long t) {
		long ans = (2*t)*(t+1)+1;
		
		long top = Math.max(0,t-x);
		long bottom = Math.max(0,t-(n-1-x));
		long left = Math.max(0,t-y);
		long right = Math.max(0,t-(n-1-y));
		ans -= top*top + bottom*bottom + left*left + right*right;
		
		long tl = Math.max(0, t - (x+y+1));
		long tr = Math.max(0, t - (x+(n-1-y)+1));
		long bl = Math.max(0, t - ((n-1-x)+y+1));
		long br = Math.max(0, t - ((n-1-x) + (n-1-y) + 1));
		
		ans += (tl*tl+tl)/2 + (tr*tr+tr)/2 + (bl*bl+bl)/2 + (br*br+br)/2;
		return ans;
	}
}
