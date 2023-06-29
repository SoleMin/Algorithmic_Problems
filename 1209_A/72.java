import java.io.*;
import java.util.*;

public class Problem_A {
	
	public static void main(String[] args) {
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int[] elements = new int[n];
		for (int i = 0; i < n; i++)
			elements[i] = scan.nextInt();
		
		int x = 0;
		
		Arrays.sort(elements);
		while(n > 0) {
			x++;
			int[] temp = new int[n];
			int j = 0;
			int size = n;
			int min = elements[0];
			n--;
			for (int i = 1; i < size; i++) {
				if (elements[i]%min == 0) {
					n--;
				}
				else {
					temp[j++] = elements[i];
				}
			}
			
			elements = temp;
		}
		
		out.println(x);
		out.close();
	}

	public static PrintWriter out  = new PrintWriter(new BufferedOutputStream(System.out));
	public static class MyScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while (st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
}
