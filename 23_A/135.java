import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

public class A {

	private BufferedReader in;	
	private StringTokenizer st;
	
	
	void solve() throws IOException{
		
		int len = 0;
		String x = next();
		HashSet<String> h = new HashSet<String>();
		for (int i = 0; i < x.length(); i++) {
			for (int j = i+1; j <= x.length(); j++) {
				String y = x.substring(i,j);
				if(h.contains(y)){
					if(y.length()>len) len = y.length();
				}
				else h.add(y);
			}
		}
		System.out.println(len);
		
	}
	A() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));			
		eat("");
		solve();			
	}
	
	private void eat(String str) {
		st = new StringTokenizer(str);
	}

	String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}


	public static void main(String[] args) throws IOException {		
		
		new A();
	}

}
