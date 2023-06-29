import java.util.*;
import java.io.*;


public class Solution{
 
	public static Integer INT(String s){
		return Integer.parseInt(s);
	}
 
	public static Long LONG(String s){
		return Long.parseLong(s);
	}
 
	//====================================================================================================================
 
 
 	

	public static void main(String args[])throws IOException{
 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	Scanner in=new Scanner(System.in);	StringBuilder out=new StringBuilder();
 
		long n=in.nextLong(),
			 k=in.nextLong();

		long a=1,
			 b=3,
			 c=-2*(n+k);
		
		long r1=(-b+(long)Math.sqrt(b*b-4*a*c))/(2*a);
		long r2=(-b-(long)Math.sqrt(b*b-4*a*c))/(2*a);

		System.out.println(n-Math.max(r1, r2));
	}
}