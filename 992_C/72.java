import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
	static final int M = 1000000007;	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long x = Long.parseLong(st.nextToken());
		if(x == 0){
			System.out.println(0);
			System.exit(0);
		}
		final long k = Long.parseLong(st.nextToken());	
		x = x%M;
		
		long ans = (exp(2, k+1)*x - (exp(2, k) - 1))%M;
		if(ans < 0) ans += M;
		System.out.println(ans);
		/*
		for(long i = 1234567890; i < 1234567999; i++){
			ans = (exp(2, i+1)*x - (exp(2, i) - 1))%M;
			if(ans < 0) ans += M;
			System.out.println(ans);
		}
		/*
		System.out.println((k-1)/2);
		System.out.println(x);
		System.out.println(exp(2, k));
		System.out.println(exp(2, k+1));
		*/
	}
	
	public static long exp(long a, long n){
		if(n == 0) return 1;
		if(n == 1) return a%M;
		if(n%2 == 0) return exp((a*a)%M, n/2);
		else return (a*exp((a*a)%M, (n-1)/2))%M;
	}
}
