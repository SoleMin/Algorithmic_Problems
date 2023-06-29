import java.io.*;
import java.util.*;

public class utkarsh{
	BufferedReader br;

	void solve(){
		br = new BufferedReader(new InputStreamReader(System.in));
		int i, j, n, mod = (int)(1e9 + 7);
		n = ni();
		char c[] = new char[n];
		for(i = 0; i < n; i++)	c[i] = ns().charAt(0);
		long dp[][] = new long[n][n];
		dp[0][0] = 1;
		for(i = 1; i < n; i++){
			if(c[i-1] == 'f'){
				for(j = 0; j < i; j++){
					dp[i][j+1] = dp[i-1][j];
				}
			}else{
				for(j = i-1; j >= 0; j--){
					dp[i][j] = dp[i-1][j] + dp[i][j+1];
					dp[i][j] %= mod;
				}
			}
		}
		long ans = 0;
		for(long x : dp[n-1]){
			ans += x;
			ans %= mod;
		}
		System.out.println(ans);
	}

	int ni(){
		return Integer.parseInt(ns());
	}

	String ip[];
	int len, sz;

	String ns(){
		if(len >= sz){
			try{
				ip = br.readLine().split(" ");
				len = 0;
				sz = ip.length;
			}catch(IOException e){
				throw new InputMismatchException();
			}
			if(sz <= 0)	return "-1";
		}
		return ip[len++];
	}

	public static void main(String[] args){	new utkarsh().solve();	}
}