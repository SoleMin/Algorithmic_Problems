import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class A{
	Scanner sc=new Scanner(System.in);

	int INF=1<<28;
	double EPS=1e-9;

	int mod=(int)1e9+9;

	long n, m, k;

	void run(){
		n=sc.nextLong();
		m=sc.nextLong();
		k=sc.nextLong();
		solve();
	}

	void solve(){
		long ans=0;
		long s=n-m;
		long remain=max(n-s*k, 0);
//		debug("remain", remain);
		ans=m-remain;
//		debug("ans", ans);
		long r=remain%k;
		ans=(ans+r)%mod;
		remain-=r;
//		debug("remain2", remain);
		long a=remain/k;
		long add=(powMod(2, a, mod)-1)*k%mod*2%mod;
//		debug("add", add);
		ans=(ans+add)%mod;
//		debug(ans);
		println(ans+"");
	}

	long powMod(long x, long k, long mod){
		if(k==0){
			return 1%mod;
		}else if(k%2==0){
			return powMod(x*x%mod, k/2, mod);
		}else{
			return x*powMod(x, k-1, mod)%mod;
		}
	}

	void println(String s){
		System.out.println(s);
	}

	void print(String s){
		System.out.print(s);
	}

	void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		new A().run();
	}
}
