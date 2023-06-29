import java.util.*;
import java.io.*;

public class B {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt(), k = sc.nextInt();
		
		
		long start = 1, end = n;
		
		while(start <= end) {
			long mid = (start + end) >> 1;
			if(calc(mid) - (n - mid) == k) {
				System.out.println(n - mid);
				return;
			} else if (calc(mid) - (n - mid) > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}
		
	}
	
	public static long calc(long n) {
		return (n * n + n) / 2;
	}
}
