import java.util.*;
import java.lang.Math; 

public class Main{   
	
	public static void main(String[] args){ 
		Scanner ak=new Scanner(System.in);
		long n,k,x;
		n=ak.nextLong();
		k=ak.nextLong();
		x=(long)((-3+Math.sqrt(9+8*(n+k)))/2);
		System.out.println(n-x);
	}
}