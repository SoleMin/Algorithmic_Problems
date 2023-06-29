import java.util.*;

public class B {
	static long sum(long from, long to){
		final long d = to - from;
		return (d*(d + 1))/2 + (d + 1)*from;
	}
	static long howMany(long n, long k){
		if (n == 1){
			return 0;
		}
		if (n > (k*(k - 1))/2 + 1){
			return -1;
		}
		long hi = k - 1;
		long lo = 1;
		while (lo < hi){
			final long mi = (lo + hi + 1) >> 1;
			final long sum = sum(mi, k - 1);
			if (n - 1 - sum < mi){
				lo = mi;
			}else{
				hi = mi - 1;
			}
		}
		long res = k - lo;
		final long sum = sum(lo, k - 1);
		if (n - 1 - sum > 0){
			res++;
		}
		return res;
	}
	public static void main(String [] args){
		try (Scanner s = new Scanner(System.in)){
			final long n = s.nextLong();
			final long k = s.nextLong();
			System.out.println(howMany(n, k));
		}
	}
}
