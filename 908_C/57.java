/*
 * code together
 * code better
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	
	static int x[]=new int[1005];
	static double ans[]=new double[1005];
	static int nn,r;
	public static void main(String[] args) throws IOException {
		StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		Scanner sc=new Scanner(System.in);
		int huiwoqingchun=0;
		nn=sc.nextInt();
		r=sc.nextInt();
		for(int i=1;i<=nn;i++) {
			x[i]=sc.nextInt();
		}
		//HashMap<, V>
		ans[1]=r;
		int lajitimu=0;
		for(int i=2;i<=nn;i++) {
			ans[i]=r;
			for(int j=1;j<i;j++) {
				if(Math.abs(x[j]-x[i])>2*r)
					continue;
				ans[i]=Math.max(ans[i], ans[j]+Math.sqrt(4*r*r-(x[j]-x[i])*(x[j]-x[i])));
			}
		}
		double buzhidaoganma=0;
		for(int c=1;c<=nn;c++)
			System.out.printf("%.12f ",ans[c]);
	}
}

