

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		long n = sc.nextLong();
		int k = sc.nextInt();
		
		if(n==1){
			System.out.println(0);
			return;
		}
		n=n-1;
		int count = 0;
		long nextK = k-1;
		while(true){
			//System.out.println("n = " + n);
			
			if(nextK < 1 || (nextK <= 1 && n >1)){
				System.out.println(-1);
				return;
			}
			
			nextK = Math.min(n, nextK);
			if(n==nextK){
				System.out.println(count+1);
				return;
			}
			//System.out.println("nextK = " + nextK);
			
			//search for a of a...nextK 
			long bSum = nextK * (nextK+1)/2;
			long a = nextK;
			long decrement = 1;
			while(bSum - (a-1)*a/2 <= n && a>=1){
				a-= decrement;
				decrement *= 2;
			}
			a+=decrement/2;
			
			//System.out.println("a = " + a);
			
			count += nextK-a+1;
			//System.out.println("count = " + count);
			long nDecr = bSum-a*(a-1)/2;
			//System.out.println("bSum = " + bSum);
			//System.out.println("nDecr = " + nDecr);
			n -= nDecr;
			nextK = a-1;
			if(n==0){
				System.out.println(count);
				return;
			}
		}
	}
	
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}
}
