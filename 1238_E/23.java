

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();int g[]=new int[1<<m];
		StringBuffer s=new StringBuffer(sc.next());
		s=s.insert(0, 'A');
		int D=(1<<m)-1;
		for(int i=1;i<n;i++)
		{
			int x=s.charAt(i)-'a',y=s.charAt(i+1)-'a';
			if(x!=y)
				g[1<<x|1<<y]++;
		}
		for(int j=0;j<m;j++)
			for(int i=0;i<=D;i++)
				if((i>>j&1)!=0)
					g[i]+=g[i^1<<j];
		int f[]=new int[1<<m];
		Arrays.fill(f, Integer.MAX_VALUE/2);
		f[0]=0;
		for(int i=0;i<=D;i++)
			for(int j=0;j<m;j++)
				if((i>>j&1)==0)
					f[i|1<<j]=Math.min(f[i|1<<j], f[i]+g[D]-g[i]-g[D^i]);
		System.out.println(f[D]);
	}

}
