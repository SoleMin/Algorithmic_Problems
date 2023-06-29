/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] A=new int[n];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<n;i++){
			A[i]=Integer.parseInt(s[i]);
		}
		/*int[][] nck=new int[2000][2000];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				nck[i][j]=0;
			}
		}
		for(int i=0;i<=n;i++){
			nck[i][0]=1;
			for(int j=1;j<=i;j++){
				nck[i][j]=nck[i-1][j]+nck[i-1][j-1];
				nck[i][j]%=2;
			}
		}*/
		int inv=0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(A[i]>A[j]){
					inv++;
				}
			}
		}
		StringBuilder sb=new StringBuilder("");
		int m=Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++){
			s=br.readLine().split(" ");
			int li=Integer.parseInt(s[0]);
			int ri=Integer.parseInt(s[1]);
			int tot=ri-li+1;
			inv=inv+tot*(tot-1)/2;
			if(inv%2==0){
				sb.append("even\n");
			}
			else{
				sb.append("odd\n");
			}
		}
		System.out.print(sb);
	}
}