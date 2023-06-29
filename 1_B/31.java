import java.io.*;
import java.util.*;

public class Elektronnietablici {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static String nextToken() throws IOException{
		while (in == null || !in.hasMoreTokens()){
			in = new StringTokenizer(br.readLine());
		}
		
		return in.nextToken();
	}
	
	public static int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
	
	public static double nextDouble() throws IOException{
		return Double.parseDouble(nextToken());
	}
	
	public static void main(String[] args) throws IOException{
		int n = nextInt();
		
		String S;
		for (int i = 0; i < n; i++) {
			S = nextToken();
			
			int f = 0;
			if (S.charAt(0) == 'R' && S.charAt(1) >= '1' && S.charAt(1) <= '9'){
				for (int j = 2; j < S.length(); j++) {
					if (S.charAt(j) >= 'A' && S.charAt(j) <= 'Z'){
						f = 1;
						break;
					}
				}
			}
			
			if (f == 0){
				String T1 = "";
				String ans = "R";
				
				int j;
				
				for (j = 0; S.charAt(j) >= 'A' && S.charAt(j) <= 'Z'; j++) {
					T1 += S.charAt(j);
				}
				
				ans += S.substring(j, S.length()) + "C";
				
				int len = j;
				
				j--;
				
				int p = 1;
				int z = 0;
				for (;  j >= 0; j--) {
					z += (S.charAt(j) - 'A') * p;
					p *= 26;
				}
				
				p = 1;
				for (int k = 0; k < len; k++) {
					z += p;
					p *= 26;
				}
				
				ans += z;
				
				out.println(ans);
			}
			else{
				String T1 = "";
				String ans = "";
				
				int j;
				for (j = 1; S.charAt(j) != 'C'; j++) {
					ans += S.charAt(j);
				}
				
				T1 = S.substring(j + 1, S.length());
				int z = Integer.parseInt(T1);
				int p = 1;
				int len = 0;
				
				while (p <= z){
					z -= p;
					p *= 26;
					len++;
				}
				p /= 26;
				
				T1 = "";
				
				for (int k = len - 1; k >= 0; k--) {
					int l = z / p;
					
					T1 += (char)(z / p + 'A');
					
					z -= l * p;
					
					p /= 26;	
				}
				ans = T1 + ans;
				
				out.println(ans);
			}
		}
		
		//2
		//R23C55
		//BC23
		
		out.close();
	}
}
