import java.util.*;

/*Author LAVLESH*/
public class solution
{  
	static long gcd(long a,long b){
		if(b==0) return a;
		else 
			return gcd(b,a%b);
		
	}
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		long n=in.nextLong();
		long m1=0,m2=0;
		if(n<3)m1=n;
		else {
			if((n&1)==1){
				long lcm=n*(n-1)/gcd(n,n-1);
				m1=lcm*(n-2)/gcd(lcm,n-2);
			}
			else{
				long lcm=(n-1)*(n-2)/gcd(n-1,n-2);
				m1=lcm*(n-3)/gcd(lcm,n-3);
				
				 lcm=n*(n-1)/gcd(n,n-1);
				m2=lcm*(n-3)/gcd(lcm,n-3);
				m1 = Math.max(m1,m2);
			}
		}
		System.out.println(m1);
		
}}

