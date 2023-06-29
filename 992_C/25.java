import java.util.*;
import java.lang.*;
import java.io.*;
public class C{
	public static void main (String[] args) throws java.lang.Exception{
		Scanner scan=new Scanner(System.in);
		long x=scan.nextLong(), k=scan.nextLong();
		long MOD = 1000000007;
		if(x==0){
			System.out.println("0");
			return;
		}
		x %= MOD;
		long ans= (((new myC()).fastPow(2L, k+1)*x)%MOD - (new myC()).fastPow(2L, k) + MOD + 1)% MOD;
		ans %= MOD;
		System.out.println(ans);
	}
}

class myC{
	long MOD = 1000000007;
	long fastPow(long x, long k){
		long bb=x%MOD, ans=1;
		while(k > 0){
			if((k&1)==1){
				ans=(ans*bb)%MOD;
			}
			bb=(bb*bb)%MOD;
			k>>=1;
		}
		return ans;
	}
}