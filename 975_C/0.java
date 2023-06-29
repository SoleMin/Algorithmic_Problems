import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class C {
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
//		int yo = sc.nextInt();
//		while(yo-->0) {
//		}
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		long[] a = new long[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		long[] preSum = new long[n];
		preSum[0] = a[0];
		for(int i = 1; i < n; i++) {
			preSum[i] += a[i]+preSum[i-1];
		}
		long[] k = new long[q];
		for(int i = 0; i < q; i++) {
			k[i] = sc.nextLong();
		}
		
		
		int start = 0, end = n-1;
		long total = 0;
		for(long arrow : k) {
			total += arrow;
			int ans = -1;
			if(total >= preSum[n-1]) {
				total = 0;
				start = 0;
				end = n-1;
				pw.println(n);
				continue;
			}
			
			while(start <= end) {
				int mid = start + (end-start)/2;
				if(preSum[mid] <= total) {
					ans = mid;
					start = mid+1;
				}
				else {
					end = mid-1;
				}
			}
			 
			if(ans == -1) {
				pw.println(n-start); 
			}
			else{
				start = ans+1;
				pw.println(n-ans-1);
			}
		
			end = n-1;
		}
	
		pw.close();
		
	}
	








	static int gcd(int a, int b) {
		return a%b == 0 ? b : gcd(b,a%b);
	}
	
	static boolean[] sieve(int n) {
		boolean isPrime[] = new boolean[n+1];
		for(int i = 2; i <= n; i++) {
			if(isPrime[i]) continue;
			for(int j = 2*i; j <= n; j+=i) {
				isPrime[j] = true;
			}
		}
		return isPrime;
	}
	
	
	
	

	static int mod = 1000000007;
	static long pow(int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		if(b%2 == 0) {
			long ans = pow(a,b/2);
			return ans*ans;
		}
		else {
			long ans = pow(a,(b-1)/2);
			return a * ans * ans;
		}
		
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

//	For Input.txt and Output.txt
	
//	FileInputStream in = new FileInputStream("input.txt");
//	FileOutputStream out = new FileOutputStream("output.txt");
//	PrintWriter pw = new PrintWriter(out);
//	Scanner sc = new Scanner(in);
}
