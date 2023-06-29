import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    while(n-->0){
	        long a=sc.nextLong(),b=sc.nextLong();
	        long ans=0,cur=0;
	        while(a>0 && b>0){
	            if(b>a)a=a+b-(b=a);
	            cur=(a/b);
	            ans+=cur;
	            a-=(cur*b);
	        }
	        System.out.println(ans);
	    }
	}
}
