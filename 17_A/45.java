import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
public class Main
{
    Scanner cin;
    int []prime;
    int top;
    void work()
    {
        cin=new Scanner(System.in); 
        int n=cin.nextInt();
        int k=cin.nextInt();
        top=0;
        prime=new int[2000];
        for(int i=2;i<=n;i++)
        {
        	if(isprime(i))
        		prime[top++]=i;
        }
        int cnt=0;
        for(int i=0;i<top;i++)
        {
        	if(cando(prime[i]))
        		cnt++;
        }
        if(cnt>=k) System.out.println("YES");
        else System.out.println("NO");
    }
    boolean cando(int n)
    {
    	for(int i=0;i<top-1;i++)
    	{
    		if(prime[i]+prime[i+1]+1==n) return true;
    	}
    	return false;
    }
    boolean isprime(int n)
    {
    	for(int i=2;i*i<=n;i++)
    		if(n%i==0)return false;
    	return true;
    }
  public static void main(String args[]) throws Exception 
  { 
   
   new Main().work();
  } 


}  

