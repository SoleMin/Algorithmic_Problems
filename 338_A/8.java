

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws Exception {
		int n=nextInt();
		int m=nextInt();
		int k=nextInt();
		int wa=n-m;
		if(n/k<=wa){
			System.out.println(m);
		}else{
			int notFull=wa;
			int full=n/k-wa;
			long res=1;
			int power=full+1;
			int mod=1000000009;
			long powTwo=2;
			while(power>0){
				if((power&1)==1){
					res=(res*powTwo)%mod;
				}
				power>>=1;
				powTwo=(powTwo*powTwo)%mod;
			}
			res=(((res-2+mod)%mod)*k)%mod;
			res=((res+notFull*(k-1))%mod+n%k)%mod;
			System.out.println(res);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer tokenizer = new StringTokenizer("");

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	static double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	static String next() throws Exception {
		while (true) {
			if (tokenizer.hasMoreTokens()) {
				return tokenizer.nextToken();
			}
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			tokenizer = new StringTokenizer(s);
		}
	}
}
