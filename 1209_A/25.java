//package practice;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Stack;
import java.util.regex.Pattern;

public class ROUGH {
	
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		//it reads the data about the specified point and divide the data about it ,it is quite fast
		//than using direct 

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception r) {
					r.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());//converts string to integer
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception r) {
				r.printStackTrace();
			}
			return str;
		}
	}
	
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	static long mod = (long) (1e9+7);
	static int N = (int) 1e5;
//	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		 FastReader sc = new FastReader();
		 int n = sc.nextInt();
		 int[] a = new int[n];
		 TreeSet<Integer> set = new TreeSet<Integer>();
		 for(int i=0;i<n;++i) {
			 a[i] = sc.nextInt();
			 set.add(a[i]);
		 }
		 long ans = 0;
		 while(set.size() > 0) {
			 ++ans;
			 int min = set.first();
			 TreeSet<Integer> temp = new TreeSet<>();
			 for(int x : set) {
				 if(x%min != 0) temp.add(x);
			 }
			 set = temp;
			 
		 }
		 out.print(ans);
		 
		 out.close();
	}
	
}