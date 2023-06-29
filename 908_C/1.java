
import java.util.*;
import java.io.*; 
import java.util.*;
import java.io.*; 
public class MM {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		int n=scanner.nextInt();
		int r=scanner.nextInt();
		int a[]=new int [n];
		for(int i=0;i<n;i++)a[i]=scanner.nextInt();
		double d[]=new double[n];
		for(int i=0;i<n;i++) {
			for(int j=i-1;j>=0;j--) {
				int x=Math.abs(a[i]-a[j]);//计算距离
				if(x<=2*r)d[i]=Math.max(d[i], d[j]+Math.sqrt(4*r*r-x*x));
			}
			if(d[i]==0)d[i]=r;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++)sb.append(d[i]+" ");
		System.out.println(sb);
	}
}











