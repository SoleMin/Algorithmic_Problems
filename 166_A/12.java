import java.util.*;

import java.io.*;
public class C{
		public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt(),key=in.nextInt(),ans=0;
		int[] a = new int[101], b = new int[101];
		for (int i=1;i<=n;i++) {a[i]=in.nextInt();b[i]=in.nextInt();}
		for (int i=1;i<n;i++)
			for (int j=i+1;j<=n;j++)
				if (a[i]<a[j] || (a[i]==a[j] && b[i]>b[j])) {
		int yed = a[i];a[i]=a[j];			a[j]=yed;
		yed = b[i];b[i]=b[j];b[j]=yed;
				}
		int k=0;
		
		
		for (int i=1;i<=n;i++) {
			if (a[i]==a[i-1] && b[i]==b[i-1]) k++; else 
				{if (i>key && ans==0) ans = k;k=1;}
			
		}
		if (ans == 0) ans = k;
		System.out.println(ans);
		
		}
}
