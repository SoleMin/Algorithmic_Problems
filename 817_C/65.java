import java.math.BigDecimal;
import java.util.Scanner;

public class ReallyBigNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long s = scan.nextLong();
		long ans = 0;
		long l = 0;
        long r = n;
        while (l <= r) {
            // Key is in a[lo..hi] or not present.
            long mid = l + (r - l) / 2;
            if(isReallyBig(mid, s)){
            	ans = mid;
            	r = mid-1;
            }
            else l = mid+1;
        }
        if(ans == 0) System.out.println(ans);
        else
        	System.out.println(n-ans+1);
	}
	
	static boolean isReallyBig(long m, long s){
		String x = m+"";
		long sum = 0;
		for(int i = 0; i < x.length(); i++){
			sum += x.charAt(i)-'0';
		}
		if(m-sum >= s) return true;
		return false;
	}
}
