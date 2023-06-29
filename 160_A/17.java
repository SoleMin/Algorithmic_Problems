	import java.util.*;
	public class A {
	public static void main(String args[]){
    Scanner in = new Scanner(System.in);
 int n=in.nextInt(),s=0;
 int[] a= new int[n];
 for (int i=0;i<n;i++) {a[i]=in.nextInt(); s+=a[i];}
 Arrays.sort(a); int k=0,ans=0;
 for (int i=n-1;i>=0;i--)
	 if (k<=s/2) {k+=a[i];ans++;}
 System.out.println(ans);
 
		
	    	}
		}
