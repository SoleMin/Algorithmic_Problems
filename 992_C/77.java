import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;


public class main {
	
	static long d,x,y;
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
	    
		long x = in.nextLong(), k = in.nextLong();
		
		long mod = 1000000007;
		
		long one = pow(2,k,mod);
		
		one %= mod;
		
		long two = (2*x)%mod-1;
		
		two %= mod;
		
		long ans = (one*two)%mod+1;
		
		ans %= mod;
		
		if(ans<0)
			ans += mod;
		
		if(x==0)
			System.out.println("0");
		else
			System.out.println(ans);
	        
	}
	private static long pow(long a, long b, long mod) {
		if(b==0) return 1;
		
		if(b==1)
			return a;
		
		if(b%2==0)
			return pow((a*a)%mod,b/2,mod);
		else
			return (a*pow((a*a)%mod,(b-1)/2,mod))%mod;
		
	}
	
	

	

}










class FastScanner {
	BufferedReader br;
	StringTokenizer st;
	
	public FastScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	
	int nextInt() {
		return Integer.parseInt(next());
	}
	
	long nextLong() {
		return Long.parseLong(next());
	}
}
