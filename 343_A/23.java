import java.util.*;
import java.lang.*;
import java.io.*;


public class Ideone {
	static long ans=0;
	public static void Stepgcd(long a,long b) {
		if (b!=0) {ans+=(a/b);Stepgcd(b,a%b);}
    }
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in=new Scanner(System.in);
		long a=in.nextLong(),b=in.nextLong();
		Stepgcd(a,b);
		System.out.println(ans);
	}
}