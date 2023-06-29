import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class C_138B {
	private static BufferedReader in;
	private static StringTokenizer st;
	private static PrintWriter out;
	
	
	static String nextToken() throws IOException {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
	
	static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer("");
		out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = nextInt();
		int k = nextInt();
		int [] a = new int [n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
			if(set.size()==k){
				Set<Integer> set2 = new HashSet<Integer>();
				for (int j = i; j >= 0; j--) {
					set2.add(a[j]);
					if(set2.size()==k){
						out.print((j+1)+" "+(i+1));
						out.close();
						return;
					}
				}
			}
		}
		out.print("-1 -1");		
		out.close();
	}
}
