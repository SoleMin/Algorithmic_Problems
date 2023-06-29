import java.util.*;
public class Test 
{
    public static void main(String[] args) 
    {
    	Scanner t = new Scanner(System.in);
    	int n=t.nextInt();
    	int a[]= new int[n];
    	for(int i=0; i<n; i++)
    		a[i]=t.nextInt();
    	Arrays.sort(a);
    	int r=a[0];
    	for(int i=1; i<n; i++)
    			if(a[i]!=r)
    			{
    				System.out.println(a[i]);
    				System.exit(0);
    			}
    	System.out.println("NO");       	
    }
}
