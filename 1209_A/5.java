import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    String s=br.readLine();
	    String ss[]=s.split(" ");
	    int arr[]=new int[n];
	    for(int i=0;i<n;i++)
	    arr[i]=Integer.parseInt(ss[i]);
	    Arrays.sort(arr);
	    int coun=0,coun2=0;
	    for(int i=arr[0],k=0;k<n;)
	    {
	        for(int j=k;j<n;j++)
	        {
	            if(arr[j]%i==0)
	            {
	                arr[j]=-1;
	                coun2++;
	            }
	        }
	        Arrays.sort(arr);
	        k=coun2;
	        coun++;
	        if(coun2<n)
	        i=arr[coun2];
	        else
	        break;
	        
	    }
		System.out.println(coun);
	}
}
