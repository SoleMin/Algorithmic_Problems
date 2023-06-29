import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		long posible = binarySearch(n,s);
		long dig, answer;
		long i, cmed;
		for (i = posible; i >= 0; i--) {
			dig = 0;
			cmed = i;
			while (cmed > 0) {
				dig = dig+cmed%10;
				cmed/=10;
			}
			if (i-dig < s) {
				break;
			}
		}
		answer = n-i;
		System.out.println(answer);
	}
	private static  long binarySearch(long n, long s){
		long med=n, l = 0, r = n, cmed, dig;
		while(l<=r){
			med = (l+r)/2;
			cmed = med;
			dig = 0;
			while (cmed > 0) {
				dig = dig+cmed%10;
				cmed/=10;
			}
			if (med-dig == s) {
				break;
			}else {
				if (med-dig > s) {
					r = med-1;
				}else {
					l = med+1;
				}
			}
			//System.out.println(med);
		}
		return med;
	}

}