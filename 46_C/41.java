//package round43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	static String nextToken() throws IOException{
		while (st==null || !st.hasMoreTokens()){
			String s = bf.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s);
		}
		
		return st.nextToken();
	}
	
	static int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
	
	static String nextStr() throws IOException{
		return nextToken();
	}
	
	static int f(byte s[], int n){
		int l = 0,
			r = n-1;
		int res = 0;
		
		do{
			while (l<n && s[l]=='H')
				l++;
			while (r>=0 && s[r]=='T')
				r--;
			
			if (l < r){
				res++;
			}
			l++;
			r--;
		}
		while (l < r);
		
		return res;
	}
	
	public static void main(String[] args) throws IOException{
		int n = nextInt();
		byte s[] = nextStr().getBytes();
		
		int res = f(s, n);
		for (int i=1; i<n; i++){
			byte c = s[0];
			for (int j=0; j<n-1; j++)
				s[j] = s[j+1];
			s[n-1] = c;
			res = Math.min(res, f(s, n));
		}
		
		out.println(res);
		out.flush();
	}

}
