import java.util.*;
 
public class Solution_1 {
	public static void main(String[] args) {
//		solution start :-)
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		if(n%m==0) System.out.println("0");
		else{
		    if(m>n){
		        long res = (long)Math.min((n*b),((m-n)*a));
		        System.out.println(res);
		    }
		    else{
		        long div1 = n/m;
		        long div2 = div1+1;
		        long diff1 = n-div1*m;
		        long diff2 = div2*m-n;
		        long pro1 = diff1*b;
		        long pro2 = diff2*a;
		        long res1 = Math.min(pro1,pro2);
		      //  System.out.println("pro="+pro1+" pro2 = "+pro2);
		        System.out.println(res1);
		    }
		}
		
//		solution end \(^-^)/
//		                |
//		               / \
		}
	}