
import java.io.*;
import java.util.*;


public class c {

	static boolean used[][];
	static int n;
	static int m;
	static int a[][];
	
	
	public static void main(String args[])throws Exception{
		Scanner in =new Scanner(new File("input.txt"));//System.in);//
		PrintWriter out=new PrintWriter(new File("output.txt"));//System.out);//
		n = in.nextInt();
		m = in.nextInt();
		int k = in.nextInt();
		//a=new int[n+1][m+1];
		/*for (int i = 1; i<=n; i++)
			for (int j = 1; j<=m; j++)
				a[i][j] = 40001;
		*/
		int x[]=new int[k];
		int y[]=new int[k];
		for (int i = 0; i<k; i++){
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		int max = 0;
		int xx = 1; int yy= 1;
		for (int i = 1; i<=n; i++)
			for (int j = 1; j<=m; j++){
				int count = Integer.MAX_VALUE;
				for (int l =0; l<k; l++)
					count = Math.min(Math.abs(i - x[l]) + Math.abs(j - y[l]), count);
		
				if (max < count){
					max = count;
					xx = i; yy = j;
				}
			}
		out.println(xx + " " + yy);
		out.close();
	}
}
