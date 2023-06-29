import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {
	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		String cur = sc.nextToken();
		int first = Integer.parseInt(cur);
		if(cur.length() > 1){
			String second = cur.substring(0,cur.length()-1);
			if(Character.isDigit(second.charAt(second.length()-1))){
				first = Math.max(first, Integer.parseInt(second));
			}
		}
		
		if(cur.length() > 2){
			String third = cur.substring(0,cur.length()-2) + cur.charAt(cur.length()-1);
			if(Character.isDigit(cur.charAt(cur.length()-2))){
				first = Math.max(first, Integer.parseInt(third));
			}
		}
		System.out.println(first);
		out.close();
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
