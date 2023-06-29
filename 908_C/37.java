import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<ArrayList<Integer>> list;
    static HashSet<Integer> hs;
    static ArrayList<Integer> tmp;
    //int n=Integer.parseInt(br.readLine());
    //int n=Integer.parseInt(st.nextToken());
    //StringTokenizer st = new StringTokenizer(br.readLine());
    public static double cal(int a,double b,int x,int r)
    {
        r*=2;
        double dis=(r*r) - Math.pow(Math.abs(a-x),2);
        
        dis=Math.sqrt(dis);
        
        dis+=b;
        
        return dis;
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    int n,r;
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    r=Integer.parseInt(st.nextToken());
	    
	    int arr[] = new int[n+1];
	    double cen[] = new double[n+1];
	    
	    int i,j;
	    
	    for(i=1;i<=n;i++)
	    cen[i]=-1.0;
	    
	    st = new StringTokenizer(br.readLine());
	    for(i=1;i<=n;i++)arr[i]=Integer.parseInt(st.nextToken());
	    
	    for(i=1;i<=n;i++)
	    {
	        int f=0;
	        double max=-1.0;
	        for(j=1;j<=n;j++)
	        {
	            if(i!=j && cen[j]!=-1.0 && (Math.abs(arr[i]-arr[j])<=2*r))
	            {
	                max=Math.max(max,cal(arr[j],cen[j],arr[i],r));
	                f=1;
	                
	            }
	        }
	       // System.out.println(i+" "+max);
	        if(f==1)
	        cen[i]=max;
	        else
	        cen[i]=r*1.0;
	    }
	    for(i=1;i<=n;i++)
	    System.out.print(cen[i]+" ");
	}
}
