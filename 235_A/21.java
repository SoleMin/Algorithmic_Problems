import java.util.*;
import java.lang.*;
import java.io.*;

public class LCM {
	public static long gcd(long a,long b) {
		while(true) {
	    	a=a%b;
		  	if (a==0) return b;
		    b=b%a;
		    if (b==0) return a;
		}
    }
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in=new Scanner(System.in);
		long n=in.nextInt();
		if (n>2) {
			if (gcd(n,n-2)>1) {
				if (gcd(n,n-3)>1) {
					System.out.println((n-1)*(n-2)*(n-3));
				}
				else System.out.println(n*(n-1)*(n-3));
			}
			else System.out.println(n*(n-1)*(n-2));
		}
		else System.out.println(n);
	}
}