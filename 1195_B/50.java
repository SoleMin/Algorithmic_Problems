import java.util.*;
import java.io.*;

public class B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	public static void main(String[] args) throws Exception {
		String[] split = br.readLine().split(" ");
		
		long n = Long.parseLong(split[0]);
		long k = Long.parseLong(split[1]);
		
		long left = -1;
		long right = n + 1;
		
		while(right - left >= 2) {
			long mid = (left + right) / 2; // 10
			// if(mid > n) {
				// right = mid;
				// continue;
			// }
			
			long newN = n - mid; //-5
			long temp = newN * (newN + 1) / 2; //10
			
			long eh = temp - k - mid;
			
			if(eh == 0) {
				pw.println(mid);
				break;
			}
			else if(eh < 0)
				right = mid;
			else
				left = mid;
		}
		
		pw.close();
	}
}