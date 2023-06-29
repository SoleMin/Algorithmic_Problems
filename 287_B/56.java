import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

// Pipeline
// 2013/03/23
public class P287B{
	Scanner sc=new Scanner(System.in);

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
			long ub=k*(k+1)/2-(k-m)*(k-m+1)/2-(m-1);
			if(ub>=n){
				right=m;
			}else{
				left=m;
			}
		}
		println(""+(right>k?-1:right));
	}

	void println(String s){
		System.out.println(s);
	}

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		new P287B().run();
	}
}
