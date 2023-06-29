import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
	    long n=sc.nextLong();
	    long x=1;
	    long ar=0;
	    tag:for(long i=1;;i++)
	    {
	        ar+=9*i*x;
	        if(ar>=n)
	        {
	            long d = n - (ar-9*i*x);
	            long ans = x+d/i;
	            long p=d%i;
	            if(p==0)
	            {
	                p=i;
	                ans--;
	            }
	            p=i-p;
	            p++;
	            long fns=0;
	            //System.out.println(ans);
	            while(p!=0)
	            {
	                fns=ans%10;
	                ans/=10;
	                p--;
	            }
	            System.out.println(fns);
	            
	            break tag;
	        }
	        x*=10;
	    }
	}
}
