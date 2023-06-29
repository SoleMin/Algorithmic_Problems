//package round17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class A {

	static StreamTokenizer in =
		new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
	static int nextInt() throws IOException{
		in.nextToken();
		return (int)in.nval;
	}
	
	static PrintWriter out = new PrintWriter(System.out);
	
	static boolean prime(int n){
		int j = 2;
		while (j*j <= n)
			if (n%j == 0) return false;
			else j++;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		int n = nextInt(),
			k = nextInt(),
			a[] = new int[n];

		int s = 0;
		for (int i=2; i<=n; i++)
			if (prime(i))
				a[s++] = i;
		
		int m = 0;
		for (int i=2; i<s; i++)
			for (int j=i-1; j>0; j--)
				if (a[i] == a[j]+a[j-1]+1){
					m++;
					break;
				}
		
		if (m >= k) out.println("YES");
		else out.println("NO");
		out.flush();
	}

}
