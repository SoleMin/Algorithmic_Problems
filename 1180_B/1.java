import java.util.*;
public class prac {
  public static void main(String args[]) 
  {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int[] a=new int[n];
  int ind=-1;
  int min=Integer.MAX_VALUE;
  for(int i=0;i<n;i++)
  {
  a[i]=sc.nextInt();
  if(a[i]>=0)
  a[i]=-a[i]-1;
  if(a[i]<min)
			{
				min=a[i];
				ind =i;
			}
  }
  if(n%2!=0)
  {
    a[ind]=-a[ind]-1;
  }
  for(int i:a)
  System.out.print(i+" ");

  
}
}

