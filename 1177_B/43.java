// package name;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		long k = s.nextLong();
		
		long dp[] = new long[13];
		long x = 9; int i = 1;
		
		long ansx = 0; int ansi = 0;
		for(; i < 13; i++) {
			dp[i] = dp[i - 1] + x * i;
			x *= 10;
			if(k <= dp[i]) {
				ansx = x;
				ansi = i;
				break;
			}
			
			if(dp[i] > 1000000000000l) break;
		}
		
		if(ansi < 2) {
			System.out.println(k);
			return;
		}
		
		k -= dp[ansi - 1];
		
		//System.out.println(k);
		
		long st = (long)Math.pow(10, ansi - 1);
		
		long div = (k / ansi);
		if(k % ansi == 0) div--;
		
		k -= div * ansi;
		
		//System.out.println(k);
		System.out.println(findKthDigit(st + div, k));
		
	}

	private static Long findKthDigit(long xx, long k) {
		int z = (int) k;
		ArrayList<Long> arr = new ArrayList();
		while(xx > 0) {
			arr.add(xx % 10);
			xx /= 10;
		}
		return arr.get(arr.size() - z);
	}

}