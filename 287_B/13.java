import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class P287B{
	Scanner sc=new Scanner(System.in);

	int INF=1<<28;
	double EPS=1e-9;

	long n, k;

	void run(){
		n=sc.nextLong();
		k=sc.nextLong();
		solve();
	}

	void solve(){
		long left=-1, right=k+1;
		for(; right-left>1;){
			long m=(left+right)/2;
			long lb=k*(k+1)/2-(k-m)*(k-m+1)/2-(m-1);
			if(lb>=n){
				right=m;
			}else{
				left=m;
			}
		}
//		debug(left, right);
		println(""+(right>k?-1:right));
	}

	void println(String s){
		System.out.println(s);
	}

	void print(String s){
		System.out.print(s);
	}

	void debug(Object... os){
		System.err.println(deepToString(os));
	}

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		new P287B().run();
	}
}
