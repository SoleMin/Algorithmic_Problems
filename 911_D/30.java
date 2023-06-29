import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D {
	
	public static class BIT {
		int[] dat;
		
		public BIT(int n){
			dat = new int[n + 1];
		}
		
		public void add(int k, int a){ // k : 0-indexed
			for(int i = k + 1; i < dat.length; i += i & -i){
				dat[i] += a;	
			}
		}
		
		public int sum(int s, int t){ // [s, t)
			if(s > 0) return sum(0, t) - sum(0, s);
			
			int ret = 0;
			for(int i = t; i > 0; i -= i & -i) {
				ret += dat[i];
			}
			return ret;
		}
	}
	
	public static void main(String[] args) {
		try (final Scanner sc = new Scanner(System.in)) {
			final int N = sc.nextInt();
			int[] array = new int[N];
			for(int i = 0; i < N; i++){
				array[i] = sc.nextInt() - 1;
			}
			
			long inv = 0;
			BIT bit = new BIT(N);
			for(int i = 0; i < N; i++){
				inv += bit.sum(array[i], N);
				bit.add(array[i], 1);
			}
			//System.out.println(inv);
			
			int mod2 = (int)(inv % 2);
			final int M = sc.nextInt();
			for(int i = 0; i < M; i++){
				final int l = sc.nextInt() - 1;
				final int r = sc.nextInt() - 1;
				
				final long size = (r - l) + 1;
				if(size > 1){
					//System.out.println(size + " " + ((size * (size - 1) / 2)));
					if((size * (size - 1) / 2) % 2 == 1){
						mod2 = 1 - mod2;
					}
				}
				
				System.out.println((mod2 == 0) ? "even" : "odd");
			}
		}
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}

		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}

		public String next() {
			getLine();
			return tok.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
