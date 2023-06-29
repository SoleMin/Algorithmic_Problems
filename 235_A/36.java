import java.io.*;
import java.util.*;

public class lcm {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("lcm.in"));
		n = Integer.parseInt(in.readLine());
		System.out.println(lcm(n));
		in.close();
	}
	
	static long lcm(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		
		if(n%6==0) {
			long ans = n-1;
			ans *= n-2;
			ans *= n-3;
			return ans;
		}
		
		if (n%2==0) {
			long ans = n;
			ans *= n-1;
			ans *= n-3;
			return ans;
		}
		
		long ans = n;
		ans *= n-1;
		ans *= n-2;
		return ans;
	}
}
