import java.util.*;

public class codea{
	public static void main(String args[])
	{
	  Scanner in = new Scanner(System.in);
	  int n = in.nextInt();
	  int arr[] = new int[n];
	  for(int i =0;i<n;i++)
	   arr[i]= in.nextInt();
	  Arrays.sort(arr);
	  int max =0;
	  boolean check[]= new boolean [n];
	  int count=0;
	  for(int i =0;i<n;i++)
	  {
	   
	   if(!check[i])
	   {
	   	count++;
	   
	   for(int j=i;j<n;j++)
	   {
	   
	    if(arr[j]%arr[i]==0)
	     check[j]=true;
	   }
	   
	   }	
	  }
	  System.out.println(count);	
	}
}